package com.sedmandev.stylistmanager.injection.component

import com.sedmandev.stylistmanager.injection.module.NetworkModule
import com.sedmandev.stylistmanager.ui.appointments.AppointmentListViewModel
import com.sedmandev.stylistmanager.ui.appointments.AppointmentViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
  /**
   * Injects required dependencies into the specified PostListViewModel.
   * @param viewModel viewModel in which to inject the dependencies
   */
  fun inject(viewModel: AppointmentListViewModel)
  fun inject(viewModel: AppointmentViewModel)

  @Component.Builder
  interface Builder {
    fun build(): ViewModelInjector
    fun networkModule(networkModule: NetworkModule): Builder
  }
}