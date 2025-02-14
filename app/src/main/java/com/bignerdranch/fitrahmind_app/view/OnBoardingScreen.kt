package com.bignerdranch.fitrahmind_app.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.fitrahmind_app.R
import com.bignerdranch.fitrahmind_app.ui.theme.FitrahmindappTheme

@Composable
fun onBoardingScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF16423C))
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_fitrah_mind),
            contentDescription = "Logo Fitrah Mind",
            modifier = Modifier.align(Alignment.Start)
                .width(100.dp),
            colorFilter = ColorFilter.tint(Color(0xFFE9EFEC))
        )

        Spacer(modifier = Modifier.height(300.dp))

        Column(

        ){
            Text(
                text = "Hidup Lebih Bermakna dengan Ilmu dan Ibadah",
                style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 38.sp,
                    color = Color(0xFFE9EFEC)
                ),
                modifier = Modifier.width(340.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Fitrah Mind hadir untuk membangun hati, pikiran, " +
                        "dan karakter Islami melalui kemudahan teknologi.",
                style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    color = Color(0xFFE9EFEC),
                    lineHeight = 27.sp
                ),
                modifier = Modifier.width(340.dp)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Column(

        ){
            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(),
                border = BorderStroke(1.dp, Color(0xFFE9EFEC))
            ){
                Text(
                    text = "Baca Langsung",
                    style = TextStyle(
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = Color(0xFFE9EFEC)
                    )
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE9EFEC),
                    contentColor = Color.Black
                )
            ){
                Text(
                    text = "Login",
                    style = TextStyle(
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun onBoardingScreenPreview(){
    FitrahmindappTheme{
        onBoardingScreen()
    }
}