package com.sedmandev.stylistmanager.base.interfaces

import android.content.Context
import android.content.Intent

interface Router {

  fun navigateTo(context: Context, cls: Class<*>)

  fun navigateTo(context: Context, cls: Class<*>, intent: Intent)
}