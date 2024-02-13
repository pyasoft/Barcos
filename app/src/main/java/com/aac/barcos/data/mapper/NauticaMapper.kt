package com.aac.barcos.data.mapper

import com.aac.barcos.data.NauticaApi
import com.aac.barcos.data.local.NauticaEntity
import com.aac.barcos.domain.model.NauticaComun

fun NauticaApi.toNauticaComun(): NauticaComun {
    return NauticaComun(
        id = id,
        Rumbo = rumbo,
        Viento = viento,
        Vela = vela,
        Elemento = elemento,
        Accion = accion,
        Comentario = comentario
    )
}

fun NauticaApi.toNauticaEntity(): NauticaEntity {
    return NauticaEntity(
        id = id,
        rumbo = rumbo,
        viento = viento,
        vela = vela,
        elemento = elemento,
        accion = accion,
        comentario = comentario
    )
}


fun NauticaEntity.toNauticaComun(): NauticaComun {
    return NauticaComun(
        id = id,
        Rumbo = rumbo,
        Viento = viento,
        Vela = vela,
        Elemento = elemento,
        Accion = accion,
        Comentario = comentario!!
    )
}


fun NauticaComun.toNauticaEntity(): NauticaEntity {
    return NauticaEntity(
        id = id,
        rumbo = Rumbo,
        viento = Viento,
        vela = Vela,
        elemento = Elemento,
        accion = Accion,
        comentario = Comentario
    )
}


fun List<NauticaApi>.toNauticaComun(): List<NauticaComun> {
    return map {
        NauticaComun(
            id = it.id,
            Rumbo = it.rumbo,
            Viento = it.viento,
            Vela = it.vela,
            Elemento = it.elemento,
            Accion = it.accion,
            Comentario = it.comentario
        )
    }
}