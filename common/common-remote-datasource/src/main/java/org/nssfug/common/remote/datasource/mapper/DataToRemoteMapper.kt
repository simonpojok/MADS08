package org.nssfug.common.remote.datasource.mapper

interface DataToRemoteMapper<DATA, REMOTE> {
    fun toRemote(data: DATA): REMOTE
}