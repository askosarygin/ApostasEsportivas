package com.andreykosarygin.common

import java.util.concurrent.atomic.AtomicBoolean

open class ApostasEsportivasViewModelSingleLifeEvent<EVENT>(
    private val event: EVENT
) : ApostasEsportivasViewModelEvent<EVENT>(event) {
    private val processed = AtomicBoolean(false)

    override fun use(doEvent: (EVENT) -> Unit) {
        if (!processed.getAndSet(true)) {
            super.use(doEvent)
        }
    }
}