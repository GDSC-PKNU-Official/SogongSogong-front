package com.gdsc.sogongsogong.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

private const val ERROR_PERIOD = "period should be positive"
private const val DEFAULT_PERIOD = 500L

fun <T> Flow<T>.throttleFirst(periodMillis: Long = DEFAULT_PERIOD) = flow {
    require(periodMillis > 0) {
        ERROR_PERIOD
    }

    var lastTime = 0L

    collect { value ->
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastTime >= periodMillis) {
            lastTime = currentTime
            emit(value)
        }
    }
}