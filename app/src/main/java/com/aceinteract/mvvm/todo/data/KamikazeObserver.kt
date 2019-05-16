package com.aceinteract.mvvm.todo.data

import androidx.lifecycle.Observer

abstract class KamikazeObserver<T> : Observer<T> {

    var triggerCallback: TriggerCallback? = null

    private var triggered = false

    abstract fun onTriggered(t: T)

    override fun onChanged(t: T) {
        if (!triggered) {
            if (t != null) {
                onTriggered(t)
                triggered = true
                triggerCallback?.onTriggered()
            }
        }
    }

    interface TriggerCallback {
        fun onTriggered()
    }

}