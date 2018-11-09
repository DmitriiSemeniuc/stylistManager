package com.sedmandev.stylistmanager.ui.login

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import com.sedmandev.stylistmanager.base.interfaces.BaseView

interface LoginView : BaseView {

  fun getActivity() : Activity

  fun getFragmentActivity() : FragmentActivity
}