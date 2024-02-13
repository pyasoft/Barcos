package com.aac.barcos.data.repository

import com.aac.barcos.data.DataProvider
import com.aac.barcos.data.local.NauticaDatabase
import com.aac.barcos.data.mapper.toNauticaComun
import com.aac.barcos.data.mapper.toNauticaEntity
import com.aac.barcos.domain.NauticaRepository
import com.aac.barcos.domain.model.NauticaComun
import com.aac.barcos.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NauticaRepositoryImpl @Inject constructor(
    private val db: NauticaDatabase,
): NauticaRepository {

    private val dao = db.nauticaDao()

    override suspend fun getAll(): Flow<Resource<List<NauticaComun>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.getAll()
            emit(Resource.Success(
                data = localListings.map { it.toNauticaComun() }
            ))

            val isDbEmpty = localListings.isEmpty()
            val shouldJustLoadFromCache = !isDbEmpty
            if(shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListings = try {
                DataProvider.newNauticas
            } catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            remoteListings?.let { listings ->
                dao.deleteAllTodos()
                dao.insertNauticas(
                    listings.map { it.toNauticaEntity() }
                )
                emit(Resource.Success(
                    data = dao
                        .getAll()
                        .map { it.toNauticaComun() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }

    override suspend fun getByFiltro(
        rumbo: String,
        viento: String,
        vela: String
    ): Flow<Resource<List<NauticaComun>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.getByFiltro(rumbo = rumbo, viento = viento, vela = vela)
            emit(Resource.Success(
                data = localListings.map { it.toNauticaComun() }
            ))

            val isDbEmpty = localListings.isEmpty()
            val isParamEmpty = rumbo.isBlank() && viento.isBlank() && vela.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !isParamEmpty
            if(shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteListings = try {
                DataProvider.newNauticas
            } catch(e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data"))
                null
            }

            remoteListings?.let { listings ->
                dao.deleteAllTodos()
                dao.insertNauticas( listings.map { it.toNauticaEntity() } )
                emit(Resource.Success(
                    data = dao
                        .getByFiltro(rumbo, viento, vela)
                        .map { it.toNauticaComun() }
                ))
                emit(Resource.Loading(false))
            }
        }
    }

    override suspend fun getById(id: Int): Resource<NauticaComun> {
        return try {
            val result = dao.getById(id)
            Resource.Success(result.toNauticaComun())
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Error(
                message = "Couldn't load company info"
            )
        }
    }

}