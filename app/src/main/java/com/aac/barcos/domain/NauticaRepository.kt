package com.aac.barcos.domain

import com.aac.barcos.domain.model.NauticaComun
import com.aac.barcos.util.Resource
import kotlinx.coroutines.flow.Flow

interface NauticaRepository {

    suspend fun getAll(): Flow<Resource<List<NauticaComun>>>

    suspend fun getByFiltro(
        rumbo: String,
        viento: String,
        vela: String
    ): Flow<Resource<List<NauticaComun>>>

    suspend fun getById(id: Int): Resource<NauticaComun>

}