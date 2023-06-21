package org.nssfug.weather.remote.datasource

import org.junit.Assert.assertEquals
import org.junit.Test
import org.nssfug.weather.datasource.model.LocationDataModel
import org.nssfug.weather.remote.datasource.mapper.LocationDataToRemoteMapper
import org.nssfug.weather.remote.datasource.model.LocationRemoteModel

class LocationDataToRemoteMapperTest {
    private val mapper = LocationDataToRemoteMapper()

    @Test
    fun `toRemote should map LocationDataModel to LocationRemoteModel correctly`() {
        // Given
        val locationData = LocationDataModel(longitude = 20.0, latitude = 30.0)

        // When
        val result = mapper.toRemote(locationData)

        // Then
        val expected = LocationRemoteModel(lon = 20.0, lat = 30.0)
        assertEquals(expected, result)
    }
}
