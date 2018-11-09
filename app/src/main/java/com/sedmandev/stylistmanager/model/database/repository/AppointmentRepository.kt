package com.sedmandev.stylistmanager.model.database.repository

import android.annotation.SuppressLint
import android.util.Log
import com.sedmandev.stylistmanager.model.Appointment
import com.sedmandev.stylistmanager.model.AppointmentDao
import com.sedmandev.stylistmanager.network.AppointmentApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class AppointmentRepository(val appointmentApi: AppointmentApi) {

  lateinit var appointmentDao: AppointmentDao

  val TAG = AppointmentRepository::class.java.simpleName

  fun getAppointments(): Observable<List<Appointment>> {
    return Observable.concatArray(
        getAppointmentsFromDb(),
        getAppointmentFromApi())
  }

  fun getAppointmentsFromDb(): Observable<List<Appointment>> {
    return appointmentDao.getAppointments().filter { it.isNotEmpty() }
        .toObservable()
        .doOnNext {
          Log.d(TAG, "Dispatching ${it.size} users from DB...")
        }
  }

  fun getAppointmentFromApi(): Observable<List<Appointment>> {
    return appointmentApi.getAppointments()
        .doOnNext {
          Log.d(TAG, "Dispatching ${it.size} users from API...")
          storeAppointmentsInDb(it)
        }
  }

  @SuppressLint("CheckResult")
  fun storeAppointmentsInDb(appointments: List<Appointment>) {
    Observable.fromCallable { appointmentDao.insertAll(appointments) }
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.io())
        .subscribe {
          Log.d(TAG, "Inserted ${appointments.size} appointments from API to DB...")
        }
  }
}