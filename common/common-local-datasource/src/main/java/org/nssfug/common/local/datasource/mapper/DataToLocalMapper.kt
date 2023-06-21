package org.nssfug.common.local.datasource.mapper

interface DataToLocalMapper<DATA, LOCAL> {
    fun toLocal(data: DATA): LOCAL
}