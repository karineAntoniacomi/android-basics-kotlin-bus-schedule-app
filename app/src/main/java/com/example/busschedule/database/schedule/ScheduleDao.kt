package com.example.busschedule.database.schedule

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    /* A consulta é especificada como uma string transmitida para uma anotação @Query.
    A função getAll() retorna uma lista de objetos Schedule, incluindo a anotação @Query, */
    @Query("SELECT * FROM Schedule ORDER BY arrival_time ASC")
    // Flow permite usar o fluxo e atualizar a UI conforme atualiza o BD em tempo real
    fun getAll() : Flow<List<Schedule>>


    /* (:) -> referencia valores kotlin. No caso, :stopName é o parâmetro da função. Os resultados são
    organizados em ordem crescente por horário de chegada. A função getByStopName() usa um parâmetro
     String stopName e retorna uma List de objetos Schedule com uma anotação @Query. */
    @Query("SELECT * FROM Schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC ")
    fun getByStopName(stopName: String): Flow<List<Schedule>>
}