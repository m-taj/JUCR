package com.example.mytask.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mytask.R
import com.example.mytask.common.NormalTextView
import com.example.mytask.common.TitleTextView
import com.example.mytask.home.domain.models.NearestChargingStation

/**
 * Created by Mohammed Taguldeen on 14/11/2023.
 */
@Composable
fun NearbySuperchargesListView(modifier: Modifier, nearestChargingStation: NearestChargingStation) {
    Row(
        modifier = modifier.background(
            color = colorResource(R.color.very_light_gray), shape = RoundedCornerShape(8.dp)
        )
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(horizontal = 16.dp)
        ) {
            TitleTextView(
                text = nearestChargingStation.name, modifier = Modifier.padding(horizontal = 4.dp)
            )
            NormalTextView(
                text = " ${nearestChargingStation.unitsAvailable}/10 available",
                modifier = Modifier.padding(4.dp)
            )
        }
        Spacer(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()

        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.location_on_24),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(32.dp),
                contentDescription = ""
            )
            NormalTextView(
                text = " ${nearestChargingStation.destination}km", modifier = Modifier.padding(8.dp)
            )
        }
    }
}