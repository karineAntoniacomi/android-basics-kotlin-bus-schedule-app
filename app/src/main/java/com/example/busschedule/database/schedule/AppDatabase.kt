package com.example.busschedule.database.schedule

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Schedule::class), version = 1)
/* A classe AppDatabase oferece controle total sobre os modelos, classes DAO e outras configurações do BD necessárias. */
abstract class AppDatabase: RoomDatabase() {
    // possibilita que outras classes acessem as classes DAO
    abstract fun scheduleDao(): ScheduleDao

    // Objeto Complementar garante que exista somente uma instância
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Função que retorna instância de AppDatabase existente ou cria o BD
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                     // createFromAsset() carrega os dados existentes
                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}