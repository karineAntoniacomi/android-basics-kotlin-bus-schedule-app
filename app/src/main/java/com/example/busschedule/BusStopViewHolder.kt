package com.example.busschedule

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.busschedule.database.schedule.Schedule
import com.example.busschedule.databinding.BusStopItemBinding
import java.text.SimpleDateFormat
import java.util.*

class BusStopViewHolder(private var binding: BusStopItemBinding): RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SimpleDateFormat")

    // Função que define o texto de stopNameTextView como o nome do ponto
    // de ônibus e o texto da arrivalTimeTextView como a data formatada.
    fun bind(schedule: Schedule) {
        binding.stopNameTextView.text = schedule.stopName
        binding.arrivalTimeTextView.text = SimpleDateFormat(
            "h:mm a").format(
            Date(schedule.arrivalTime.toLong() * 1000)
        )
    }
}