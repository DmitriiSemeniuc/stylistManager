package com.sedmandev.stylistmanager.base

import androidx.lifecycle.ViewModel
import com.sedmandev.stylistmanager.base.interfaces.Presenter
import com.sedmandev.stylistmanager.injection.component.DaggerViewModelInjector
import com.sedmandev.stylistmanager.injection.component.ViewModelInjector
import com.sedmandev.stylistmanager.injection.module.NetworkModule
import com.sedmandev.stylistmanager.ui.appointments.AppointmentListViewModel
import com.sedmandev.stylistmanager.ui.appointments.AppointmentViewModel

abstract class BaseViewModel : ViewModel() {

  private val injector: ViewModelInjector = DaggerViewModelInjector
      .builder()
      .networkModule(NetworkModule)
      .build()

  init {
    inject()
  }

  private fun inject() {
    when (this) {
      is AppointmentListViewModel -> injector.inject(this)
      is AppointmentViewModel -> injector.inject(this)
    }
  }

  var presenter: Presenter? = null
    set (value) {
      if (field == null) {
        field = value
      }
    }

  override fun onCleared() {
    super.onCleared()
    presenter?.onDestroy()
    presenter = null
  }
}