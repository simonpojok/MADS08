package org.nssfug.common.presentation.mapper

interface DomainToPresentationMapper<DOMAIN, PRESENTATION> {
    fun toPresentation(domain: DOMAIN): PRESENTATION
}