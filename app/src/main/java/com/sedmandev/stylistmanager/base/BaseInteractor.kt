package com.sedmandev.stylistmanager.base

import com.sedmandev.stylistmanager.base.interfaces.Interactor
import com.sedmandev.stylistmanager.injection.DaggerInteractorInjector
import com.sedmandev.stylistmanager.injection.InteractorInjector
import com.sedmandev.stylistmanager.modules.AppModule

abstract class BaseInteractor: Interactor {

  abstract fun inject()

  protected val injector: InteractorInjector = DaggerInteractorInjector
      .builder()
      .appModule(AppModule)
      .build()

  init {
    this.inject()
  }
}