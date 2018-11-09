package com.sedmandev.stylistmanager.ui.splash

import com.sedmandev.stylistmanager.ui.login.LoginActivity
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class SplashPresenter/*(splashView: SplashView) :
    BasePresenter<SplashView>(splashView) {

  *//**
   * Inject this presenter to the PresenterInjector
   * *//*
  override fun inject() {
    injector.inject(this)
  }

  override fun onCreate() {
    Completable.complete()
        .delay(3, TimeUnit.SECONDS)
        .doOnComplete { navigateTo(view.getContext(), LoginActivity::class.java) }
        .subscribe()
  }

  override fun onDestroy() {
    subscription?.dispose()
  }

  private var subscription: Disposable? = null
}*/