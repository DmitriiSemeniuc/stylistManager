package com.sedmandev.stylistmanager.ui.main

import com.sedmandev.stylistmanager.R
import com.sedmandev.stylistmanager.base.BaseActivity

class MainActivity : BaseActivity<MainPresenter>(), MainView {

  override val contentViewId: Int
    get() = R.layout.activity_main

  override val statusBarColor: Int
    get() = R.color.colorPrimaryDark

  override fun instantiatePresenter(): MainPresenter {
    return MainPresenter(this, MainRouter(), MainInteractor())
  }

  override fun initViews() {

  }
}