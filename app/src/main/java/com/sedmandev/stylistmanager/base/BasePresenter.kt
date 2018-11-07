package com.sedmandev.stylistmanager.base

import com.sedmandev.stylistmanager.base.interfaces.BaseView
import com.sedmandev.stylistmanager.base.interfaces.Presenter

/**
 * Parent presenter of all presenters.
 * It provides initial injections and required methods.
 *
 * @param V the type of the View the presenter is based on.
 * @param View the view the presenter is base on.
 * @property Injector The injector used to inject required dependencies
 * */
abstract class BasePresenter<out V: BaseView>(protected val view: V) : Presenter {
  abstract fun inject()
}