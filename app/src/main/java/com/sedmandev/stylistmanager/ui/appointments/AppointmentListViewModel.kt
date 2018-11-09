package com.sedmandev.stylistmanager.ui.appointments

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.sedmandev.stylistmanager.R
import com.sedmandev.stylistmanager.base.BaseViewModel
import com.sedmandev.stylistmanager.model.Appointment
import com.sedmandev.stylistmanager.model.AppointmentDao
import com.sedmandev.stylistmanager.model.database.repository.AppointmentRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AppointmentListViewModel(private val appointmentDao: AppointmentDao) : BaseViewModel() {

  private val TAG = AppointmentViewModel::class.java.simpleName

  @Inject
  lateinit var appointmentRepository: AppointmentRepository

  lateinit var subscription: Disposable
  val appointmentListAdapter: AppointmentListAdapter = AppointmentListAdapter()
  val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
  val errorMessage: MutableLiveData<Int> = MutableLiveData()

  init {
    appointmentRepository.appointmentDao = appointmentDao
    loadAppointments()
  }

  override fun onCleared() {
    super.onCleared()
    subscription.dispose()
  }

  private fun loadAppointments(){
    subscription = getAppointments()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe { onRetrieveAppointmentListStart() }
        .doOnTerminate { onRetrieveAppointmentListFinish() }
        .subscribe(
            { result -> onRetrieveAppointmentListSuccess(result) },
            { t ->  onRetrieveAppointmentListError(t) }
        )
  }

  fun getAppointments(): Observable<List<Appointment>> {
    return appointmentRepository.getAppointments()
        .onErrorReturn {
          emptyList<Appointment>()
        }
  }

  private fun onRetrieveAppointmentListStart(){
    loadingVisibility.value = View.VISIBLE
    errorMessage.value = null
  }

  private fun onRetrieveAppointmentListFinish(){
    loadingVisibility.value = View.GONE
  }

  private fun onRetrieveAppointmentListSuccess(appointmentList:List<Appointment>){
    appointmentListAdapter.updateAppointmentList(appointmentList)
  }

  private fun onRetrieveAppointmentListError(t: Throwable){
    errorMessage.value = R.string.appointment_error
    Log.e(TAG, t.message)
  }
}