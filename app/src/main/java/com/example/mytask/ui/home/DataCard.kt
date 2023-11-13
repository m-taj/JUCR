package com.example.mytask.ui.home

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mytask.R
import com.example.mytask.ui.common.NormalTextView
import com.example.mytask.ui.common.TitleTextView

@Composable
fun StatisticsCard(
    @DrawableRes drawableRes: Int,
    @ColorRes backgroundColor: Int,
    valueAndUnit: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        border = BorderStroke(1.dp, colorResource(id = R.color.very_light_gray)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        modifier = modifier
            .requiredSize(160.dp)
            .padding(8.dp)
            .background(
                color = Color.White, shape = RoundedCornerShape(8.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White)
                .padding(vertical = 12.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = drawableRes),
                contentDescription = "",
                modifier = Modifier
                    .width(42.dp)
                    .height(42.dp)
                    .background(colorResource(id = backgroundColor), CircleShape)
                    .clip(CircleShape)
                    .padding(10.dp),
                contentScale = ContentScale.Crop,
            )
            Spacer(
                Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
            TitleTextView(
                text = valueAndUnit,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            )
            NormalTextView(
                text = description,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            )
        }
    }
}