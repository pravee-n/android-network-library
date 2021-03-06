package com.zoomcar.networkclient

import android.app.Application
import android.util.Log
import com.zoomcar.zcnetwork.core.ZcNetworkManager
import com.zoomcar.zcnetwork.error.JavaServiceNetworkError
import com.zoomcar.zcnetwork.error.NetworkError
import com.zoomcar.zcnetwork.listeners.ZcNetworkAnalyticsListener
import com.zoomcar.zcnetwork.utils.LibTag

/*
  * @created 08/01/2020 - 5:35 PM
  * @project ZC-Network-Client
  * @author Paras
*/
class MyApplication : Application(), ZcNetworkAnalyticsListener {

    override fun onCreate() {
        super.onCreate()
        ZcNetworkManager.builder(this)
            .setDebugLog(true)
            .setNetworkAnalyticsListener(this)
            .addBaseUrl(ApiConstant.BASE_URL)
            .build()
    }

    override fun responseTimeEvent(
        timeDiff: Long,
        status: String,
        requestCode: Int,
        requestTag: String?
    ) {
        Log.d(LibTag.TAG, "responseTimeEvent: ")
    }

    override fun failureEvent(error: NetworkError, requestCode: Int, requestTag: String?) {
        Log.d(LibTag.TAG, "failureEvent: ")
    }

    override fun javaServiceFailureEvent(
        error: JavaServiceNetworkError, requestCode: Int, requestTag: String?
    ) {
        Log.d(LibTag.TAG, "javaServiceFailureEvent: ")
    }
}