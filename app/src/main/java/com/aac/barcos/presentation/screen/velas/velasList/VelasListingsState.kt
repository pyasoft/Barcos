package com.aac.barcos.presentation.screen.velas.velasList

import com.aac.barcos.domain.model.NauticaComun

data class VelasListingsState(
    val nauticas: List<NauticaComun> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val rumbo: String = "",
    val viento: String = "",
    val vela: String = ""
)