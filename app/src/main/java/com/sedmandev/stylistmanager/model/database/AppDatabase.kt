package com.sedmandev.stylistmanager.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sedmandev.stylistmanager.model.Appointment
import com.sedmandev.stylistmanager.model.AppointmentDao

@Database(entities = [Appointment::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

  abstract fun appointmentDao() : AppointmentDao
}