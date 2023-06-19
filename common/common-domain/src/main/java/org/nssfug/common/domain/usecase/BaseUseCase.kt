package org.nssfug.common.domain.usecase

import org.nssfug.common.domain.model.DomainException
import org.nssfug.common.domain.model.UnknownDomainException

interface BaseUseCase<REQUEST, RESULT> {
    suspend fun execute(value: REQUEST, callback: (RESULT) -> Unit)

    fun onError(throwable: Throwable): DomainException = UnknownDomainException(throwable)
}