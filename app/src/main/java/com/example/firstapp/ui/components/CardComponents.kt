package com.example.firstapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.R
import com.example.firstapp.ui.theme.FirstAppTheme

@Composable
fun CardComponents(){
    val img = painterResource(id = R.drawable.simon_riley_ghost)
    Row(
        modifier = Modifier
            .width(358.dp)
            .height(272.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = img,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(171.dp)
                .height(272.dp)
                .clip(shape = RoundedCornerShape(13.dp))
        )
        Column(modifier = Modifier
            .width(171.dp)
            .fillMaxHeight()
            .padding(vertical = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Column(
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Kotlin",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = stringResource(R.string.TextTest),
                    fontSize = 14.sp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = ""
                )
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = ""
                )
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = ""
                )
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = ""
                )
                Icon(
                    imageVector = Icons.Outlined.Star,
                    contentDescription = ""
                )
            }
        }
    }
}

@Preview( showBackground = true )
@Composable
fun PreviewCard(){
    FirstAppTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
                CardComponents()
        }
    }
}