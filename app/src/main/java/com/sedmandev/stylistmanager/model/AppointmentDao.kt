package com.sedmandev.stylistmanager.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AppointmentDao {
  @get:Query("SELECT * FROM appointment")
  val all: List<Appointment>

  @Insert
  fun insertAll(vararg appointment: Appointment)
}