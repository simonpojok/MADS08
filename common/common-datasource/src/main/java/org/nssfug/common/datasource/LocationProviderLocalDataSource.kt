package org.nssfug.common.datasource

import org.nssfug.common.datasource.model.LocationDataModel

interface LocationProviderLocalDataSource {
    suspend fun getCurrentLocation(): LocationDataModel
}