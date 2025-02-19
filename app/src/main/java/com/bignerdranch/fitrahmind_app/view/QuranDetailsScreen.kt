package com.bignerdranch.fitrahmind_app.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bignerdranch.fitrahmind_app.viewmodel.AyatSuratViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.fitrahmind_app.model.Ayat

@Composable
fun QuranDetailsScreen(idSurat: String, viewModel: AyatSuratViewModel = viewModel()){
    LaunchedEffect(idSurat){
        viewModel.fetchAyat(idSurat)
    }

    val ayatList by viewModel.ayatList

    LazyColumn {
        items(ayatList) { ayat ->
            AyatItem(ayat)
        }
    }
}

@Composable
fun AyatItem(ayat: Ayat) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = ayat.teksArab, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = ayat.abjadArab, fontSize = 18.sp, color = Color.Gray)
        Text(text = ayat.artiIndonesia, fontSize = 16.sp)
    }
}