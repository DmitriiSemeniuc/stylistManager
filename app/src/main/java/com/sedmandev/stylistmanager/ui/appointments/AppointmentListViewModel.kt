package com.sedmandev.stylistmanager.ui.appointments

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.sedmandev.stylistmanager.R
import com.sedmandev.stylistmanager.base.BaseViewModel
import com.sedmandev.stylistmanager.model.Appointment
import com.sedmandev.stylistmanager.model.AppointmentDao
import com.sedmandev.stylistmanager.network.AppointmentApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AppointmentListViewModel(private val appointmentDao: AppointmentDao) : BaseViewModel() {

  private val TAG = AppointmentViewModel::class.java.simpleName

  @Inject
  lateinit var appointmentApi: AppointmentApi

  val appointmentListAdapter: AppointmentListAdapter = AppointmentListAdapter()

  val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
  val errorMessage: MutableLiveData<Int> = MutableLiveData()
  val errorClickListener = View.OnClickListener { loadAppointments() }

  private lateinit var subscription: Disposable

  init {
    loadAppointments()
  }

  override fun onCleared() {
    super.onCleared()
    subscription.dispose()
  }

  private fun loadAppointments(){
    subscription = Observable.fromCallable { appointmentDao.all }
        .concatMap {
          dbAppointmentList ->
          if(dbAppointmentList.isEmpty())
            appointmentApi.getAppointments().concatMap {
              apiAppointmentList -> appointmentDao.insertAll(*apiAppointmentList.toTypedArray())
              Observable.just(apiAppointmentList)
            }
          else
            Observable.just(dbAppointmentList)
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSubscribe { onRetrieveAppointmentListStart() }
        .doOnTerminate { onRetrieveAppointmentListFinish() }
        .subscribe(
            { result -> onRetrieveAppointmentListSuccess(result) },
            { t ->  onRetrieveAppointmentListError(t) }
        )
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