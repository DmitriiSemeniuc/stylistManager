package com.sedmandev.stylistmanager.base

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import com.sedmandev.stylistmanager.base.interfaces.BaseView
import com.sedmandev.stylistmanager.base.interfaces.Presenter
import com.sedmandev.stylistmanager.base.interfaces.Router
import com.sedmandev.stylistmanager.injection.DaggerPresenterInjector
import com.sedmandev.stylistmanager.injection.PresenterInjector
import com.sedmandev.stylistmanager.modules.AppModule

/**
 * Parent presenter of all presenters.
 * It provides initial injections and required methods.
 *
 * @param V the type of the View the presenter is based on.
 * @param View the view the presenter is base on.
 * @property Injector The injector used to inject required dependencies
 * */
abstract class BasePresenter<out V : BaseView, out R : Router>(protected val view: V,
                                                               protected val router: R) : Presenter, LifecycleObserver {
  abstract fun inject()

  protected val injector: PresenterInjector = DaggerPresenterInjector
      .builder()
      .baseView(view)
      .router(router)
      .appModule(AppModule)
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