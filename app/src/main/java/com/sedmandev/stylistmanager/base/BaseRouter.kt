package com.sedmandev.stylistmanager.base

import android.content.Context
import android.content.Intent
import com.sedmandev.stylistmanager.base.interfaces.Router

abstract class BaseRouter : Router {

  override fun navigateTo(context: Context, cls: Class<*>) {
    val intent = Intent(context, cls)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    context.startActivity(intent)
  }

  override fun navigateTo(context: Context, cls: Class<*>, intent: Intent) {
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    context.startActivity(intent)
  }
}