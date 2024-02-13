package com.aac.barcos.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barcos")
data class NauticaEntity constructor (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "rumbo")
    val rumbo: String,
    @ColumnInfo(name = "viento")
    val viento: String,
    @ColumnInfo(name = "vela")
    val vela: String,
    @ColumnInfo(name = "elemento")
    val elemento: String,
    @ColumnInfo(name = "accion")
    val accion: String,
    @ColumnInfo(name = "comentario")
    val comentario: String?
)
