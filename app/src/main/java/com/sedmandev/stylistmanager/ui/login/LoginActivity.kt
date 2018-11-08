package com.sedmandev.stylistmanager.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.Button
import com.sedmandev.stylistmanager.R
import com.sedmandev.stylistmanager.base.BaseActivity
import com.sedmandev.stylistmanager.utils.RC_GOOGLE_SIGN_IN

class LoginActivity: BaseActivity<LoginPresenter>(), LoginView, View.OnClickListener {

  val TAG = LoginActivity::class.java.simpleName

  // Views
  lateinit var btnGoogleSignIn : Button

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter.onCreate()
  }

  override val contentViewId: Int
    get() = R.layout.activity_login

  override val statusBarColor: Int
    get() = android.R.color.black

  override fun initViews() {
    btnGoogleSignIn = findViewById<View>(R.id.btn_google_sign_in) as Button
    btnGoogleSignIn.setOnClickListener(this)
  }

  override fun getActivity(): Activity {
    return this
  }

  override fun getFragmentActivity(): FragmentActivity {
    return this
  }

  override fun instantiatePresenter(): LoginPresenter {
    return LoginPresenter(this, LoginRouter(), LoginInteractor())
  }

  override fun onClick(v: View?) {
    when(v?.id) {
      R.id.btn_google_sign_in -> {
        presenter.signInWithGoogle()
      }
    }
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if(requestCode == RC_GOOGLE_SIGN_IN) {
      presenter.onActivityResult(data)
    }
  }
}