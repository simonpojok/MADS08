package org.nssfug.common.domain

interface Cancellable {
    fun cancel()
}

interface RunningExecution : Cancellable {
    fun isRunning(): Boolean
}

fun MutableSet<Cancellable>.cancelAll() {
    forEach { it.cancel() }
    clear()
}