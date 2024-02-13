package com.aac.barcos.presentation.screen.velas

import androidx.lifecycle.ViewModel
import com.aac.barcos.domain.NauticaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScreenViewModel @Inject constructor(
    private val repository: NauticaRepository
): ViewModel() {

/*
    fun getByFiltro(rumbo: String, viento: String, vela: String): LiveData<List<NauticaComun>> {
        return repository.getByFiltro(rumbo, viento, vela)
    }

    fun getByIdLive(id: Int): LiveData<NauticaComun> {
        return repository.getByIdLive(id)
    }

    fun getAll(): LiveData<List<NauticaComun>> {
        return repository.getAllLive()
    }

 */

}