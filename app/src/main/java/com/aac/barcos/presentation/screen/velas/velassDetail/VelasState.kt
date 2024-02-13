package com.aac.barcos.presentation.screen.velas.velassDetail

import com.aac.barcos.domain.model.NauticaComun

data class VelasState(
    val nautica: NauticaComun? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)