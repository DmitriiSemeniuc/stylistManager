package com.sedmandev.stylistmanager.base.interfaces

interface Presenter {

  fun onCreate()

  fun onStart()

  fun onResume()

  fun onPause()

  fun onStop()

  fun onDestroy()
}