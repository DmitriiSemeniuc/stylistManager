package com.sedmandev.stylistmanager.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import com.sedmandev.stylistmanager.base.interfaces.Presenter
import com.sedmandev.stylistmanager.injection.DaggerPresenterInjector
import com.sedmandev.stylistmanager.injection.PresenterInjector

/**
 * Parent presenter of all presenters.
 * It provides initial injections and required methods.
 *
 * @property Injector The injector used to inject required dependencies
 * */
abstract class BasePresenter : Presenter, LifecycleObserver {
  abstract fun inject()

  protected val injector: PresenterInjector = DaggerPresenterInjector
      .builder()
      .build()

  init {
    this.inject()
  }

  fun attachLifecycle(lifecycle: Lifecycle) {
    lifecycle.addObserver(this)
  }

  fun detachLifecycle(lifecycle: Lifecycle) {
    lifecycle.removeObserver(this)
  }
}