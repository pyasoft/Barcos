package com.aac.barcos.presentation.screen.velas.velasList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aac.barcos.domain.NauticaRepository
import com.aac.barcos.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VelasListingsViewModel @Inject constructor(
    private val repository: NauticaRepository
): ViewModel() {

    var state by mutableStateOf(VelasListingsState())

    private var searchJob: Job? = null

    init {
        recNauticaListings()
    }

    fun onEvent(event: VelasListingsEvent) {
         when(event) {
            is VelasListingsEvent.Refresh -> {
                recNauticaListings()
            }
            is VelasListingsEvent.OnSearchQueryChange -> {
                state = state.copy(rumbo = event.rumbo, viento = event.viento, vela = event.vela)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    recNauticaListings()
                    state = state.copy(isLoading = false)
                }
            }
        }
    }

    private fun recNauticaListings(
        rumbo:  String = state.rumbo.uppercase(),
        viento: String = state.viento.uppercase(),
        vela:   String = state.vela.uppercase(),
    ) {
        viewModelScope.launch {
            repository
                .getByFiltro(rumbo = rumbo, viento = viento, vela = vela)
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { listings ->
                                state = state.copy(nauticas = listings)
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }
                    }
                }
        }
    }

}