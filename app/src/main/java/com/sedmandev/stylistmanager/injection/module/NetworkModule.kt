package com.sedmandev.stylistmanager.injection.module

import com.sedmandev.stylistmanager.model.database.repository.AppointmentRepository
import com.sedmandev.stylistmanager.network.AppointmentApi
import com.sedmandev.stylistmanager.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Module which provides all required dependencies about network
 */
@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NetworkModule {

  /**
   * Provides the Appointment service implementation.
   * @param retrofit the Retrofit object used to instantiate the service
   * @return the Appointment service implementation.
   */
  @Provides
  @Reusable
  @JvmStatic
  internal fun provideAppointmentApi(retrofit: Retrofit): AppointmentApi {
    return retrofit.create(AppointmentApi::class.java)
  }

  /**
   * Provides the AppointmentRepository implementation.
   * @param AppointmentApi the AppointmentApi object used to instantiate the AppointmentRepository
   * @return the AppointmentRepository implementation.
   */
  @Provides
  @Reusable
  @JvmStatic
  internal fun provideAppointmentRepository(api: AppointmentApi): AppointmentRepository {
    return AppointmentRepository(api)
  }

  /**
   * Provides the Retrofit object.
   * @return the Retrofit object
   */
  @Provides
  @Reusable
  @JvmStatic
  internal fun provideRetrofitInterface(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .build()
  }
}
