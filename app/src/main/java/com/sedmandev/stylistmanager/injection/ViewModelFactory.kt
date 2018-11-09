package com.sedmandev.stylistmanager.injection

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.sedmandev.stylistmanager.model.database.AppDatabase
import com.sedmandev.stylistmanager.ui.appointments.AppointmentListViewModel

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {

    if (modelClass.isAssignableFrom(AppointmentListViewModel::class.java)) {
      val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "appointments").build()
      @Suppress("UNCHECKED_CAST")
      return AppointmentListViewModel(db.appointmentDao()) as T
    }

    throw IllegalArgumentException("Unknown ViewModel class")
  }
}