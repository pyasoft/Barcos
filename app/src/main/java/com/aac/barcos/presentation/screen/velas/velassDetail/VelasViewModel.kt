package com.aac.barcos.presentation.screen.velas.velassDetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aac.barcos.domain.NauticaRepository
import com.aac.barcos.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VelasViewModel @Inject constructor(
    private val repository: NauticaRepository
): ViewModel() {

    var state by mutableStateOf(VelasState())

/*
    init {
        viewModelScope.launch {
            val symbol = savedStateHandle.get<Int>("id") ?: return@launch
            state = state.copy(isLoading = true)
            val companyInfoResult = async { repository.getById(symbol) }
            when(val result = companyInfoResult.await()) {
                is Resource.Success -> {
                    state = state.copy(
                        nautica = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.message,
                        nautica = null
                    )
                }
                else -> Unit
            }
        }
    }
*/

    fun RecNautica(nauticaId: Int) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val companyInfoResult = async { repository.getById(nauticaId) }

            when (val result = companyInfoResult.await()) {
                is Resource.Success -> {
                    state = state.copy(
                        isLoading = false,
                        error = null,
                        nautica = result.data
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.message,
                        nautica = null
                    )
                }
                else -> Unit
            }

        }
    }


    fun RecNautica2(nauticaId: Int) {
        viewModelScope.launch {
            val result = repository.getById(nauticaId)

            when ( result ) {
                is Resource.Success -> {
                    state = state.copy(
                        isLoading = false,
                        error = null,
                        nautica = result.data
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        isLoading = false,
                        error = result.message,
                        nautica = null
                    )
                }
                else -> Unit
            }

        }
    }

}