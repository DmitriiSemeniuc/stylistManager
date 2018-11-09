package com.sedmandev.stylistmanager.ui.appointments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sedmandev.stylistmanager.R
import com.sedmandev.stylistmanager.databinding.ItemAppointmentBinding
import com.sedmandev.stylistmanager.model.Appointment

class AppointmentListAdapter: RecyclerView.Adapter<AppointmentListAdapter.ViewHolder>() {

  private lateinit var appointmentList: List<Appointment>

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding: ItemAppointmentBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
        R.layout.item_appointment, parent,false)
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(appointmentList[position])
  }

  override fun getItemCount(): Int {
    return if(::appointmentList.isInitialized) appointmentList.size else 0
  }

  fun updateAppointmentList(appointmentList: List<Appointment>) {
    this.appointmentList = appointmentList
    notifyDataSetChanged()
  }

  class ViewHolder(private val binding: ItemAppointmentBinding): RecyclerView.ViewHolder(binding.root) {

    private val viewModel = AppointmentViewModel()

    fun bind(appointment: Appointment) {
      viewModel.bind(appointment)
      binding.viewModel = viewModel
    }
  }
}