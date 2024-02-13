package com.aac.barcos.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = ColorAzulOscuro,
    //primaryVariant = Color,
    secondary = ColorAzulOscuro,
    //secondaryVariant = Color,
    background = ColorGris,
    surface = ColorGrisClaro,
    //error = Color,
    onPrimary = ColorWhite,
    onSecondary = ColorWhite,
    onBackground = ColorBlack,
    onSurface = ColorBlack,
    //onError = Color
)

private val LightColorPalette = lightColors(

    primary = ColorAzulOscuro,
    //primaryVariant = Color,
    secondary = ColorAzulOscuro,
    //secondaryVariant = Color,
    background = ColorGris,
    surface = ColorGrisClaro,
    //error = Color,
    onPrimary = ColorWhite,
    onSecondary = ColorWhite,
    onBackground = ColorBlack,
    onSurface = ColorBlack,
    //onError = Color

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BarcosTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}