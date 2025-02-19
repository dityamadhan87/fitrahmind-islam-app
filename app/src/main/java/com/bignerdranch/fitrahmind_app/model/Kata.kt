package com.bignerdranch.fitrahmind_app.model

data class Kata(
    val idKata: Int = 0,
    val idAyat: Int = 0,
    val idSurat: Int = 0,
    val teksArab: String = "",
    val abjadArab: String = "",
    val artiIndonesia: String = ""
)