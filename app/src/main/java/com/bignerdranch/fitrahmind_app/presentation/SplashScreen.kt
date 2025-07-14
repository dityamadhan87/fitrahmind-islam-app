package com.bignerdranch.fitrahmind_app.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.bignerdranch.fitrahmind_app.R
import com.bignerdranch.fitrahmind_app.ui.theme.FitrahmindappTheme
import kotlinx.coroutines.delay

@Composable
fun splashScreen(
    onSplashEnd: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9EFEC)),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.logo_fitrah_mind),
            contentDescription = "Logo Fitrah Mind",
        )
    }
    LaunchedEffect(Unit){
        delay(3000)
        onSplashEnd()
    }
}

@Preview(showBackground = true)
@Composable
fun splashScreenPreview(){
    FitrahmindappTheme{
        splashScreen {  }
    }
}