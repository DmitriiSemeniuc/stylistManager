package com.sedmandev.stylistmanager.base

import android.content.Context
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProviders
import com.sedmandev.stylistmanager.base.interfaces.BaseView
import com.sedmandev.stylistmanager.injection.ViewModelFactory
import com.sedmandev.stylistmanager.utils.NetworkHelper.Companion.ACTION_INTERNET_CONNECTION

/**
 * Base activity of all Activity classes
 * It provides required methods, presenter installation and calls.
 *
 * */
abstract class BaseActivity<V: BaseViewModel, B: ViewDataBinding, P: BasePresenter> : BaseView, AppCompatActivity() {

  private var internetConnectionIntent: IntentFilter = IntentFilter(ACTION_INTERNET_CONNECTION)

  protected abstract val contentViewId: Int

  protected abstract val viewModelClassName: Class<V>

  protected lateinit var binding: B

  protected lateinit var viewModel: V

  protected abstract fun instantiatePresenter(): P

  protected abstract fun onBindingInitialized(binding: B)

  protected abstract fun onViewModelInitialized(viewModel: V)


  @Suppress("UNCHECKED_CAST")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = DataBindingUtil.setContentView(this, contentViewId)
    onBindingInitialized(binding)

    viewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(viewModelClassName)
    if(viewModel.presenter == null) {
      viewModel.presenter = instantiatePresenter()
    }

    val presenter = viewModel.presenter as P
    presenter.attachLifecycle(lifecycle)

    onViewModelInitialized(viewModel)
  }

  @Suppress("UNCHECKED_CAST")
  override fun onDestroy() {
    val presenter = viewModel.presenter as P
    presenter.detachLifecycle(lifecycle)
    super.onDestroy()
  }

  override fun getContext(): Context {
    return this
  }
}