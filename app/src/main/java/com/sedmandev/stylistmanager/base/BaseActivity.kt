package com.sedmandev.stylistmanager.base

import android.support.v7.app.AppCompatActivity
import com.sedmandev.stylistmanager.base.interfaces.BaseView

/**
 * Base activity of all Activity classes
 * It provides required methods, presenter installation and calls.
 *
 * @param P the type of the presenter the Activity is base on.
 * */
abstract class BaseActivity<P: BasePresenter<BaseView>> : BaseView, AppCompatActivity() {
  // TODO:
}