package org.nssfug.common.domain.usecase

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.nssfug.common.domain.RunningExecution
import org.nssfug.common.domain.model.DomainException

open class UseCaseExecutor(
    private var coroutineScope: CoroutineScope
) {


    open fun <OUT_TYPE> execute(
        useCase: BaseUseCase<Unit, OUT_TYPE>,
        callback: (OUT_TYPE) -> Unit = {},
        onError: (DomainException) -> Unit = {}
    ): RunningExecution = execute(useCase, Unit, callback, onError)

    open fun <IN_TYPE, OUT_TYPE> execute(
        useCase: BaseUseCase<IN_TYPE, OUT_TYPE>,
        value: IN_TYPE,
        callback: (OUT_TYPE) -> Unit = {},
        onError: (DomainException) -> Unit = {}
    ): RunningExecution {
        val job = launchUseCaseExecution(useCase, value, callback, onError)
        return RunningUseCaseExecution(job)
    }

    private fun <IN_TYPE, OUT_TYPE> launchUseCaseExecution(
        useCase: BaseUseCase<IN_TYPE, OUT_TYPE>,
        value: IN_TYPE,
        callback: (OUT_TYPE) -> Unit,
        onError: (DomainException) -> Unit
    ) = coroutineScope.launch {

        val callbackWrapper = { result: OUT_TYPE ->
            callback(result)
        }
        try {
            useCase.execute(value, callbackWrapper)
        } catch (_: CancellationException) {
        } catch (throwable: Throwable) {
            onError(
                if (throwable is DomainException) {
                    throwable
                } else {
                    useCase.onError(throwable)
                }
            )
        } finally {
        }
    }

    class RunningUseCaseExecution(private val job: Job) : RunningExecution {
        override fun isRunning() = job.isActive

        override fun cancel() {
            job.cancel()
        }
    }
}