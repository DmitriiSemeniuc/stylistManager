package com.sedmandev.stylistmanager.network

import com.sedmandev.stylistmanager.model.Appointment
import io.reactivex.Observable
import retrofit2.http.GET

interface AppointmentApi {

  @GET("/todos")
  fun getAppointments(): Observable<List<Appointment>>
}