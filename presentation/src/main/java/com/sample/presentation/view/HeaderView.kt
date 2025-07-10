package com.sample.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sample.presentation.R

@Composable

fun HeaderView(headerText: String,navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.box_65dp))
            .background(color = Color.Gray)

    ){
        Row (modifier = Modifier
            .fillMaxHeight()
            .align(Alignment.CenterStart)
            .padding(start = dimensionResource(R.dimen.height_16dp)),
            verticalAlignment = Alignment.CenterVertically)
        {
            if(headerText == stringResource(id = R.string.header)){
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.header),
                    Modifier.size(dimensionResource(R.dimen.size_32dp)),
                    tint = Color.Black
                )
            } else{
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.size_25dp)))
            Text(
                text = headerText,
                fontSize = 25.sp,
                color = Color.Black
            )
        }
    }
}