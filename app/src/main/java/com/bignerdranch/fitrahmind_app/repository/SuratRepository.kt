package com.bignerdranch.fitrahmind_app.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.bignerdranch.fitrahmind_app.model.Surat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SuratRepository {
    private val db = Firebase.firestore
    private val suratCollection = db.collection("surat")
    private val _surats = MutableStateFlow<List<Surat>>(emptyList())
    val surats : StateFlow<List<Surat>> = _surats

    fun uploadSuratData() {
        val suratList = listOf(
            Surat(1, "Al-Fatihah", "Pembukaan", 7, "الفاتحة"),
            Surat(2, "Al-Baqarah", "Sapi Betina", 286, "البقرة"),
            Surat(3, "Ali 'Imran", "Keluarga Imran", 200, "آل عمران"),
            Surat(4, "An-Nisa'", "Wanita", 176, "النساء"),
            Surat(5, "Al-Ma'idah", "Hidangan", 120, "المائدة"),
            Surat(6, "Al-An'am", "Hewan Ternak", 165, "الأنعام"),
            Surat(7, "Al-A'raf", "Tempat yang Tertinggi", 206, "الأعراف"),
            Surat(8, "Al-Anfal", "Rampasan Perang", 75, "الأنفال"),
            Surat(9, "At-Tawbah", "Pengampunan", 129, "التوبة"),
            Surat(10, "Yunus", "Nabi Yunus", 109, "يونس"),
            Surat(11, "Hud", "Nabi Hud", 123, "هود"),
            Surat(12, "Yusuf", "Nabi Yusuf", 111, "يوسف"),
            Surat(13, "Ar-Ra'd", "Guruh", 43, "الرعد"),
            Surat(14, "Ibrahim", "Nabi Ibrahim", 52, "إبراهيم"),
            Surat(15, "Al-Hijr", "Gunung Al-Hijr", 99, "الحجر"),
            Surat(16, "An-Nahl", "Lebah", 128, "النحل"),
            Surat(17, "Al-Isra'", "Perjalanan Malam", 111, "الإسراء"),
            Surat(18, "Al-Kahf", "Goa", 110, "الكهف"),
            Surat(19, "Maryam", "Maryam", 98, "مريم"),
            Surat(20, "Taha", "Taha", 135, "طه"),
            Surat(21, "Al-Anbiya'", "Para Nabi", 112, "الأنبياء"),
            Surat(22, "Al-Hajj", "Haji", 78, "الحج"),
            Surat(23, "Al-Mu’minun", "Orang-Orang Mukmin", 118, "المؤمنون"),
            Surat(24, "An-Nur", "Cahaya", 64, "النور"),
            Surat(25, "Al-Furqan", "Pembeda", 77, "الفرقان"),
            Surat(26, "Asy-Syu'ara'", "Penyair", 227, "الشعراء"),
            Surat(27, "An-Naml", "Semut", 93, "النمل"),
            Surat(28, "Al-Qasas", "Kisah-Kisah", 88, "القصص"),
            Surat(29, "Al-'Ankabut", "Laba-Laba", 69, "العنكبوت"),
            Surat(30, "Ar-Rum", "Bangsa Romawi", 60, "الروم"),
            Surat(31, "Luqman", "Luqman", 34, "لقمان"),
            Surat(32, "As-Sajdah", "Sujud", 30, "السجدة"),
            Surat(33, "Al-Ahzab", "Golongan yang Bersekutu", 73, "الأحزاب"),
            Surat(34, "Saba'", "Kaum Saba'", 54, "سبأ"),
            Surat(35, "Fatir", "Pencipta", 45, "فاطر"),
            Surat(36, "Ya-Sin", "Ya Sin", 83, "يس"),
            Surat(37, "As-Saffat", "Barisan", 182, "الصافات"),
            Surat(38, "Sad", "Sad", 88, "ص"),
            Surat(39, "Az-Zumar", "Rombongan", 75, "الزمر"),
            Surat(40, "Ghafir", "Yang Maha Pengampun", 85, "غافر"),
            Surat(41, "Fussilat", "Yang Dijelaskan", 54, "فصلت"),
            Surat(42, "Asy-Syura", "Musyawarah", 53, "الشورى"),
            Surat(43, "Az-Zukhruf", "Perhiasan", 89, "الزخرف"),
            Surat(44, "Ad-Dukhan", "Kabut", 59, "الدخان"),
            Surat(45, "Al-Jasiyah", "Berlutut", 37, "الجاثية"),
            Surat(46, "Al-Ahqaf", "Bukit Pasir", 35, "الأحقاف"),
            Surat(47, "Muhammad", "Nabi Muhammad", 38, "محمد"),
            Surat(48, "Al-Fath", "Kemenangan", 29, "الفتح"),
            Surat(49, "Al-Hujurat", "Kamar-Kamar", 18, "الحجرات"),
            Surat(50, "Qaf", "Qaf", 45, "ق"),
            Surat(51, "Az-Zariyat", "Angin yang Menerbangkan", 60, "الذاريات"),
            Surat(52, "At-Tur", "Bukit", 49, "الطور"),
            Surat(53, "An-Najm", "Bintang", 62, "النجم"),
            Surat(54, "Al-Qamar", "Bulan", 55, "القمر"),
            Surat(55, "Ar-Rahman", "Yang Maha Pemurah", 78, "الرحمن"),
            Surat(56, "Al-Waqi'ah", "Hari Kiamat", 96, "الواقعة"),
            Surat(57, "Al-Hadid", "Besi", 29, "الحديد"),
            Surat(58, "Al-Mujadilah", "Wanita yang Menggugat", 22, "المجادلة"),
            Surat(59, "Al-Hasyr", "Pengusiran", 24, "الحشر"),
            Surat(60, "Al-Mumtahanah", "Wanita yang Diuji", 13, "الممتحنة"),
            Surat(61, "As-Saff", "Barisan", 14, "الصف"),
            Surat(62, "Al-Jumu'ah", "Hari Jumat", 11, "الجمعة"),
            Surat(63, "Al-Munafiqun", "Orang-Orang Munafik", 11, "المنافقون"),
            Surat(64, "At-Taghabun", "Hari Ditampakkan Kesalahan", 18, "التغابن"),
            Surat(65, "At-Talaq", "Talak", 12, "الطلاق"),
            Surat(66, "At-Tahrim", "Mengharamkan", 12, "التحريم"),
            Surat(67, "Al-Mulk", "Kerajaan", 30, "الملك"),
            Surat(68, "Al-Qalam", "Pena", 52, "القلم"),
            Surat(69, "Al-Haqqah", "Hari Kiamat", 52, "الحاقة"),
            Surat(70, "Al-Ma'arij", "Tempat Naik", 44, "المعارج"),
            Surat(71, "Nuh", "Nabi Nuh", 28, "نوح"),
            Surat(72, "Al-Jinn", "Jin", 28, "الجن"),
            Surat(73, "Al-Muzzammil", "Orang yang Berselimut", 20, "المزمل"),
            Surat(74, "Al-Muddaththir", "Orang yang Berselimut", 56, "المدثر"),
            Surat(75, "Al-Qiyamah", "Hari Kiamat", 40, "القيامة"),
            Surat(76, "Al-Insan", "Manusia", 31, "الإنسان"),
            Surat(77, "Al-Mursalat", "Malaikat yang Diutus", 50, "المرسلات"),
            Surat(78, "An-Naba'", "Berita Besar", 40, "النبأ"),
            Surat(79, "An-Nazi'at", "Malaikat yang Mencabut", 46, "النازعات"),
            Surat(80, "Abasa", "Ia Bermuka Masam", 42, "عبس"),
            Surat(81, "At-Takwir", "Penggulungan", 29, "التكوير"),
            Surat(82, "Al-Infitar", "Terbelah", 19, "الإنفطار"),
            Surat(83, "Al-Mutaffifin", "Orang-Orang yang Curang", 36, "المطففين"),
            Surat(84, "Al-Insyiqaq", "Terbelah", 25, "الإنشقاق"),
            Surat(85, "Al-Buruj", "Gugusan Bintang", 22, "البروج"),
            Surat(86, "At-Tariq", "Yang Datang di Malam Hari", 17, "الطارق"),
            Surat(87, "Al-A'la", "Yang Paling Tinggi", 19, "الأعلى"),
            Surat(88, "Al-Ghasyiyah", "Hari Pembalasan", 26, "الغاشية"),
            Surat(89, "Al-Fajr", "Fajar", 30, "الفجر"),
            Surat(90, "Al-Balad", "Negeri", 20, "البلد"),
            Surat(91, "Asy-Syams", "Matahari", 15, "الشمس"),
            Surat(92, "Al-Lail", "Malam", 21, "الليل"),
            Surat(93, "Ad-Duha", "Waktu Dhuha", 11, "الضحى"),
            Surat(94, "Asy-Syarh", "Melapangkan", 8, "الشرح"),
            Surat(95, "At-Tin", "Buah Tin", 8, "التين"),
            Surat(96, "Al-'Alaq", "Segumpal Darah", 19, "العلق"),
            Surat(97, "Al-Qadr", "Kemuliaan", 5, "القدر"),
            Surat(98, "Al-Bayyinah", "Pembuktian", 8, "البينة"),
            Surat(99, "Az-Zalzalah", "Goncangan", 8, "الزلزلة"),
            Surat(100, "Al-'Adiyat", "Kuda Perang yang Berlari Kencang", 11, "العاديات"),
            Surat(101, "Al-Qari'ah", "Hari Kiamat", 11, "القارعة"),
            Surat(102, "At-Takatsur", "Bermegah-Megahan", 8, "التكاثر"),
            Surat(103, "Al-'Asr", "Masa", 3, "العصر"),
            Surat(104, "Al-Humazah", "Pengumpat", 9, "الهمزة"),
            Surat(105, "Al-Fil", "Gajah", 5, "الفيل"),
            Surat(106, "Quraisy", "Suku Quraisy", 4, "قريش"),
            Surat(107, "Al-Ma'un", "Barang yang Berguna", 7, "الماعون"),
            Surat(108, "Al-Kautsar", "Nikmat yang Berlimpah", 3, "الكوثر"),
            Surat(109, "Al-Kafirun", "Orang-Orang Kafir", 6, "الكافرون"),
            Surat(110, "An-Nasr", "Pertolongan", 3, "النصر"),
            Surat(111, "Al-Lahab", "Gejolak Api", 5, "اللهب"),
            Surat(112, "Al-Ikhlas", "Kemurnian", 4, "الإخلاص"),
            Surat(113, "Al-Falaq", "Waktu Subuh", 5, "الفلق"),
            Surat(114, "An-Nas", "Manusia", 6, "الناس")
        )

        suratList.forEach { surat ->
            suratCollection.document(surat.idSurat.toString()).set(surat)
                .addOnSuccessListener {
                    Log.d(TAG, "DocumentSnapshot successfully written!")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error writing document", e)
                }
        }
    }

    fun getListSurat(){
        suratCollection
            .orderBy("idSurat")
            .get()
            .addOnSuccessListener{ result ->
                val list = result.documents.mapNotNull { it.toObject(Surat::class.java) }
                _surats.value = list
            }
            .addOnFailureListener{ exception ->
                Log.e("FirestoreError", "Error fetching restaurants: ", exception)
            }
    }
}