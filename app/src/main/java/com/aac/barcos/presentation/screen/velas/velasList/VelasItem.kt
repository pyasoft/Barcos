package com.aac.barcos.presentation.screen.velas.velasList

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aac.barcos.R
import com.aac.barcos.domain.model.NauticaComun
import com.aac.barcos.domain.model.Velas


@Composable
fun VelasItem(
    nautica: NauticaComun,
    onNavigation:(nauticaid: Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier,
        //modifier = Modifier.weight(1f)
    )
    {
        Row( modifier = Modifier.fillMaxWidth() )
        {

            Box( modifier = Modifier.size(60.dp), contentAlignment = Alignment.Center ){
                when (nautica.Elemento) {
                    "GENERAL" -> ImageItem( R.drawable.imgbaupres )
                    "PUÑO DE AMURA" -> ImageItem( R.drawable.imgbaupres )
                    "SITUACION DE LOS TRIPULANTES" -> ImageItem( R.drawable.imgbaupres )
                    "A TENER EN CUENTA" -> ImageItem( R.drawable.imgbaupres )
                    "SIN TANGON" -> ImageItem( R.drawable.imgbaupres )
                    "CON TANGON" -> ImageItem( R.drawable.imgbaupres )
                    "DRIZA Y BACK" -> ImageItem( R.drawable.imgdriza1 )
                    "DRIZA Y CUNNINGHAN" -> ImageItem( R.drawable.imgdriza1 )
                    "TANGON" -> ImageItem( R.drawable.imgbaupres )
                    "CARRO Y ESCOTA" -> ImageItem( R.drawable.imgcarrogenova )
                    "CONTRA" -> ImageItem( R.drawable.imgcontra)
                    "CARRO DE ESCOTA" -> ImageItem( R.drawable.imgcarro)
                    "DRIZA" -> ImageItem( R.drawable.imgdriza )
                    "PUÑO DE ESCOTA (PAJARÍN)" -> ImageItem( R.drawable.imgpajarin )
                    "CUNNINGHAN" -> ImageItem( R.drawable.imgcunninghan )
                    "ESCOTA" -> ImageItem( R.drawable.imgescota )
                    "ESCOTA Y BARBER" -> ImageItem( R.drawable.imgescotagenova )
                    "ESCOTA Y CARRO" -> ImageItem( R.drawable.imgescotagenova )
                    "ESCOTA Y REENVÍO" -> ImageItem( R.drawable.imgescotagenova )
                    "ESCOTA, POLEA Y BARBER" -> ImageItem( R.drawable.imgescotagenova )
                    "BACK" -> ImageItem( R.drawable.imgstayback )
                    "STAY" -> ImageItem( R.drawable.imgstayproa )
                    "STAY Y OBENQUES DIAGONALES" -> ImageItem( R.drawable.imgstayproa )
                    else -> ImageItem( R.drawable.barco_m )
                }
            }

            Spacer(modifier = Modifier.padding(4.dp))

            Column(modifier = Modifier.padding(end = 12.dp)) {
                Spacer( modifier = Modifier.height(8.dp) )
                Text(
                    //text = (nautica.Elemento + " (" + nautica.id.toString() + ")").uppercase(),
                    text = nautica.Elemento.uppercase(),
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
                Spacer( modifier = Modifier.height(4.dp) )
                Text(text = nautica.Accion, textAlign = TextAlign.Justify)
                Spacer( modifier = Modifier .height(8.dp) )
                Divider()
            }
        }
    }

}

@Composable
fun ImageItem( id: Int ) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(10))
    )
}

