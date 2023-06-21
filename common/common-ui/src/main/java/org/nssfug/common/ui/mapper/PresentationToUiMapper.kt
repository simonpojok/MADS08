package org.nssfug.common.ui.mapper

interface PresentationToUiMapper<PRESENTATION, UI> {
    fun toUi(presentation: PRESENTATION): UI
}