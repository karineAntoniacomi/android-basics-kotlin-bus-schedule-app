package com.example.busschedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.busschedule.database.schedule.ScheduleDao
import com.example.busschedule.viewmodels.BusScheduleViewModel


/* O objetivo da classe BusScheduleViewModel do ViewModel é ter reconhecimento
de ciclo de vida, ela precisa ser instanciada por um objeto que possa responder
a eventos do ciclo de vida. Para facilitar isto e evitar o reprocessamento nas
fragments, cria-se a classe factory que instancia objetos de modelo de visualização. */
class BusScheduleViewModelFactory(
    private  val scheduleDao: ScheduleDao
    ) : ViewModelProvider.Factory {

    /*  Possibilita instanciar um objeto BusScheduleViewModelFactory com
    BusScheduleViewModelFactory.create(), para que o modelo de visualização possa
    reconhecer o ciclo de vida sem que isso precise ser processado pelo fragmento. */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return  BusScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}