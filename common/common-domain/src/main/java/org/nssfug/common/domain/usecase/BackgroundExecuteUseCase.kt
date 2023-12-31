package org.nssfug.common.domain.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import org.nssfug.common.domain.CoroutineContextProvider

abstract class BackgroundExecuteUseCase<REQUEST, RESULT> constructor(
    private val coroutineContextProvider: CoroutineContextProvider
) : BaseUseCase<REQUEST, RESULT> {
    final override suspend fun execute(value: REQUEST, callback: (RESULT) -> Unit) {
        val result = withContext(coroutineContextProvider.io) {
            executeInBackground(value, this)
        }

        callback(result)
    }

    abstract suspend fun executeInBackground(
        request: REQUEST,
        coroutineScope: CoroutineScope
    ): RESULT
}