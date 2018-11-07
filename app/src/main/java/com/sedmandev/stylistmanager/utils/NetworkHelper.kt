package com.sedmandev.stylistmanager.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * Generic reusable network methods.
 */
class NetworkHelper(private val context: Context) {

  /**
   * @return true if connected, false otherwise.
   */
  val isOnline: Boolean
    get() {
      val connMgr = this.context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
      return (connMgr.activeNetworkInfo != null
          && connMgr.activeNetworkInfo.isConnected)
    }

  companion object {

    private val TYPE_WIFI = 1
    private val TYPE_MOBILE = 2
    private val TYPE_NOT_CONNECTED = 0

    val NETWORK_STATUS_NOT_CONNECTED = 0
    val NETWORK_STATUS_WIFI = 1
    val NETWORK_STATUS_MOBILE = 2

    val ACTION_INTERNET_CONNECTION = "android.net.conn.CONNECTIVITY_CHANGE"

    private fun getConnection(context: Context): Int {
      val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
      if (cm != null) {
        val activeNetwork = cm.activeNetworkInfo
        if (null != activeNetwork) {
          if (activeNetwork.type == ConnectivityManager.TYPE_WIFI) {
            return TYPE_WIFI
          }

          if (activeNetwork.type == ConnectivityManager.TYPE_MOBILE) {
            return TYPE_MOBILE
          }
        }
      }
      return TYPE_NOT_CONNECTED
    }

    fun getConnectionStatus(context: Context): Int {
      val conn = NetworkHelper.getConnection(context)
      var status = 0
      if (conn == NetworkHelper.TYPE_WIFI) {
        status = NETWORK_STATUS_WIFI
      } else if (conn == NetworkHelper.TYPE_MOBILE) {
        status = NETWORK_STATUS_MOBILE
      } else if (conn == NetworkHelper.TYPE_NOT_CONNECTED) {
        status = NETWORK_STATUS_NOT_CONNECTED
      }
      return status
    }
  }
}
