package com.sedmandev.stylistmanager.injection

import com.sedmandev.stylistmanager.injection.module.AppModule
import com.sedmandev.stylistmanager.injection.module.NetworkModule
import com.sedmandev.stylistmanager.ui.appointments.AppointmentListPresenter
import dagger.Component
import javax.inject.Singleton
/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface PresenterInjector {
  /**
   * Injects required dependencies into the specified presenter.
   * @param presenter presenter in which to inject the dependencies
   */
  fun inject(presenter: AppointmentListPresenter)

  @Component.Builder
  interface Builder {
    fun build(): PresenterInjector
  }
}