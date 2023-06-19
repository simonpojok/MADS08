package org.nssfug.common.datasource.mapper

interface DomainToDataMapper<DOMAIN, DATA> {
    fun toData(domain: DOMAIN): DATA
}