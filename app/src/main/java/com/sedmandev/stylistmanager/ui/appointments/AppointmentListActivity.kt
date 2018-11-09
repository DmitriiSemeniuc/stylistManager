package com.sedmandev.stylistmanager.ui.appointments

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sedmandev.stylistmanager.R
import com.sedmandev.stylistmanager.base.BaseActivity
import com.sedmandev.stylistmanager.databinding.ActivityAppointmentListBinding

class AppointmentListActivity : BaseActivity<AppointmentListViewModel,
    ActivityAppointmentListBinding, AppointmentListPresenter>(), AppointmentListView {

  override val viewModelClassName: Class<AppointmentListViewModel>
    get() = AppointmentListViewModel::class.java

  override val contentViewId: Int
    get() = R.layout.activity_appointment_list

  override fun instantiatePresenter(): AppointmentListPresenter {
    return AppointmentListPresenter()
  }

  override fun onBindingInitialized(binding: ActivityAppointmentListBinding) {
    binding.appointmentList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
  }

  override fun onViewModelInitialized(viewModel: AppointmentListViewModel) {
    binding.viewModel = viewModel
  }
}