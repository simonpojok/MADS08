package org.nssfug.common.remote.datasource.mapper

interface RemoteToDataMapper<REMOTE, DATA> {
    fun toData(remote: REMOTE): DATA
}