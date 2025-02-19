package com.bignerdranch.fitrahmind_app.model

data class Ayat(
    val idAyat: Int = 0,
    val idSurat: Int = 0,
    val teksArab: String = "",
    val abjadArab: String = "",
    val artiIndonesia: String = ""
)