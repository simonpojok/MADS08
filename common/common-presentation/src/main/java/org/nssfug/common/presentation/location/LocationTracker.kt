package org.nssfug.common.presentation.location

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}