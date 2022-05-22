package com.gdsc.sogongsogong.extensions

import com.gdsc.sogongsogong.di.dispatcher.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext

@DelicateCoroutinesApi
class FakeDispatcherProvider : DispatcherProvider {
    override val main: CoroutineDispatcher
        get() = newSingleThreadContext("Main thread")
    override val io: CoroutineDispatcher
        get() = newSingleThreadContext("Io thread")
    override val default: CoroutineDispatcher
        get() = newSingleThreadContext("Default thread")
}