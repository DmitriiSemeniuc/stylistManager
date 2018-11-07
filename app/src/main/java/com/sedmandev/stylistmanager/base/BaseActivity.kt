package com.sedmandev.stylistmanager.base

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import com.sedmandev.stylistmanager.base.interfaces.BaseView
import com.sedmandev.stylistmanager.base.interfaces.Router
import com.sedmandev.stylistmanager.utils.NetworkHelper.Companion.ACTION_INTERNET_CONNECTION

/**
 * Base activity of all Activity classes
 * It provides required methods, presenter installation and calls.
 *
 * @param P the type of the presenter the Activity is base on.
 * */
abstract class BaseActivity<P: BasePresenter<BaseView, Router>> : BaseView, AppCompatActivity() {

  private var internetConnectionIntent: IntentFilter = IntentFilter(ACTION_INTERNET_CONNECTION)

  protected lateinit var presenter: P

  protected abstract val contentViewId: Int

  protected abstract val statusBarColor: Int

  @Suppress("UNCHECKED_CAST")
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if(contentViewId != -1) {
      setContentView(contentViewId)
    }

    val viewModel = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    if(viewModel.presenter == null) {
      viewModel.presenter = instantiatePresenter()
    }

    presenter = viewModel.presenter as P
    presenter.attachLifecycle(lifecycle)
  }

  override fun onStart() {
    super.onStart()
    if(statusBarColor != -1) {
      setStatusBarColor()
    }
  }

  protected abstract fun instantiatePresenter(): P

  private fun setStatusBarColor() {
    setStatusBarColor(this, statusBarColor)
  }

  private fun setStatusBarColor(activity: Activity, @ColorRes color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      val window = activity.window

      // clear FLAG_TRANSLUCENT_STATUS flag:
      window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

      // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

      // finally change the color
      window.statusBarColor = ContextCompat.getColor(activity, color)
    }
  }

  override fun getContext(): Context {
    return this
  }
}