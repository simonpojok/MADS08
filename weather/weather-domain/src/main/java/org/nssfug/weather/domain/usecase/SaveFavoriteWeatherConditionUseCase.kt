package org.nssfug.weather.domain.usecase

import kotlinx.coroutines.CoroutineScope
import org.nssfug.common.domain.CoroutineContextProvider
import org.nssfug.common.domain.usecase.BackgroundExecuteUseCase
import org.nssfug.common.domain.usecase.BaseUseCase
import org.nssfug.weather.domain.model.FavoriteWeatherConditionDomainModel
import org.nssfug.weather.domain.repository.FavoriteWeatherConditionRepository

interface SaveFavoriteWeatherConditionUseCase :
    BaseUseCase<FavoriteWeatherConditionDomainModel, Unit>

class SaveFavoriteWeatherConditionUseCaseImp(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val favoriteWeatherConditionRepository: FavoriteWeatherConditionRepository
) : SaveFavoriteWeatherConditionUseCase,
    BackgroundExecuteUseCase<FavoriteWeatherConditionDomainModel, Unit>(
        coroutineContextProvider
    ) {
    override suspend fun executeInBackground(
        request: FavoriteWeatherConditionDomainModel,
        coroutineScope: CoroutineScope
    ) = favoriteWeatherConditionRepository.saveFavoriteWeatherCondition(request)
}