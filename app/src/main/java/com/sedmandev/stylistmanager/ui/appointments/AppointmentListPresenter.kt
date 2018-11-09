package com.sedmandev.stylistmanager.ui.appointments

import android.util.Log
import com.sedmandev.stylistmanager.base.BasePresenter

class AppointmentListPresenter : BasePresenter() {

  val TAG = AppointmentListPresenter::class.java.simpleName

  override fun inject() {
    injector.inject(this)
  }

  override fun onCreate() {
    Log.d(TAG, "onCreate")
  }

  override fun onStart() {
    Log.d(TAG, "onStart")
  }

  override fun onResume() {
    Log.d(TAG, "onResume")
  }

  override fun onPause() {
    Log.d(TAG, "onPause")
  }

  override fun onStop() {
    Log.d(TAG, "onStop")
  }

  override fun onDestroy() {
    Log.d(TAG, "onDestroy")
  }
}