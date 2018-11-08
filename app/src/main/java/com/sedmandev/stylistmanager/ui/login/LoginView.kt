package com.sedmandev.stylistmanager.ui.login

import android.app.Activity
import android.support.v4.app.FragmentActivity
import com.sedmandev.stylistmanager.base.interfaces.BaseView

interface LoginView : BaseView {

  fun getActivity() : Activity

  fun getFragmentActivity() : FragmentActivity
}