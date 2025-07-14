package com.bignerdranch.fitrahmind_app.data.local

import androidx.room.Query
import com.bignerdranch.fitrahmind_app.domain.models.Surat

interface QuranDao {
    @Query("SELECT * FROM Surat")
    fun getAllSurat(): List<Surat>
}