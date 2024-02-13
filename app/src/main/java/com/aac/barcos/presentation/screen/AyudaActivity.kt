package com.aac.barcos.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun AyudaScreen(onNavigation:() -> Unit) {

    ScaffoldAyuda( onNavigation )

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldAyuda(onNavigation:() -> Unit) {

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar("Ayuda", onNavigation) },
        content = { Text("nautica")

            Surface(
                color = Color.White,
                modifier = Modifier.fillMaxSize()
            ) {
                Help()
            }
        }
    )
}

@Composable
fun Help() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {

        Column(
            modifier = Modifier
            .fillMaxWidth().padding(horizontal = 26.dp, vertical = 22.dp)
        ) {

            Text(text = "AYUDA", color = MaterialTheme.colors.primary, fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Spacer( modifier = Modifier .height(14.dp) )
            Divider()
            Spacer( modifier = Modifier .height(10.dp) )

            LineasTextoAyuda( "Aplicacion de Ajustes y trimado de veleros.", "Ajustes de palos y velas.")

        }

    }
}

@Composable
fun LineasTextoAyuda( texto1: String, texto2: String, texto3: String = "") {
    Text(text = texto1, fontWeight = FontWeight.Bold)
    Text(text = texto2)
    if (texto3 != "") Text(text = texto3)
}
