package com.example.busschedule.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.database.schedule.ScheduleDao

@Database(entities = arrayOf(Schedule::class), version = 1)
/* A classe AppDatabase oferece controle total sobre os modelos, classes DAO e outras configurações do BD necessárias. */
abstract class AppDatabase: RoomDatabase() {

    // Classe abstrata que retorna um ScheduleDao
    abstract fun scheduleDao(): ScheduleDao

    // Objeto Complementar garante que exista somente uma instância
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // Função que retorna instância de AppDatabase existente ou cria o BD
        // Operador Elvis p/ retornar a instância atual do bd ou criá-la
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