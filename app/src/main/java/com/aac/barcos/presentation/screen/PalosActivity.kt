package com.aac.barcos.presentation.screen

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aac.barcos.presentation.theme.BarcosTheme

@Composable
fun PalosScreen(onNavigation:() -> Unit) {

    ScaffoldPalos( onNavigation )

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldPalos(onNavigation:() -> Unit) {

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar("Trimado palos", onNavigation) },
        content = { Text("nautica")

            Surface(
                color = Color(0xFFFFFFFF),
                modifier = Modifier.fillMaxSize()
            ) {
                Palos()
            }
        }
    )
}

@Composable
fun Palos() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .verticalScroll(scrollState)
            .padding(all = 16.dp)
    ) {

        Text( text = "PUESTA A PUNTO DEL PALO", color = MaterialTheme.colors.primary, fontSize = 20.sp, fontWeight = FontWeight.Bold )

        Spacer( modifier = Modifier .height(10.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        Text( text = "Se divide en cuatro partes:", fontWeight = FontWeight.Bold )
        Text( text = "1-Inclinacion lateral.", fontWeight = FontWeight.Bold )
        Text( text = "2-Curva lateral.", fontWeight = FontWeight.Bold )
        Text( text = "3-Caida a popa.", fontWeight = FontWeight.Bold )
        Text( text = "4-Curva proa-popa.", fontWeight = FontWeight.Bold )


        Spacer( modifier = Modifier .height(30.dp) )


        Text( text = "INCLINACION LATERAL", color = MaterialTheme.colors.primary, fontSize = 20.sp, fontWeight = FontWeight.Bold )

        Spacer( modifier = Modifier .height(10.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        Text( text = "EL PROBLEMA", fontWeight = FontWeight.Bold )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Al igual que ocurre con la escora, la inclinacion lateral del palo es perjudicial porque crea TIMON A BARLOVENTO con el consiguiente freno de la pala." )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "El centro de esfuerzo se desplaza mas a sotavento y crea una fuerza que pivota alrededor del centro de resistencia del casco." )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Ademas del TIMON A BARLOVENTO, esta fuerza tambien provoca una tendencia constnte a irse de orzada." )

        Spacer( modifier = Modifier .height(20.dp) )

        Text( text = "SOLUCION", fontWeight = FontWeight.Bold )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Partiendo de la base que cada barco es ligeramente asimetrico, coja una cinta metrica metalica y haga las siguientes comprobaciones:" )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Ice la cinta metrica con la driza de la mayor y mida desde el tope del palo hasta las regalas de estribor y babor." )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Si despues de la comprobacion ve que el palo cae hacia uno de los lados elimine esta inclinacion ajustando los obenques altos." )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Ahora que el palo esta recto ajuste la tension de los obenques dando las mismas vueltas en cada tensor." )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Otra manera de ajustar los obenques es navegando en ceñida. para ello elija un dia con vientos medios y cuando el barco alcance una escora de 20 grados haga varios bordos y vaya tensando los obenques de sotavento hasta que tenga una oscilacion maxima de 3-4 milimetros." )

        Spacer( modifier = Modifier .height(20.dp) )

        Text( text = "A TENER EN CUENTA", fontWeight = FontWeight.Bold )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "La inclinacion lateral no debe confundirse con la curva lateral. La primera es una caida general del palo hacia una banda, mientras que la curva lateral esta causada por tensiones desiguales en los obenques (Bajos, intermedios y altos)." )


        Spacer( modifier = Modifier .height(30.dp) )


        Text( text = "CURVA LATERAL", color = MaterialTheme.colors.primary, fontSize = 20.sp, fontWeight = FontWeight.Bold )

        Spacer( modifier = Modifier .height(10.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        Text( text = "APAREJO A TOPE DE PALO CON DOS PISOS DE CRUCETAS", fontWeight = FontWeight.Bold )
        Spacer( modifier = Modifier .height(10.dp) )

        LineasTextoPalos( "Una vez tenga el palo completamente empieze el reglaje de abajo a arriba." )
        Spacer( modifier = Modifier .height(10.dp) )
        Text( text = "CURVA LATERAL INFERIOR.", fontWeight = FontWeight.Bold )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "CAUSA: Obenque bajo de barlovento demasiado flojo." )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Los obenques bajos deben ser tensados de manera que mantengan derecha la parte inferior del palo con grandes cargas (mas de 25 grados de escora)." )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Ahora ajuste los dos obenques intermedios hasta que la curva medio-superior desaparezca." )

        Spacer( modifier = Modifier .height(20.dp) )

        Text( text = "CURVA LATERAL SUPERIOR.", fontWeight = FontWeight.Bold )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "CAUSA: Obenque intermedio de barlovento demasiado flojo." )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Para conseguir el ajuste perfecto salga a navegar con viento medio y cuando en ceñida alcance los 20 grados de escora haga unos cuantos bordos. vaya ajustando los obenques de sotavento segun lo dicho anteriormente y procure que queden con una oscilacion maxima de 3-4 milimetros.." )
        Spacer( modifier = Modifier .height(10.dp) )
        Text( text = "A TENER EN CUENTA", fontWeight = FontWeight.Bold )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "En los aparejos a tope de palo la curva lateral es peligrosa: A medida que el viento sube el angulo entre el estremo del obenque alta y el palo disminuye aumentando la palanca sobre dicho obenque. Cuando el angulo es inferior a 12 grados el riesgo de arrancar el obenque o comprimir la cruceta es elevado." )

        Spacer( modifier = Modifier .height(30.dp) )

        Text( text = "CAIDA A POPA", color = MaterialTheme.colors.primary, fontSize = 20.sp, fontWeight = FontWeight.Bold )
        Spacer( modifier = Modifier .height(10.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        LineasTextoPalos( "La caida a popa se controla cambiando el largo del estay de proa y popa. Con esta inclinacion se mueve el centro velico hacia delante o hacia atras afectando el control del timon.", )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Aumentando la caida a popa (Estay de popa mas corto y el de proa mas largo) se desplaza el centro velico hacia atras y aumenta la presion en el timon (El barco tiende a orzar).", )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Como norma general, si el barco tiene escesiva tendencia a orzar se debera dar caida a proa; si por el contrario tiene demasiada tendencia a arribar, la caida debera ser hacia popa.", )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Los obenques bajos deben ser tensados de manera que mantengan derecha la parte inferior del palo con grandes cargas (mas de 25 grados de escora)." )

        Spacer( modifier = Modifier .height(20.dp) )

        LineasTextoPalos( "En los aparejos a tope de palo el estay de popa controla la tension del estay de proa y debera ser ajustado por medio de tensores hidraulicos, mecanicos o poleas (dependiendo del tamaño del barco). Lo deberemos tener presente cuando decidamos los grados de caida que queremos dar al palo." )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "Como ya hemos dicho en anteriores capitulos, cambios en la tension de proa producen cambios importantes en la forma de la genova y en su comportamiento." )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "En regata, cualquier sistema de medicion de la tension del estay de popa es esencial para repetir las distintas puestas a punto con rapidez (por ejemplo, marcas entre tensor y estay." )

        Spacer( modifier = Modifier .height(20.dp) )

        Text( text = "A TENER EN CUENTA", fontWeight = FontWeight.Bold )
        Spacer( modifier = Modifier .height(10.dp) )
        LineasTextoPalos( "La caida a popa no debe confundirse con la curba de proa-popa. La primera es la inclinacion general del palo hacia popa que afecta principalmente al timon, mientras que la curva proa-popa permite trimar la mayor para cualquier condicion de viento y navegacion." )

    }
}


@Composable
fun LineasTextoPalos( texto1: String ) {
    Text( text = texto1, textAlign = TextAlign.Justify )
}



@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PalosPreview() {
    BarcosTheme {
        Palos()
    }
}