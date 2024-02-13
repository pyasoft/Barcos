package com.aac.barcos.data.local

import androidx.room.*

@Dao
interface BarcosDao {

    @Query("SELECT * FROM barcos")
    suspend fun getAll(): List<NauticaEntity>

    @Query("SELECT * FROM barcos WHERE rumbo = :rumbo AND viento = :viento AND vela = :vela ORDER BY elemento")
    suspend fun getByFiltro(rumbo: String, viento: String, vela: String): List<NauticaEntity>

    @Query("SELECT * FROM barcos WHERE id = :id")
    suspend fun getById(id: Int): NauticaEntity


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: NauticaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNauticas(item: List<NauticaEntity>)


    @Update
    suspend fun update(item: NauticaEntity)


    @Delete
    suspend fun delete(item: NauticaEntity)

    @Query("DELETE FROM barcos WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("DELETE FROM barcos")
    suspend fun deleteAllTodos()

}
