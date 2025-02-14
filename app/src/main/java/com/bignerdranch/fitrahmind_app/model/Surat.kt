package com.bignerdranch.fitrahmind_app.model

import com.google.firebase.firestore.PropertyName

data class Surat(
    @PropertyName("idSurat") val idSurat: Int = 0,
    @PropertyName("namaSurat") val namaSurat: String = "",
    @PropertyName("artiSurat") val artiSurat: String = "",
    @PropertyName("jumlahAyat") val jumlahAyat: Int = 0,
    @PropertyName("namaSuratArab") val namaSuratArab: String = ""
)