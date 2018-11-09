package com.sedmandev.stylistmanager.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.fragment.app.FragmentActivity
import com.sedmandev.stylistmanager.BuildConfig
import com.sedmandev.stylistmanager.utils.GoogleSignInHelper

class LoginPresenter/* : BasePresenter(), GoogleSignInHelper.SignIn {

  val TAG = LoginPresenter::class.java.simpleName

  lateinit var googleSignInHelper: GoogleSignInHelper

  override fun inject() {
    injector.inject(this)
  }

  override fun onCreate() {
   // TODO:
  }

  override fun onDestroy() {
    Log.d(TAG, "onDestroy")
  }

  private fun initAuth(fragmentActivity: FragmentActivity, context: Context) {
    if(!::googleSignInHelper.isInitialized) {
      googleSignInHelper = GoogleSignInHelper(this)
      googleSignInHelper.initGoogleApiClient(fragmentActivity, context, BuildConfig.FB_CLIENT_ID)
    }
  }

  fun signInWithGoogle(activity: Activity) {
    googleSignInHelper.signInWithGoogle(activity)
  }

  fun onActivityResult(data: Intent?, context: Context, activity: Activity) {
    googleSignInHelper.onActivityResult(data, context, activity)
  }

  override fun onGoogleSignInSuccess(uid: String, name: String?, email: String?, photoUrl: String) {
    Log.d(TAG, "Google sign in successfully, user name: $name")
    //navigateTo(view.getContext(), AppointmentListActivity::class.java)
  }

  override fun onGoogleSignInFailed() {
    Log.d(TAG, "Google sign in failed")
  }
}*/