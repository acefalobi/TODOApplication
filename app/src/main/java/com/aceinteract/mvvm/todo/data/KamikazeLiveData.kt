package com.aceinteract.mvvm.todo.data

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

class KamikazeLiveData<T> : LiveData<T>() {

    fun observe(owner: LifecycleOwner, observer: KamikazeObserver<in T>) {
        observer.triggerCallback = object : KamikazeObserver.TriggerCallback {
            override fun onTriggered() {
                removeObserver(observer)
            }
        }
        super.observe(owner, observer)
    }

    fun observeForever(observer: KamikazeObserver<in T>) {
        observer.triggerCallback = object : KamikazeObserver.TriggerCallback {
            override fun onTriggered() {
                removeObserver(observer)
            }
        }
        super.observeForever(observer)
    }

}