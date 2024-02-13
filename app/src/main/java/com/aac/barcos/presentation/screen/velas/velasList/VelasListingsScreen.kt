package com.aac.barcos.presentation.screen.velas.velasList

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aac.barcos.presentation.screen.TopBar
import com.aac.barcos.presentation.screen.velas.velassDetail.rumboDescripcion
import com.aac.barcos.presentation.screen.velas.velassDetail.velaDescripcion
import com.aac.barcos.presentation.screen.velas.velassDetail.vientoDescripcion
import com.aac.barcos.presentation.theme.BarcosTheme
import com.google.accompanist.pager.*
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshState
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
//@Destination(start = true)
fun VelasListingsScreen(
    rumbo: String,
    viento: String,
    vela: String,
    onNavigation:() -> Unit,
    onNavigation2:(nauticaid: Int) -> Unit
) {
    val viewModel: VelasListingsViewModel = hiltViewModel()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = viewModel.state.isRefreshing)

    viewModel.onEvent(VelasListingsEvent.OnSearchQueryChange(rumbo = rumbo, viento = viento, vela = vela))

    MaterialTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            ScaffoldList(viewModel, swipeRefreshState, rumbo, viento, vela, onNavigation, onNavigation2)
        }
    }

}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun ScaffoldList(
    viewModel: VelasListingsViewModel,
    swipeRefreshState: SwipeRefreshState,
    rumbo: String,
    viento: String,
    vela: String,
    onNavigation:() -> Unit,
    onNavigation2:(nauticaid: Int) -> Unit
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = { TopBar(rumboDescripcion(rumbo) + " - " + vientoDescripcion(viento) + " - " + velaDescripcion(vela), onNavigation) },

        ) {
        Column {
            MyList( viewModel, swipeRefreshState, onNavigation2 )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun MyList(
    viewModel: VelasListingsViewModel,
    swipeRefreshState: SwipeRefreshState,
    onNavigation:(nauticaid: Int) -> Unit
) {

    SwipeRefresh(
        state = swipeRefreshState,
        //state = rememberSwipeRefreshState(isRefreshing = viewModel.state.isRefreshing),
        onRefresh = {
            //viewModel.state = viewModel.state.copy(rumbo = rumbo, viento = viento, vela = vela)
            viewModel.onEvent(VelasListingsEvent.Refresh)
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(viewModel.state.nauticas){ nautica ->
                VelasItem(
                    nautica = nautica,
                    onNavigation = onNavigation,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onNavigation(nautica.id) }
                        .padding(5.dp)
                )
            }

        }
    }

}



/*

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun ScaffoldList(
    viewModel: VelasListingsViewModel,
    swipeRefreshState: SwipeRefreshState,
    rumbo: String,
    viento: String,
    tabs: List<TabItem>,
    onNavigation:() -> Unit,
    onNavigation2:(nauticaid: Int) -> Unit
) {
    Log.i("CASO", "2")
    val pagerState = rememberPagerState(pageCount = tabs.size)
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        topBar = { TopBar(RumboDescripcion(rumbo) + " - " + VientoDescripcion(viento), onNavigation) }
    ) {
        Column {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabContent( viewModel, tabs = tabs, pagerState = pagerState, swipeRefreshState, rumbo, viento, onNavigation2 )
        }
    }
}


@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    /*
    ScrollableTabRow(
        modifier = Modifier.fillMaxWidth(),
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Transparent,
        edgePadding = 0.dp,
        //modifier = Modifier.height(80.dp),
        indicator = { tabPositions ->
            TabRowDefaults.Indicator( color = Color.White,height = 2.dp, modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions) )
        }
    ) {
        tabs.forEachIndexed{ index, tab ->
            LeadingIconTab(
                icon = { Icon( painter = painterResource(id = tab.icon), contentDescription = "", tint = Color.Unspecified ) },
                text = { MyTextTap(tab.vela.descripcion()) },
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } }
            )
        }
    }

     */

    Log.i("CASO", "3")
    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        edgePadding = 0.dp,
        //modifier = Modifier.height(80.dp),
        indicator = { tabPositions ->
            TabRowDefaults.Indicator( Modifier.pagerTabIndicatorOffset(pagerState, tabPositions) )
        }
    ) {
        tabs.forEachIndexed{ index, tab ->
            LeadingIconTab(
                icon = { Icon( painter = painterResource(id = tab.icon), contentDescription = "", tint = Color.Unspecified ) },
                text = { MyTextTap(tab.vela.descripcion()) },
                selected = pagerState.currentPage == index,
                onClick = { scope.launch { pagerState.animateScrollToPage(index) } }
            )

        }
    }
}



@ExperimentalPagerApi
@Composable
fun TabContent(
    viewModel: VelasListingsViewModel,
    tabs: List<TabItem>,
    pagerState: PagerState,
    swipeRefreshState: SwipeRefreshState,
    rumbo: String,
    viento: String,
    onNavigation:(nauticaid: Int) -> Unit
) {

    Log.i("CASO", "4")
    HorizontalPager(state = pagerState, verticalAlignment = Alignment.Top) { pager ->
        MyList(viewModel, tabs, pagerState, swipeRefreshState, rumbo, viento, tabs[pager].vela.name, onNavigation)
    }
}

 */


@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListPreview() {
    BarcosTheme {
        //MyList(newNauticas)
    }
}

