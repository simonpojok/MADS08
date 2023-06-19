package org.nssfug.common.datasource.mapper

interface DataToDomainMapper<DATA, DOMAIN> {
    fun toDomain(data: DATA): DOMAIN
}