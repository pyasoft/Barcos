package com.aac.barcos.presentation.screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import com.aac.barcos.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onNavigation:() -> Unit) {
    val scale = remember { Animatable(0f) }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 2f,
            animationSpec = tween(
                durationMillis = 800,
                easing = { OvershootInterpolator(4f).getInterpolation(it) })
        )
        // Customize the delay time
        delay(500L)
        onNavigation()
    }

    Column( modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.barco_m),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value)
        )
    }

}
