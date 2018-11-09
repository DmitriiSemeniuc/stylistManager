package com.sedmandev.stylistmanager.ui.appointments

import androidx.lifecycle.MutableLiveData
import com.sedmandev.stylistmanager.base.BaseViewModel
import com.sedmandev.stylistmanager.model.Appointment

class AppointmentViewModel : BaseViewModel() {

  private val appointmentTitle = MutableLiveData<String>()
  private val appointmentCompleted = MutableLiveData<Boolean>()

  fun bind(appointment: Appointment){
    appointmentTitle.value = appointment.title
    appointmentCompleted.value = appointment.completed
  }

  fun getAppointmentTitle(): MutableLiveData<String>{
    return appointmentTitle
  }

  fun getAppointmentCompleted():MutableLiveData<Boolean>{
    return appointmentCompleted
  }
}