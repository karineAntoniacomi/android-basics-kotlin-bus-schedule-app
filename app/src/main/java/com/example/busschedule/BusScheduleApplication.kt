package com.example.busschedule

import android.app.Application
import com.example.busschedule.database.AppDatabase

/* Permite que a classe classe AppDatabase seja utilizável.
 Fornece uma subclasse personalizada da classe Application  */
class BusScheduleApplication : Application() {
   // cria uma propriedade lazy que retorna resultado da chamada de getDatabase().
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}