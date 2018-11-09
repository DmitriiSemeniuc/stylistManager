package com.sedmandev.stylistmanager.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Single

@Dao
interface AppointmentDao {

  @Query("SELECT * FROM appointment")
  fun getAppointments(): Single<List<Appointment>>

  @Insert
  fun insertAll(vararg appointment: Appointment)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(appointment: Appointment)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertAll(appointments: List<Appointment>)
}
