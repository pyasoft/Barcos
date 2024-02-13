package com.aac.barcos.presentation.screen.velas.velasList

sealed class VelasListingsEvent {
    object Refresh: VelasListingsEvent()
    data class OnSearchQueryChange(val rumbo: String, val viento: String, val vela: String): VelasListingsEvent()
}