package com.aac.barcos.presentation.screen

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aac.barcos.presentation.theme.ShimmerColorShades
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopBarDrawer(text: String, scaffoldState: ScaffoldState, scope: CoroutineScope) {
    TopAppBar(
        //title = { MyTextTopBar(text = stringResource(R.string.app_name)) },
        title = { MyTextTopBar(text = text) },
        navigationIcon = {
            IconButton(
                onClick = { scope.launch { scaffoldState.drawerState.open() } },
                content = { Icon(Icons.Filled.Menu, "") }
            )
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    )
}

@Composable
fun TopBar(text: String, onNavigation:() -> Unit) {
    TopAppBar(
        title = { MyTextTopBar(text = text) },
        navigationIcon = {
            IconButton(onClick = { onNavigation() })
            {
                Icon(Icons.Filled.ArrowBack, "")
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    )
}

@Composable
fun MyTextTopBar(text: String) {
    Text(
        text = text,
        fontSize = 18.sp
        //color = MaterialTheme.colors.onPrimary,
        //style = MaterialTheme.typography.h5
    )
}

@Composable
fun DrawerContent(scaffoldState: ScaffoldState, scope: CoroutineScope, onNavigation2:() -> Unit, onNavigation3:() -> Unit, onNavigation4:() -> Unit, onNavigation5:() -> Unit) {
    Column( modifier = Modifier.background(MaterialTheme.colors.background) ) {
        // Header
        Spacer( modifier = Modifier.height(10.dp) )
        MyTextMenuHeader( text = "Barcos", Modifier.align(Alignment.CenterHorizontally) )

        Spacer( modifier = Modifier .height(5.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        // List of navigation items
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    onNavigation2()
                    scope.launch { scaffoldState.drawerState.close() }
                })
                .height(45.dp)
                .padding(start = 10.dp)
        ) {
            Icon(Icons.Filled.List, "")
            Spacer(modifier = Modifier.width(7.dp))
            MyTextMenu( text = "Glosario" )
        }

        Spacer( modifier = Modifier .height(5.dp) )
        Divider(modifier = Modifier.padding(start = 10.dp) )
        Spacer( modifier = Modifier .height(5.dp) )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    onNavigation3()
                    scope.launch { scaffoldState.drawerState.close() }
                })
                .height(45.dp)
                .padding(start = 10.dp)
        ) {
            Icon(Icons.Filled.Build, "")
            Spacer(modifier = Modifier.width(7.dp))
            MyTextMenu( text = "Trimado palos" )
        }

        Spacer( modifier = Modifier .height(5.dp) )
        Divider()
        Spacer( modifier = Modifier .height(10.dp) )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    onNavigation4()
                    scope.launch { scaffoldState.drawerState.close() }
                })
                .height(45.dp)
                .padding(start = 10.dp)
        ) {
            Icon(Icons.Filled.Edit, "")
            Spacer(modifier = Modifier.width(7.dp))
            MyTextMenu( text = "About" )
        }

        Spacer( modifier = Modifier .height(5.dp) )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = {
                    onNavigation5()
                    scope.launch { scaffoldState.drawerState.close() }
                })
                .height(45.dp)
                .padding(start = 10.dp)
        ) {
            Icon(Icons.Filled.Info, "")
            Spacer(modifier = Modifier.width(7.dp))
            MyTextMenu( text = "Ayuda y comentarios" )
        }

        Spacer( modifier = Modifier .height(5.dp) )
        Divider()
        Divider(modifier = Modifier.weight(1f))

        MyTextMenuDown( text = "Developed by Alfonso Alonso", Modifier.align(Alignment.CenterHorizontally))
        Spacer( modifier = Modifier .height(5.dp) )
    }

}

@Composable
fun MyTextMenuHeader(text: String, modi: Modifier) {
    Text(
        text = text, //.uppercase(),
        fontSize = 32.sp,
        color = MaterialTheme.colors.onBackground,
        textAlign = TextAlign.Center,
        modifier = modi
    )
}

@Composable
fun MyTextMenu(text: String) {
    Text(
        text = text,//.uppercase(),
        fontSize = 18.sp,
        color = MaterialTheme.colors.onBackground
    )
}

@Composable
fun MyTextMenuDown(text: String, modi: Modifier) {
    Text(
        text = text, //.uppercase(),
        color = MaterialTheme.colors.onBackground,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = modi
    )
}



@Composable
fun ContentPrincipal() {
    /*
    val colorR: Int = Random.nextInt(256)
    val colorG: Int = Random.nextInt(256)
    val colorB: Int = Random.nextInt(256)
    val color = Color( colorR, colorG, colorB)

    Text(
        text = "Pantalla principal",
        color = color,
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
    Icon(Icons.Filled.Create, "", modifier = Modifier.fillMaxSize() )
    */
/*
    //Lazy column as I am adding multiple items for display purpose create you UI according to requirement
    LazyColumn {
        //Lay down the Shimmer Animated item 5 time [repeat] is like a loop which executes the body according to the number specified
        repeat(2) {
            item {

            }
        }
    }
    */
    ShimmerAnimation()
}

@Composable
fun ShimmerAnimation() {
    //Create InfiniteTransition which holds child animation like [Transition]
    //animations start running as soon as they enter the composition and do not stop unless they are removed
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        //Specify animation positions, initial Values 0F means it starts from 0 position
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            //Tween Animates between values over specified [durationMillis]
            tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            RepeatMode.Reverse
        )
    )

    //Create a gradient using the list of colors
    //Use Linear Gradient for animating in any direction according to requirement
    //start=specifies the position to start with in cartesian like system Offset(10f,10f) means x(10,0) , y(0,10)
    //end= Animate the end position to give the shimmer effect using the transition created above
    val brush = Brush.linearGradient(
        colors = ShimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(translateAnim, translateAnim)
    )

    ShimmerItem(brush = brush)
}

@Composable
fun ShimmerItem( brush: Brush) {
    //Column composable shaped like a rectangle, set the [background]'s [brush] with the
    //brush receiving from [ShimmerAnimation] which will get animated.
    //Add few more Composable to test
    Column(modifier = Modifier.padding(0.dp)) {
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                //.fillMaxWidth()
                //.size(250.dp)
                .background(brush = brush)
        )
    }
}
