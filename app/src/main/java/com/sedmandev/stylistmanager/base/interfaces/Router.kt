package com.sedmandev.stylistmanager.base.interfaces

import android.content.Context

interface Router {

  fun navigateTo(context: Context, cls: Class<*>)
}