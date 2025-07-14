package com.bignerdranch.fitrahmind_app.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bignerdranch.fitrahmind_app.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.bignerdranch.fitrahmind_app.domain.models.Surat

@Composable
fun QuranScreen(navController: NavController, viewModel: SuratsViewModel = viewModel()) {

    LaunchedEffect(Unit){
        viewModel.fetchSurat()
    }

    val surats by viewModel.suratList
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            QuranHeader()
            LastReadSection()
            bookmarkSection()
            Spacer(modifier = Modifier.height(20.dp))
        }

        item{
            Row(modifier = Modifier.fillMaxWidth()) {
                quranNavigateButton(text = "Surat", onClick = {})
                quranNavigateButton(text = "Juz", onClick = {})
                quranNavigateButton(text = "Halaman", onClick = {})
            }
        }

        items(surats){surat ->
            QuranListItem(surat){
                navController.navigate("surat/${surat.idSurat}")
            }
        }
    }
}

@Composable
fun quranNavigateButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = Modifier
            .width(120.dp)
            .drawBehind {
                val strokeWidth = 4.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = Color(0xFF3D8D7A),
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            }
    ) {
        Text(text = text, color = Color.Black)
    }
}

@Composable
fun QuranHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(horizontal = 15.dp)
    ) {
        Text(text = "Al-Qur'an", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun LastReadSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Last Read",
                fontFamily = FontFamily(Font(R.font.sarabun)),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Button(
                onClick = { /* Handle click */ },
                contentPadding = PaddingValues(horizontal = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "See All")
            }
        }
        Row{
            lastReadItem()
            Spacer(modifier = Modifier.width(20.dp))
            lastReadItem()
        }
    }
}

@Composable
fun lastReadItem(

){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFCDE8E5))
            .clickable(){}
            .padding(10.dp)
    ){
        Text(
            text = "Al-Baqarah",
            fontFamily = FontFamily(Font(R.font.saira)),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ){
            Text(
                text = "Juz 1",
                fontFamily = FontFamily(Font(R.font.saira)),
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
            Icon(
                painter = painterResource(R.drawable.circle_symbol),
                contentDescription = ""
            )
            Text(
                text = "Verse 9",
                fontFamily = FontFamily(Font(R.font.saira)),
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
        }
    }
}

@Composable
fun bookmarkSection(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Your Bookmark",
                fontFamily = FontFamily(Font(R.font.sarabun)),
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Button(
                onClick = { /* Handle click */ },
                contentPadding = PaddingValues(horizontal = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            ) {
                Text(text = "See All")
            }
        }
        Row{
            bookmarkItem()
            Spacer(modifier = Modifier.width(20.dp))
            bookmarkItem()
        }
    }
}

@Composable
fun bookmarkItem(){
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0xFFCDE8E5))
            .clickable(){}
            .padding(10.dp)
            .clipToBounds()
    ){
        Text(
            text = "Orang Tua",
            fontFamily = FontFamily(Font(R.font.saira)),
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
        )
        Text(
            text = "Dalil tentang Aturan atau tata krama terhadap orang tua",
            fontFamily = FontFamily(Font(R.font.saira)),
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            modifier = Modifier.width(170.dp),
            maxLines = 3
        )
    }
}

@Composable
fun QuranListItem(
    surat: Surat,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(Color(0xFFFBFFE4))
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp, horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SurahNumberBadge(number = surat.idSurat)
            Spacer(modifier = Modifier.width(10.dp))
            Column (
                modifier = Modifier.width(200.dp)
            ) {
                Text(
                    text = surat.namaSurat,
                    fontFamily = FontFamily(Font(R.font.geologica)),
                    fontWeight = FontWeight.SemiBold)
                Text(
                    text = surat.artiSurat,
                    fontFamily = FontFamily(Font(R.font.geologica)),
                    modifier = Modifier.alpha(0.5f),
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End){
                Text(
                    text = surat.namaSuratArab,
                    fontFamily = FontFamily(Font(R.font.lpmq)),
                    fontSize = 20.sp,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Text(
                    text = "${surat.jumlahAyat} Ayat",
                    fontFamily = FontFamily(Font(R.font.geologica)),
                    modifier = Modifier.alpha(0.5f),
                    fontSize = 13.sp
                )
            }
        }
    }
}

@Composable
fun SurahNumberBadge(number: Int) {
    Box(
        modifier = Modifier
            .size(50.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.octagon),
            contentDescription = "Surah Number",
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color(0xFF3D8D7A))
        )
        Text(
            text = number.toString(),
            fontFamily = FontFamily(Font(R.font.geologica)),
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun QuranScreenPreview(){
//    FitrahmindappTheme{
//        QuranScreen()
//    }
//}