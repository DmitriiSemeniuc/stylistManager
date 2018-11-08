package com.sedmandev.stylistmanager.injection

import com.sedmandev.stylistmanager.base.interfaces.BaseView
import com.sedmandev.stylistmanager.base.interfaces.Router
import com.sedmandev.stylistmanager.modules.AppModule
import com.sedmandev.stylistmanager.ui.login.LoginPresenter
import com.sedmandev.stylistmanager.ui.splash.SplashPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface PresenterInjector {
  /**
   * Injects required dependencies into the specified presenter.
   * @param presenter presenter in which to inject the dependencies
   */
  fun inject(presenter: SplashPresenter)
  fun inject(presenter: LoginPresenter)

  @Component.Builder
  interface Builder {
    fun build(): PresenterInjector
    fun appModule(appModule: AppModule): Builder
    @BindsInstance
    fun baseView(baseView: BaseView): Builder
    @BindsInstance
    fun router(router: Router) : Builder
  }
}