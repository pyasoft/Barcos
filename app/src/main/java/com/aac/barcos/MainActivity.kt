package com.aac.barcos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aac.barcos.presentation.screen.*
import com.aac.barcos.presentation.screen.velas.VelasActivity
import com.aac.barcos.presentation.screen.velas.velasList.VelasListingsScreen
import com.aac.barcos.presentation.screen.velas.velassDetail.VelasScreen
import com.aac.barcos.presentation.theme.BarcosTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

object NavRoute {
    const val SCREEN_SPLASH =   "splashScreen"
    const val SCREEN_GLOSARIO = "GlosarioScreen"
    const val SCREEN_PALOS =    "PalosScreen"
    const val SCREEN_AJUSTES =  "AjustesScreen"
    const val SCREEN_ABOUT =    "AboutScreen"
    const val SCREEN_VELAS =    "VelasScreen"
    const val SCREEN_LIST =     "ListScreen"
    const val SCREEN_DETAIL =   "DetailScreen"
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //private val viewModel by viewModels<MainViewModel>()

    //@ExperimentalMaterialApi
    //@ExperimentalPagerApi
    @OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BarcosTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationComponent(navController)
                    //DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }

    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun NavigationComponent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.SCREEN_SPLASH
    ) {

        val routeSplash = NavRoute.SCREEN_SPLASH
        val routeGlosario = NavRoute.SCREEN_GLOSARIO
        val routePalos = NavRoute.SCREEN_PALOS
        val routeAjustes = NavRoute.SCREEN_AJUSTES
        val routeAyuda = NavRoute.SCREEN_ABOUT
        val routeVelas = NavRoute.SCREEN_VELAS
        val routeWithArgumentsList = "${NavRoute.SCREEN_LIST}/{rumbo}/{viento}/{vela}"
        val routeWithArgumentsDetail = "${NavRoute.SCREEN_DETAIL}/{nauticaId}"

        composable(routeSplash) {
            SplashScreen { navController.navigate(NavRoute.SCREEN_VELAS) }
        }

        // Main Screen
        //{ navController.navigate(NavRoute.SCREEN_VELAS)   { popUpTo(NavRoute.SCREEN_VELAS)   { inclusive = true } } },

        composable(routeGlosario) {
            GlosarioScreen { navController.popBackStack() }
        }

        composable(routePalos) {
            PalosScreen { navController.popBackStack() }
        }

        composable(routeAjustes) {
            AboutScreen { navController.popBackStack() }
        }

        composable(routeAyuda) {
            AyudaScreen { navController.popBackStack() }
        }

        composable(routeVelas) {
            VelasActivity(
                { navController.navigate(NavRoute.SCREEN_GLOSARIO) },
                { navController.navigate(NavRoute.SCREEN_PALOS) },
                { navController.navigate(NavRoute.SCREEN_AJUSTES) },
                { navController.navigate(NavRoute.SCREEN_ABOUT) }
            ){ rum ,vie, vel ->
                navController.navigate("${NavRoute.SCREEN_LIST}/${rum}/${vie}/${vel}")
            }
        }

        composable(
            route = routeWithArgumentsList,
            arguments = listOf(
                navArgument("rumbo") {},
                navArgument("viento") {},
                navArgument("vela") {}
            )
        ){ backStackEntry ->
            val idRumbo =  backStackEntry.arguments?.getString("rumbo")
            val idViento = backStackEntry.arguments?.getString("viento")
            val idVela = backStackEntry.arguments?.getString("vela")
            requireNotNull(idRumbo)
            requireNotNull(idViento)
            requireNotNull(idVela)

            VelasListingsScreen( idRumbo, idViento, idVela, { navController.popBackStack() } ){ id ->
                navController.navigate("${NavRoute.SCREEN_DETAIL}/${id}")
             }
        }

        composable(
            route = routeWithArgumentsDetail,
            arguments = listOf(navArgument("nauticaId") { type = NavType.IntType } )
        ){ backStackEntry ->
            val id = backStackEntry.arguments?.getInt("nauticaId")
            requireNotNull(id)

            VelasScreen(id) { navController.popBackStack() }
        }
    }
}
