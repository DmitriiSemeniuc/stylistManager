package com.sedmandev.stylistmanager.base

import android.arch.lifecycle.ViewModel
import com.sedmandev.stylistmanager.base.interfaces.Presenter

class BaseViewModel : ViewModel() {

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