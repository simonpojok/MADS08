package org.nssfug.common.local.datasource.mapper

interface LocalToDataMapper<LOCAL_DATA, DATA> {
    fun toData(localData: LOCAL_DATA): DATA
}