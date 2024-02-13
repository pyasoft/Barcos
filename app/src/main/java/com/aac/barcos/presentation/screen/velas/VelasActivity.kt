package com.aac.barcos.presentation.screen.velas

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.aac.barcos.R
import com.aac.barcos.domain.model.Rumbos
import com.aac.barcos.domain.model.Velas
import com.aac.barcos.domain.model.Vientos
import com.aac.barcos.presentation.screen.DrawerContent
import com.aac.barcos.presentation.screen.TopBarDrawer
import com.aac.barcos.presentation.theme.BarcosTheme

var sRumbo:  String = Rumbos.CENIDA.name
var sViento: String = Vientos.FLOJO.name
var sVela:   String = Velas.MAYOR.name

@Composable
fun VelasActivity( onNavigation2:() -> Unit, onNavigation3:() -> Unit, onNavigation4:() -> Unit, onNavigation5:() -> Unit, onNavigation:(rumbo: String, viento: String, vela: String) -> Unit) {

    ScaffoldVelas(onNavigation2, onNavigation3, onNavigation4, onNavigation5, onNavigation)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldVelas(onNavigation2:() -> Unit, onNavigation3:() -> Unit, onNavigation4:() -> Unit, onNavigation5:() -> Unit, onNavigation:(rumbo: String, viento: String, vela: String) -> Unit) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        //topBar = { TopBar("Selecciona navegacion", navController) },
        topBar = { TopBarDrawer(stringResource(R.string.app_name), scaffoldState = scaffoldState, scope = scope) },
        drawerContent = { DrawerContent(scaffoldState = scaffoldState, scope = scope, onNavigation2, onNavigation3, onNavigation4, onNavigation5) },
        drawerBackgroundColor = MaterialTheme.colors.background,
        drawerGesturesEnabled = true,
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.onPrimary,
                onClick = { onNavigation(sRumbo, sViento, sVela) }
            ) { MyBoton() }
                               },
        content = { ContentHome() }
    )
}

@Composable
fun ContentHome() {
    val scrollState = rememberScrollState()

    Column( modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Botones()
        //BotonesRumbo()
        //BotonesViento()
        //BotonesVela()
    }
}

@Composable
fun Botones() {

    var selectedOptionRumbos by remember { mutableStateOf(sRumbo) }
    val onSelectionChangeRumbos = { text: String -> selectedOptionRumbos = text }

    var selectedOptionVientos by remember { mutableStateOf(sViento) }
    val onSelectionChangeVientos = { text: String -> selectedOptionVientos = text }

    var selectedOptionVelas by remember { mutableStateOf(sVela) }
    val onSelectionChangeVelas = { text: String -> selectedOptionVelas = text }

    val optionsRumbos = listOf(
        Rumbos.CENIDA.name,
        Rumbos.TRAVES.name,
        Rumbos.POPA.name
    )

    val optionsVientos = listOf(
        Vientos.FLOJO.name,
        Vientos.MEDIO.name,
        Vientos.FUERTE.name
    )

    Column( horizontalAlignment = Alignment.CenterHorizontally ) {
        MyTextCombo("Rumbos")
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.padding(8.dp)) {
            optionsRumbos.forEach { text ->
                Row(modifier = Modifier.padding( all = 8.dp )) {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.body1.merge(),
                        color =
                        if (text == selectedOptionRumbos) {
                            MaterialTheme.colors.onPrimary
                        } else {
                            MaterialTheme.colors.onBackground.copy(alpha = ContentAlpha.disabled)
                        },
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(size = 12.dp))
                            .clickable { onSelectionChangeRumbos(text) }
                            .background(
                                if (text == selectedOptionRumbos) {
                                    MaterialTheme.colors.primary
                                } else {
                                    MaterialTheme.colors.secondary
                                        .copy(alpha = 0.2f)
                                        .compositeOver(MaterialTheme.colors.background)
                                }
                            )
                            .padding(vertical = 12.dp, horizontal = 16.dp),
                    )
                }

                sRumbo = selectedOptionRumbos
            }
        }
    }

    Column( horizontalAlignment = Alignment.CenterHorizontally ) {
        MyTextCombo("Vientos")
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.padding(8.dp)) {
            optionsVientos.forEach { text ->
                Row(modifier = Modifier.padding( all = 8.dp )) {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.body1.merge(),
                        color =
                        if (text == selectedOptionVientos) {
                            MaterialTheme.colors.onPrimary
                        } else {
                            MaterialTheme.colors.onBackground.copy(alpha = ContentAlpha.disabled)
                        },
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(size = 12.dp))
                            .clickable { onSelectionChangeVientos(text) }
                            .background(
                                if (text == selectedOptionVientos) {
                                    MaterialTheme.colors.primary
                                } else {
                                    MaterialTheme.colors.secondary
                                        .copy(alpha = 0.2f)
                                        .compositeOver(MaterialTheme.colors.background)
                                }
                            )
                            .padding(vertical = 12.dp, horizontal = 16.dp),
                    )
                }

                sViento = selectedOptionVientos
            }
        }
    }


    val optionsVelas =
        when (sRumbo) {
            Rumbos.CENIDA.name -> listOf(Velas.MAYOR.name, Velas.GENOVA.name)
            Rumbos.TRAVES.name -> listOf(Velas.MAYOR.name, Velas.GENOVA.name, Velas.SPI.name, Velas.GEN.name)
            Rumbos.POPA.name -> listOf(Velas.MAYOR.name, Velas.GENOVA.name, Velas.SPI.name, Velas.GEN.name)
            else -> listOf(Velas.MAYOR.name, Velas.GENOVA.name, Velas.SPI.name, Velas.GEN.name)
        }
