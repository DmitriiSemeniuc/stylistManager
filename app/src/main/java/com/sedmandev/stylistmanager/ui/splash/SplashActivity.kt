package com.sedmandev.stylistmanager.ui.splash

import android.os.Bundle
import com.sedmandev.stylistmanager.R
import com.sedmandev.stylistmanager.base.BaseActivity

class SplashActivity : BaseActivity<SplashPresenter>(), SplashView {

  override val contentViewId: Int
    get() = R.layout.activity_splash

  override val statusBarColor: Int
    get() = android.R.color.black

  override fun instantiatePresenter(): SplashPresenter {
    return SplashPresenter(this, SplashRouter(), SplashInteractor())
  }

  /**
   * DataBinding instance
   */
  //private lateinit var binding: ActivitySplashBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    //setContentView(R.layout.activity_splash)

    //binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

    presenter.onCreate()
  }

  override fun initViews() {
    // TODO:
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.onDestroy()
  }
}