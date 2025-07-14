package com.bignerdranch.fitrahmind_app.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import com.bignerdranch.fitrahmind_app.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.fitrahmind_app.domain.models.Ayat

@Composable
fun QuranDetailsScreen(idSurat: String, viewModel: AyatSuratViewModel = viewModel()){
    LaunchedEffect(idSurat){
        viewModel.fetchAyat(idSurat)
    }
    val ayatList by viewModel.ayatList
    Column(
        modifier = Modifier
            .fillMaxSize()
    ){
        TopNav(
            onBackClick = {},
            onSuratClick = {},
            onInfoClick = {},
            onSettingClick = {}
        )
        TopNavKedua(
            onClick = {}
        )
        LazyColumn {
            items(ayatList) { ayat ->
                ItemAyat(
                    onNotesClick = {
                    },
                    onBookmarkClick = {
                    },
                    onPenNoteClick = {},
                    onOtherClick = {
                    },
                    ayat = ayat
                )
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}

@Composable
fun TopNav(
    onBackClick: () -> Unit,
    onSuratClick: () -> Unit,
    onInfoClick: () -> Unit,
    onSettingClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackClick }) {
            Icon(
                painter = painterResource(id = R.drawable.arrow_back_icon),
                contentDescription = "Back"
            )
        }
        Button(
            onClick = { onSuratClick },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = Color.Black
            )
        ){
            Column(

            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Al-Baqarah",
                        fontFamily = FontFamily(Font(R.font.inria_sans)),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_down_bold_icon),
                        contentDescription = "Dropdown"
                    )
                }
                Text(
                    text = "Sapi Betina",
                    fontFamily = FontFamily(Font(R.font.inria_sans)),
                    fontSize = 16.sp
                )
            }
        }
        Row {
            IconButton(onClick = { onInfoClick }) {
                Icon(
                    painter = painterResource(id = R.drawable.info_icon),
                    contentDescription = "Info"
                )
            }
            IconButton(onClick = { onSettingClick }) {
                Icon(
                    painter = painterResource(id = R.drawable.list_setting_icon),
                    contentDescription = "Settings"
                )
            }
        }
    }
}

@Composable
fun TopNavKedua(
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(20.dp),
            onClick = { onClick },
        ) {
            Row {
                Text(
                    text = "Ayat 2",
                    color = Color.Black
                )
                Icon(
                    painter = painterResource(R.drawable.arrow_down_icon),
                    contentDescription = "Dropdown",
                    tint = Color.Black
                )
            }
        }
        Text(
            text = "Juz 18 - Halaman 315"
        )
    }
}

@Composable
fun ItemAyat(
    ayat: Ayat,
    onNotesClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    onPenNoteClick: () -> Unit,
    onOtherClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = ayat.teksArab,
            fontFamily = FontFamily(Font(R.font.lpmq)),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.End),
            textAlign = TextAlign.End,
            lineHeight = 50.sp
        )
        Column {
            Text(
                text = ayat.abjadArab,
                fontFamily = FontFamily(Font(R.font.inter)),
                color = Color.Black.copy(alpha = 0.6f)
            )
            Text(
                text = ayat.artiIndonesia,
                fontFamily = FontFamily(Font(R.font.inter)),
                color = Color.Black
            )
        }
        Row(
            modifier = Modifier.align(Alignment.End)
        ) {
            IconButton(onClick = onNotesClick){
                Icon(
                    painter = painterResource(id = R.drawable.notes_icon),
                    contentDescription = ""
                )
            }
            IconButton(onClick = onBookmarkClick){
                Icon(
                    painter = painterResource(id = R.drawable.bookmark_add_icon),
                    contentDescription = ""
                )
            }
            IconButton(onClick = onPenNoteClick){
                Icon(
                    painter = painterResource(id = R.drawable.pen_note_icon),
                    contentDescription = ""
                )
            }
            IconButton(onClick = onOtherClick){
                Icon(
                    painter = painterResource(id = R.drawable.other_icon),
                    contentDescription = ""
                )
            }
        }
    }
    HorizontalDivider(
        thickness = 1.dp,
        color = Color.Black,
    )
}