package br.com.breno.brenosocialmedia.data.arch

import android.content.Context
import org.greenrobot.eventbus.EventBus

interface BaseBusiness {

    var context: Context

    fun inInit(context: Context, configurarEventBus: Boolean = true) {
        this.context = context

        if (configurarEventBus) registerEventBus()
    }

    fun inEnd() {
        unRegisterEventBus()
    }

    private fun registerEventBus() {
        EventBus.getDefault().register(this)
    }

    private fun unRegisterEventBus() {
        EventBus.getDefault().unregister(this)
    }

}