if ( sRumbo == Rumbos.CENIDA.name && ( sVela == Velas.SPI.name || sVela == Velas.GEN.name ) ) selectedOptionVelas = Velas.MAYOR.name
    Column( horizontalAlignment = Alignment.CenterHorizontally ) {
        MyTextCombo("Velas")
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.padding(8.dp)) {
            optionsVelas.forEach { text ->
                Row(modifier = Modifier.padding( all = 8.dp )) {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.body1.merge(),
                        color =
                        if (text == selectedOptionVelas) {
                            MaterialTheme.colors.onPrimary
                        } else {
                            MaterialTheme.colors.onBackground.copy(alpha = ContentAlpha.disabled)
                        },
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(size = 12.dp))
                            .clickable { onSelectionChangeVelas(text) }
                            .background(
                                if (text == selectedOptionVelas) {
                                    MaterialTheme.colors.primary
                                } else {
                                    MaterialTheme.colors.secondary
                                        .copy(alpha = 0.2f)
                                        .compositeOver(MaterialTheme.colors.background)
                                }
                            )
                            .padding(vertical = 12.dp, horizontal = 16.dp),
                    )
                }

                sVela = selectedOptionVelas
            }
        }
    }

}

//fun String.toCapital(): String { return this.lowercase().replaceFirstChar { it.titlecase(Locale.getDefault())} }

@Composable
fun MyBoton() {
    Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(10.dp)) {
        MyImage()
        MyTextBoton("Trimar")
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.air),
        contentDescription = "Mi imagen",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(end = 8.dp)
            .size(32.dp)
            //.clip(RoundedCornerShape(corner = CornerSize(16.dp))) //.clip(CircleShape)
        //.background(MaterialTheme.colors.primary)
    )
}

@Composable
fun MyTextGenerico(text: String) {
    Text(
        text = text,
        //modifier = Modifier. ,
        color = MaterialTheme.colors.primary,
        fontSize = TextUnit.Unspecified,
        fontStyle = FontStyle.Normal ,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.Monospace,
        letterSpacing = TextUnit.Unspecified,
        textDecoration = TextDecoration.None,
        textAlign = TextAlign.Justify,
        lineHeight = TextUnit.Unspecified,
        overflow = TextOverflow.Clip,
        softWrap = true,
        maxLines = Int.MAX_VALUE,
        style = MaterialTheme.typography.h5
    )
}

@Composable
fun MyTextCombo(text: String) {
    Text(
        text = text.uppercase(),
        color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun MyTextBoton(text: String) {
    Text(
        text = text,
        color = MaterialTheme.colors.onPrimary,
        style = MaterialTheme.typography.button,
        fontWeight = FontWeight.Bold
    )
}


@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomePreview() {

    BarcosTheme {

    }

}