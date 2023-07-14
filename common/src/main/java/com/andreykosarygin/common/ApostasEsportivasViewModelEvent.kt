package com.andreykosarygin.common

open class ApostasEsportivasViewModelEvent<EVENT>(
    private val event: EVENT
) {
    open fun use(doEvent: (EVENT) -> Unit) {
        doEvent(event)
    }
}