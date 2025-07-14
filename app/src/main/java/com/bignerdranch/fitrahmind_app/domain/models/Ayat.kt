package com.bignerdranch.fitrahmind_app.domain.models

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "Ayat",
    primaryKeys = ["idAyat", "idSurat"],
    foreignKeys = [ForeignKey(
        entity = Surat::class,
        parentColumns = ["idSurat"],
        childColumns = ["idSurat"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Ayat(
    val idAyat: Int = 0,
    val idSurat: Int = 0,
    val idJuz: Int = 0,
    val teksArab: String = "",
    val abjadArab: String = "",
    val artiIndonesia: String = ""
)