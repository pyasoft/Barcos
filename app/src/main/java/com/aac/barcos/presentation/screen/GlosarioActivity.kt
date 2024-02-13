package com.aac.barcos.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun GlosarioScreen(onNavigation:() -> Unit) {

    ScaffoldGlosario( onNavigation )

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldGlosario(onNavigation:() -> Unit) {

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar("Glosario", onNavigation) },
        content = { Text("nautica")

            Surface(
                color = Color(0xFFFFFFFF),
                modifier = Modifier.fillMaxSize()
            ) {
                Glosario()
            }
        }
    )
}

@Composable
fun Glosario() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(scrollState)
            .padding(all = 16.dp)
    ) {

        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto("Proa", "delante." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Popa", "detrás." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Estribor", "Derecha." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Babor", "Izquierda." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Barlovento", "por donde viene el viento." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Sotavento", "a donde va el viento." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Eslora", "longitud de proa a popa." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Manga", "mayor longitud transversal de babor a estribor." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Calado", "máxima dimensión sumergida del casco." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Obra viva", "parte sumergida del casco." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Obra muerta", "parte no sumergida del casco." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Quilla", "línea proa‐popa en la parte inferior del casco a lo largo de toda la eslora. " )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Orza", "contrapeso situado en los veleros aproximadamente debajo del centro de gravedad saliendo de la quilla." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Francobordo", "distancia vertical desde la línea de flotación (marca del agua en el casco) hasta la línea de cubierta (trancanil)." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Bañera", "zona del barco donde va la caña o rueda así como otros elementos de gobierno." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Timón", "consta de pala (sumergida) y caña o rueda (mueven la pala del timón)." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Cabos", "en el barco no hay cuerdas." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Escota", "cabo que modifica el ángulo que la vela forma respecto al eje proa‐popa. La tensa o destensa." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Drizas", "cabos que sirven para izar las velas." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Amarras", "cabos para amarrar el barco." )
        Spacer( modifier = Modifier .height(14.dp) )

        LineasTexto( "Cornamusa", "Pieza de metal o madera que encorvada en sus extremos y fija por su punto medio, sirve para amarrar los cabos." )
        Spacer( modifier = Modifier .height(14.dp) )

    }

}

@Composable
fun LineasTexto( texto1: String, texto2: String, texto3: String = "") {
    Text(text = texto1, fontWeight = FontWeight.Bold)
    Text(text = texto2)
    if (texto3 != "") Text(text = texto3)
}