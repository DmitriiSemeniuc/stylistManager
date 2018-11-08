package com.sedmandev.stylistmanager.injection

import com.sedmandev.stylistmanager.modules.AppModule
import com.sedmandev.stylistmanager.ui.login.LoginInteractor
import com.sedmandev.stylistmanager.ui.main.MainInteractor
import com.sedmandev.stylistmanager.ui.splash.SplashInteractor
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface InteractorInjector {

  /**
   * Injects required dependencies into the specified interactor.
   * @param interactor in which to inject the dependencies.
   * */

  fun inject(interactor: SplashInteractor)
  fun inject(interactor: LoginInteractor)
  fun inject(interactor: MainInteractor)

  @Component.Builder
  interface Builder {
    fun build(): InteractorInjector

    fun appModule(appModule: AppModule): Builder
  }
}
