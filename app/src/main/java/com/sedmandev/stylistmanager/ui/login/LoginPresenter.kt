package com.sedmandev.stylistmanager.ui.login

import android.content.Intent
import android.util.Log
import com.sedmandev.stylistmanager.BuildConfig
import com.sedmandev.stylistmanager.MainActivity
import com.sedmandev.stylistmanager.R
import com.sedmandev.stylistmanager.base.BasePresenter
import com.sedmandev.stylistmanager.utils.GoogleSignInHelper

class LoginPresenter(loginView : LoginView, loginRouter : LoginRouter,
      private val interactor: LoginInteractor) : BasePresenter<LoginView, LoginRouter>(loginView, loginRouter),
    GoogleSignInHelper.SignIn {

  val TAG = LoginPresenter::class.java.simpleName

  lateinit var googleSignInHelper: GoogleSignInHelper

  override fun inject() {
    injector.inject(this)
  }

  override fun onCreate() {
    view.initViews()
    initAuth()
  }

  override fun onStart() {
    Log.d(TAG, "onStart")
  }

  override fun onResume() {
    Log.d(TAG, "onResume")
  }

  override fun onPause() {
    Log.d(TAG, "onPause")
  }

  override fun onStop() {
    Log.d(TAG, "onStop")
  }

  override fun onDestroy() {
    Log.d(TAG, "onDestroy")
  }

  private fun initAuth() {
    if(!::googleSignInHelper.isInitialized) {
      googleSignInHelper = GoogleSignInHelper(this)
      googleSignInHelper.initGoogleApiClient(view.getFragmentActivity(), view.getContext(),
          BuildConfig.FB_CLIENT_ID)
    }
  }

  fun signInWithGoogle() {
    googleSignInHelper.signInWithGoogle(view.getActivity())
  }

  fun onActivityResult(data: Intent?) {
    googleSignInHelper.onActivityResult(data, view.getContext(), view.getActivity())
  }

  override fun onGoogleSignInSuccess(uid: String, name: String?, email: String?, photoUrl: String) {
    Log.d(TAG, "Google sign in successfully, user name: $name")
    router.navigateTo(view.getContext(), MainActivity::class.java)
  }

  override fun onGoogleSignInFailed() {
    Log.d(TAG, "Google sign in failed")
  }
}