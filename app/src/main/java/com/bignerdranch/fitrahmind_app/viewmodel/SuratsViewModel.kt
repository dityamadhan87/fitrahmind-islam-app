package com.bignerdranch.fitrahmind_app.viewmodel

import androidx.lifecycle.ViewModel
import com.bignerdranch.fitrahmind_app.model.Surat
import com.bignerdranch.fitrahmind_app.repository.SuratRepository
import kotlinx.coroutines.flow.StateFlow

class SuratsViewModel(private val repository: SuratRepository = SuratRepository()) : ViewModel(){
    val surats: StateFlow<List<Surat>> = repository.surats

    init {
        fetchSurat()
    }

    private fun fetchSurat() {
        repository.getListSurat()
    }
}