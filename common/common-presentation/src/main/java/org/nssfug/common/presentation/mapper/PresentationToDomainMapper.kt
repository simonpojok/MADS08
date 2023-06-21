package org.nssfug.common.presentation.mapper

interface PresentationToDomainMapper<PRESENTATION, DOMAIN> {
    fun toDomain(presentation: PRESENTATION): DOMAIN
}