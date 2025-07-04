package com.bignerdranch.fitrahmind_app.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bignerdranch.fitrahmind_app.model.Ayat
import com.bignerdranch.fitrahmind_app.repository.SuratRepository

class AyatSuratViewModel (private val repository: SuratRepository = SuratRepository()): ViewModel(){
    private val _ayatList = mutableStateOf(emptyList<Ayat>())
    val ayatList: State<List<Ayat>> = _ayatList

    fun fetchAyat(idSurat: String){
        repository.getAyatBySurat(
            idSurat = idSurat,
            onSuccess = {_ayatList.value = it},
            onFailure = { Log.e("Firestore", "Error fetching ayat", it) }
        )
    }
}