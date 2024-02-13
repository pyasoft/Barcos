package com.aac.barcos.presentation.screen

import androidx.lifecycle.ViewModel
import com.aac.barcos.domain.NauticaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenViewModel @Inject constructor(
    private val repository: NauticaRepository
): ViewModel() {

}