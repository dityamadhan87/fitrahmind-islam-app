package com.bignerdranch.fitrahmind_app.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.firestore.PropertyName

@Entity(tableName = "Surat")
data class Surat(
    @PrimaryKey
    @ColumnInfo(name = "id_surat")
    @PropertyName("idSurat")
    val idSurat: Int = 0,
    @ColumnInfo(name = "nama_surat")
    @PropertyName("namaSurat")
    val namaSurat: String = "",
    @ColumnInfo(name = "arti_surat")
    @PropertyName("artiSurat")
    val artiSurat: String = "",
    @ColumnInfo(name = "jumlah_ayat")
    @PropertyName("jumlahAyat")
    val jumlahAyat: Int = 0,
    @ColumnInfo(name = "nama_surat_arab")
    @PropertyName("namaSuratArab")
    val namaSuratArab: String = ""
)