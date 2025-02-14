package com.bignerdranch.fitrahmind_app.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bignerdranch.fitrahmind_app.R
import com.bignerdranch.fitrahmind_app.ui.theme.FitrahmindappTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bignerdranch.fitrahmind_app.viewmodel.SuratsViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.bignerdranch.fitrahmind_app.model.Surat

@Composable
fun QuranScreen(viewModel: SuratsViewModel = viewModel()) {
    val surats by viewModel.surats.collectAsState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        item {
            QuranHeader()
            LastReadSection()
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = "Al-Qur'an", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun LastReadSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color(0xFFC4DAD2))
            .padding(15.dp)
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.last_icons),
                contentDescription = "Last Read"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Last Read", style = MaterialTheme.typography.titleSmall)
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.quran_image),
                contentDescription = "Quran Image",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Quran Completion", style = MaterialTheme.typography.bodySmall)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Al-Maidah ayat 1")
                    Text(text = "15%")
                }
            }
        }
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
            .height(80.dp)
            .background(Color(0xFFFBFFE4))
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            SurahNumberBadge(number = surat.idSurat)
            Spacer(modifier = Modifier.width(10.dp))
            Column (
            ) {
                Text(
                    text = surat.namaSurat,
                    fontFamily = FontFamily(Font(R.font.geologica)),
                    fontWeight = FontWeight.SemiBold)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ){
                    Text(
                        text = surat.artiSurat,
                        fontFamily = FontFamily(Font(R.font.geologica)),
                        modifier = Modifier.alpha(0.5f)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.circle_symbol),
                        contentDescription = "Cirle Symbol",
                        modifier = Modifier.alpha(0.5f)
                    )
                    Text(
                        text = "${surat.jumlahAyat} Ayat",
                        fontFamily = FontFamily(Font(R.font.geologica)),
                        modifier = Modifier.alpha(0.5f))
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = surat.namaSuratArab,
                fontFamily = FontFamily(Font(R.font.lpmq)),
                fontSize = 25.sp,
                style = MaterialTheme.typography.bodyMedium
            )
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

@Preview(showBackground = true)
@Composable
fun QuranScreenPreview(){
    FitrahmindappTheme{
        QuranScreen()
    }
}