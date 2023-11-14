package com.example.mytask.home

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mytask.R
import com.example.mytask.common.BottomNavigationBar
import com.example.mytask.common.DataLoadingView
import com.example.mytask.common.HeaderTextView
import com.example.mytask.common.NormalTextView
import com.example.mytask.common.bezierCurveCardProvider
import com.example.mytask.home.domain.models.ChargingData
import com.example.mytask.home.domain.models.NearestChargingStation
import com.example.mytask.home.presentation.events.HomeEvents
import com.example.mytask.home.presentation.viewmodel.HomeViewModel
import com.example.mytask.theme.Pink
import kotlinx.coroutines.launch
import java.lang.StrictMath.min

/**
 * Created by Mohammed Taguldeen on 03/11/2023.
 *
 *
 * This File represents the home screen , assumptions made for the header animations And scroll
 * point of the list
 */

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch { viewModel.getNearChargingStations() }
    }

    HomeScreenContent(state = viewModel.homeEvents.collectAsStateWithLifecycle().value)
}


@Composable
fun HomeScreenContent(state: HomeEvents) {
    Scaffold(bottomBar = { BottomNavigationBar() }, content = { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            when (state) {
                is HomeEvents.Error -> {
                    ErrorToast(throwable = state.throwable)
                }

                is HomeEvents.Loading -> {
                    DataLoadingView(innerPadding = innerPadding, modifier = Modifier)
                }

                is HomeEvents.NearStationsListReceivedSuccessFully -> {
                    with(state) {
                        SuccessView(innerPadding, chargingData, chargingStations)
                    }
                }
            }
        }
    })
}


@Composable
fun ErrorToast(throwable: Throwable) {
    Toast.makeText(LocalContext.current, throwable.message.toString(), Toast.LENGTH_SHORT).show()
}

@Composable
fun stationsList(list: List<NearestChargingStation>, scrollState: () -> LazyListState) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp), state = scrollState()
    ) {
        items(count = list.size, key = {
            list[it].id
        }, itemContent = { index ->
            NearbySuperchargesListView(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp), list[index]
            )
        })
    }
}

@Composable
fun HeaderView(scrollOffset: () -> Float, screenHeight: Dp, screenWidth: Dp) {
    val imageSize by animateDpAsState(
        targetValue = maxOf(290.dp, 70.dp * scrollOffset()), label = ""
    )
    val headerSize by animateDpAsState(
        targetValue = maxOf((screenHeight / 3) * scrollOffset(), 100.dp), label = ""
    )

    val isExpanded by remember {
        derivedStateOf {
            scrollOffset() > 0.9
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
            .height(headerSize)
    ) {
        AnimatedVisibility(
            visible = isExpanded,
            enter = fadeIn() + slideInHorizontally(animationSpec = tween(1000),
                initialOffsetX = { screenWidth.value.toInt() + imageSize.value.toInt() }),
            exit = fadeOut(
                animationSpec = tween(
                    200, easing = FastOutLinearInEasing
                )
            ) + slideOutHorizontally(animationSpec = tween(1000),
                targetOffsetX = { screenWidth.value.toInt() + imageSize.value.toInt() })
        ) {
            ExpandedHomeHeader(
                imageResizeRange = { imageSize },
                modifier = Modifier.fillMaxWidth(),
            )
        }
        AnimatedVisibility(
            visible = isExpanded.not(),
            enter = fadeIn() + slideInVertically(
                animationSpec = tween(1000),
                initialOffsetY = { screenHeight.value.toInt() / 2 }),
            exit = fadeOut() + slideOutVertically(
                animationSpec = tween(1000),
                targetOffsetY = { screenHeight.value.toInt() })
        ) {
            CollapsedHomeHeader(
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun SuccessView(
    innerPadding: PaddingValues,
    stats: List<ChargingData>,
    stationsList: List<NearestChargingStation>,
) {
    val context = LocalContext.current
    val config = LocalConfiguration.current
    val scrollState = rememberLazyListState()
    val scrollOffset by remember {
        derivedStateOf {
            /**
             *create a value starting from one and decreases as scroll through the list
             ***/
            min(
                1f,
                1 - (scrollState.firstVisibleItemScrollOffset / 300f + scrollState.firstVisibleItemIndex)
            )
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Pink)
            .padding(innerPadding)
    ) {
        HeaderView(
            scrollOffset = { scrollOffset },
            screenHeight = config.screenHeightDp.dp,
            screenWidth = config.screenWidthDp.dp
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .drawWithCache {
                onDrawBehind {
                    /**
                     * drawing the acquired Path and filling it with the white color
                     * */
                    drawPath(path = bezierCurveCardProvider(context = { context },
                        localConfiguration = { config }), color = Color.White, style = Fill
                    )
                }
            }) {

            batteryDataView(batteryData = stats)

            Row(
                modifier = Modifier
                    .height(50.dp)
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                HeaderTextView(
                    modifier = Modifier, text = "Nearby Supercharges", color = Color.DarkGray
                )
                Spacer(
                    Modifier
                        .weight(1f)
                        .fillMaxHeight()
                )
                NormalTextView(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = "View All",
                    color = Color.Gray
                )
            }
            stationsList(list = stationsList, scrollState = { scrollState })
        }

    }
}

@Composable
fun batteryDataView(batteryData: List<ChargingData>) {
    Row(modifier = Modifier.fillMaxWidth().height(50.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        HeaderTextView(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp),
            text = "Statistics",
            color = Color.DarkGray
        )
        ChargingLoader(
            modifier = Modifier
                .align(Alignment.Top)
                .padding(end = 42.dp)
                .height(75.dp),
            color = Color.White
        )
        Image(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.baseline_more_horiz_24),
            contentDescription = null
        )
    }
    LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
        items(count = batteryData.size, itemContent = { index ->
            val drawableId =
                if (index == 0) R.drawable.car_battery_solid else if (index == 1) R.drawable.battery_half_solid else R.drawable.charging_station_solid

            val drawableBgColor =
                if (index == 0) R.color.pale_red else if (index == 1) R.color.pale_green else R.color.pale_yellow

            StatisticsCard(
                drawableRes = drawableId,
                backgroundColor = drawableBgColor,
                valueAndUnit = batteryData[index].value,
                description = batteryData[index].description
            )
        })
    }
}

@Preview
@Composable
fun SuccessViewPreview() {
    val stats = listOf(
        ChargingData("240 volt", "Voltage"),
        ChargingData("540 km", "Remaining Charge"),
        /**
         * assumed this value based on design
         */
        ChargingData("20 Minutes", "Fast Charge")
    )
    val stationsList = (1..20).map {
        NearestChargingStation(
            id = it,
            unitsAvailable = (0..10).random().toString(),
            destination = "1.5",
            name = "station $it"
        )
    }
    SuccessView(innerPadding = PaddingValues(), stats = stats, stationsList = stationsList)
}