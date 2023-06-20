package org.nssfug.common.presentation.usecase

import kotlinx.coroutines.CoroutineScope
import org.nssfug.common.domain.usecase.UseCaseExecutor

typealias UseCaseExecutorProvider = @JvmSuppressWildcards (coroutineScope: CoroutineScope) -> UseCaseExecutor
