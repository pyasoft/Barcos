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
fun AboutScreen(onNavigation:() -> Unit) {

    ScaffoldAbout( onNavigation )

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldAbout(onNavigation:() -> Unit) {

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar("About", onNavigation) },
        content = { Text("nautica")

            Surface(
                color = Color.White,
                modifier = Modifier.fillMaxSize()
            ) {
                About()
            }
        }
    )
}

@Composable
fun About() {

    Column( modifier = Modifier.fillMaxWidth().padding(horizontal = 26.dp, vertical = 22.dp) ) {

        Spacer( modifier = Modifier .height(14.dp) )

        Text(text = "Sobre la aplicación", color = MaterialTheme.colors.primary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer( modifier = Modifier .height(10.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        LineasTextoAbout("Desarrollador", "Alfonso Alonso")

        Spacer( modifier = Modifier .height(10.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        LineasTextoAbout("Graficos", "Banski")

        Spacer( modifier = Modifier .height(10.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        LineasTextoAbout("Informacion trimado velas", "Josep Maria Ferrer Sirvent", "info@velesivelers.cat")

        Spacer( modifier = Modifier .height(10.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        LineasTextoAbout("Informacion trimado palos", "Toni Tio", "Velas-Quantum")

        Spacer( modifier = Modifier .height(10.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        LineasTextoAbout("Informacion glosario", "nauticspain", "nauticspain@nauticspain.com")

        Spacer( modifier = Modifier .height(34.dp) )

        Text(text = "Sobre la versión", color = MaterialTheme.colors.primary, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer( modifier = Modifier .height(10.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        LineasTextoAbout("Version", "1.01.1")

    }
}

@Composable
fun LineasTextoAbout( texto1: String, texto2: String, texto3: String = "") {
    Text(text = texto1, fontWeight = FontWeight.Bold)
    Text(text = texto2)
    if (texto3 != "") Text(text = texto3)
}
