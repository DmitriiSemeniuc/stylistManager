package com.sedmandev.stylistmanager.ui.splash

import com.sedmandev.stylistmanager.base.BasePresenter
import com.sedmandev.stylistmanager.base.interfaces.Router
import com.sedmandev.stylistmanager.ui.login.LoginActivity
import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class SplashPresenter(splashView: SplashView, splashRouter: SplashRouter,
                      private val interactor: SplashInteractor) :
    BasePresenter<SplashView, Router>(splashView, splashRouter) {

  /**
   * Inject this presenter to the PresenterInjector
   * */
  override fun inject() {
    injector.inject(this)
  }

  override fun onCreate() {
    Completable.complete()
        .delay(3, TimeUnit.SECONDS)
        .doOnComplete { router.navigateTo(view.getContext(), LoginActivity::class.java) }
        .subscribe()
  }

  override fun onStart() {
    // TODO:
  }

  override fun onResume() {
    // TODO:
  }

  override fun onPause() {
    // TODO:
  }

  override fun onStop() {
    // TODO:
  }

  override fun onDestroy() {
    subscription?.dispose()
  }

  private var subscription: Disposable? = null
}