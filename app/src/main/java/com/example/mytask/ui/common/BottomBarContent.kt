package com.example.mytask.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytask.R

/**
 * Content within the bottom bar
 */
@Composable
fun BottomNavigationBar () {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        shape =  RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
        shadowElevation = 8.dp,
        content = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_car_solid),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_search_solid),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_map_solid),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_user_solid),
                    contentDescription = null
                )
            }
        }
    )

}

@Preview
@Composable
fun bottomBarPreview() {
    BottomNavigationBar()
}