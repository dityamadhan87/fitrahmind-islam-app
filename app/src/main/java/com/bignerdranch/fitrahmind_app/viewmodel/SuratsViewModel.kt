package com.bignerdranch.fitrahmind_app.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bignerdranch.fitrahmind_app.model.Surat
import com.bignerdranch.fitrahmind_app.repository.SuratRepository

class SuratsViewModel(private val repository: SuratRepository = SuratRepository()) : ViewModel(){
    private val _suratList = mutableStateOf(emptyList<Surat>())
    val suratList: State<List<Surat>> = _suratList

    fun fetchSurat() {
        repository.getListSurat(
            onSuccess = {_suratList.value = it},
            onFailure = { Log.e("Firestore", "Error fetching surat", it) }
        )
    }
}