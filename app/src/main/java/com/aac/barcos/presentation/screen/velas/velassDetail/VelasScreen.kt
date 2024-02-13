package com.aac.barcos.presentation.screen.velas.velassDetail

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aac.barcos.R
import com.aac.barcos.domain.model.NauticaComun
import com.aac.barcos.domain.model.Rumbos
import com.aac.barcos.domain.model.Velas
import com.aac.barcos.domain.model.Vientos
import com.aac.barcos.presentation.screen.TopBar

@Composable
//@Destination
fun VelasScreen(
    nauticaId: Int,
    onNavigation:() -> Unit
) {
    val viewModel: VelasViewModel = hiltViewModel()
    viewModel.RecNautica2(nauticaId)

    val state = viewModel.state

    if(state.error == null) {
        state.nautica?.let { nautica ->
            ScaffoldDetail( nautica, onNavigation )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if(state.isLoading) {
            CircularProgressIndicator()
        } else if(state.error != null) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error
            )
        }
    }

}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldDetail(nautica: NauticaComun, onNavigation:() -> Unit) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(rumboDescripcion(nautica.Rumbo) + " - " + vientoDescripcion(nautica.Viento) + " - " + velaDescripcion(nautica.Vela), onNavigation) },
        content = { MyDetail(nautica) }
    )
}

@Composable
fun MyDetail(nautica: NauticaComun) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
        .verticalScroll(scrollState)
        .padding(all = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        CircleImg(nautica)
        Spacer(modifier = Modifier.height(10.dp))
        MyContent(nautica)
    }
}

@Composable
fun CircleImg(nautica: NauticaComun) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        when (nautica.Elemento) {

            "CARRO DE ESCOTA" -> ImageVela( R.drawable.imgcarro )
            "CONTRA" -> ImageVela( R.drawable.imgcontra )
            "DRIZA" -> ImageVela( R.drawable.imgdriza )
            "CUNNINGHAN" -> ImageVela( R.drawable.imgcunninghan )
            "ESCOTA" -> ImageVela( R.drawable.imgescota )
            "CARRO Y ESCOTA" -> ImageVela( R.drawable.imgcarrogenova )
            "PUÑO DE ESCOTA (PAJARÍN )" -> ImageVela( R.drawable.imgpajarin )
            "GENERAL" -> ImageVela( R.drawable.imgbaupres )
            "PUÑO DE AMURA" -> ImageVela( R.drawable.imgbaupres )
            "SITUACION DE LOS TRIPULANTES" -> ImageVela( R.drawable.imgbaupres )
            "A TENER EN CUENTA" -> ImageVela( R.drawable.imgbaupres )
            "SIN TANGON" -> ImageVela( R.drawable.imgbaupres )
            "CON TANGON" -> ImageVela( R.drawable.imgbaupres )
            "DRIZA Y BACK" -> ImageVela( R.drawable.imgdriza1 )
            "DRIZA Y CUNNINGHAN" -> ImageVela( R.drawable.imgdriza1 )
            "TANGON" -> ImageVela( R.drawable.imgbaupres )
            "ESCOTA Y BARBER" -> ImageVela( R.drawable.imgescotagenova )
            "ESCOTA Y CARRO" -> ImageVela( R.drawable.imgescotagenova )
            "ESCOTA Y REENVÍO" -> ImageVela( R.drawable.imgescotagenova )
            "ESCOTA, POLEA Y BARBER" -> ImageVela( R.drawable.imgescotagenova )
            "BACK" -> ImageVela( R.drawable.imgstayback )
            "STAY" -> ImageVela( R.drawable.imgstayproa )
            "STAY Y OBENQUES DIAGONALES" -> ImageVela( R.drawable.imgstayproa )
            else -> ImageVela( R.drawable.barco_m )

        }

    }
}

@Composable
fun ImageVela( id: Int ) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            //.size(200.dp)
            .clip(RoundedCornerShape(10))
    )
}


@Composable
fun MyContent(nautica: NauticaComun) {
    //val tamaño : TextUnit = rememberSaveable(20.sp)
    Column {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            //text = nautica.Elemento + " (" + nautica.id.toString() + ")".uppercase(),
            text = nautica.Elemento.uppercase(),
            color = MaterialTheme.colors.primary, fontSize = 20.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Accion".uppercase(),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Divider(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(12.dp))
        SelectionContainer {
            Text(text = nautica.Accion, textAlign = TextAlign.Justify)
        }

    }
}

fun rumboDescripcion(rumbo: String): String =
    when (rumbo) {
        Rumbos.CENIDA.name -> Rumbos.CENIDA.descripcion()
        Rumbos.TRAVES.name -> Rumbos.TRAVES.descripcion()
        Rumbos.POPA.name -> Rumbos.POPA.descripcion()
        else -> Rumbos.CENIDA.descripcion()
    }

fun vientoDescripcion(viento: String): String =
    when (viento) {
        Vientos.FLOJO.name -> Vientos.FLOJO.descripcion()
        Vientos.MEDIO.name -> Vientos.MEDIO.descripcion()
        Vientos.FUERTE.name -> Vientos.FUERTE.descripcion()
        else -> Vientos.FLOJO.descripcion()
    }

fun velaDescripcion(vela: String): String =
    when (vela) {
        Velas.MAYOR.name -> Velas.MAYOR.descripcion()
        Velas.GENOVA.name -> Velas.GENOVA.descripcion()
        Velas.SPI.name -> Velas.SPI.descripcion()
        Velas.GEN.name -> Velas.GEN.descripcion()
        else -> Velas.MAYOR.descripcion()
    }


@Composable
fun MyTexts(nautica: NauticaComun) {
    Text(
        text = nautica.id.toString(),
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = nautica.Rumbo,
        fontStyle = FontStyle.Italic,
        fontSize = 14.sp,
        modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(8.dp))
    Divider(modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "Viento: ${nautica.Viento}",
        fontSize = 14.sp,
        modifier = Modifier.fillMaxWidth(),
        overflow = TextOverflow.Ellipsis
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "Vela: ${nautica.Vela}",
        fontSize = 14.sp,
        modifier = Modifier.fillMaxWidth(),
        overflow = TextOverflow.Ellipsis
    )
    Spacer(modifier = Modifier.height(8.dp))
    Divider(modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = nautica.Elemento,
        fontSize = 12.sp,
        modifier = Modifier.fillMaxWidth(),
    )
    Spacer(modifier = Modifier.height(8.dp))
    Divider(modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = nautica.Accion,
        fontSize = 12.sp,
        modifier = Modifier.fillMaxWidth(),
    )
}
