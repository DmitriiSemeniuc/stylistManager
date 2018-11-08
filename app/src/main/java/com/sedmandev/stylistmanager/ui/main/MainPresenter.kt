package com.sedmandev.stylistmanager.ui.main

import android.util.Log
import com.sedmandev.stylistmanager.base.BasePresenter

class MainPresenter(mainView: MainView, mainRouter: MainRouter, private val interactor: MainInteractor) :
    BasePresenter<MainView, MainRouter>(mainView, mainRouter) {

  val TAG = MainPresenter::class.java.simpleName

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