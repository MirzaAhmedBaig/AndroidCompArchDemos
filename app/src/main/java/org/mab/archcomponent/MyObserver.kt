package org.mab.archcomponent

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

class MyObserver : LifecycleObserver {
    private val TAG = MyObserver::class.java.simpleName
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun connectListener() {
        Log.d(TAG, "connectListener")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun disconnectListener() {
        Log.d(TAG, "disconnectListener")
    }
}