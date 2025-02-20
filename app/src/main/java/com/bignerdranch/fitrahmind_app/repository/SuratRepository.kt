package com.bignerdranch.fitrahmind_app.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.bignerdranch.fitrahmind_app.model.Ayat
import com.bignerdranch.fitrahmind_app.model.Surat
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class SuratRepository {
    private val db = Firebase.firestore
    private val suratCollection = db.collection("surat")

    private val suratList = listOf(
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

    private val listAyat = listOf(
        Ayat(1, 1, "بِسْمِ اللّٰهِ الرَّحْمٰنِ الرَّحِيْمِ", "Bismillāhir-raḥmānir-raḥīm(i)", "Dengan nama Allah Yang Maha Pengasih lagi Maha Penyayang"),
        Ayat(2, 1, "اَلْحَمْدُ لِلّٰهِ رَبِّ الْعٰلَمِيْنَۙ", "Al-ḥamdu lillāhi rabbil-‘ālamīn(a)", "Segala puji bagi Allah, Tuhan semesta alam"),
        Ayat(3, 1, "الرَّحْمٰنِ الرَّحِيْمِۙ", "Ar-raḥmānir-raḥīm(i)", "Yang Maha Pengasih lagi Maha Penyayang"),
        Ayat(4, 1, "مٰلِكِ يَوْمِ الدِّيْنِۗ", "Māliki yaumid-dīn(i)", "Pemilik hari Pembalasan"),
        Ayat(5, 1, "اِيَّاكَ نَعْبُدُ وَاِيَّاكَ نَسْتَعِيْنُۗ", "Iyyāka na‘budu wa iyyāka nasta‘īn(u)", "Hanya kepada Engkaulah kami menyembah dan hanya kepada Engkaulah kami memohon pertolongan"),
        Ayat(6, 1, "اِهْدِنَا الصِّرَاطَ الْمُسْتَقِيْمَۙ", "Ihdinaṣ-ṣirāṭal-mustaqīm(a)", "Bimbinglah kami ke jalan yang lurus"),
        Ayat(7, 1, "صِرَاطَ الَّذِيْنَ اَنْعَمْتَ عَلَيْهِمْ ەۙ غَيْرِ الْمَغْضُوْبِ عَلَيْهِمْ وَلَا الضَّاۤلِّيْنَࣖ", "Ṣirāṭal-lażīna an‘amta ‘alaihim, gairil-magḍūbi ‘alaihim wa laḍ-ḍāllīn(a)", "(yaitu) jalan orang-orang yang telah Engkau beri nikmat, bukan (jalan) mereka yang dimurkai dan bukan (pula jalan) orang-orang yang sesat"),
        Ayat(1, 109, "قُلْ يٰٓاَيُّهَا الْكٰفِرُوْنَۙ", "Qul yā ayyuhal-kāfirūn(a).", "Katakanlah (Nabi Muhammad), \"Wahai orang-orang kafir,"),
        Ayat(2, 109, "لَآ اَعْبُدُ مَا تَعْبُدُوْنَۙ", "Lā a'budu mā ta'budūn(a).", "aku tidak akan menyembah apa yang kamu sembah."),
        Ayat(3, 109, "وَلَآ اَنْتُمْ عٰبِدُوْنَ مَآ اَعْبُدُۚ", "Wa lā antum 'ābidūna mā a'bud(u).", "Kamu juga bukan penyembah apa yang aku sembah."),
        Ayat(4, 109, "وَلَآ اَنَا۠ عَابِدٌ مَّا عَبَدْتُّمْۙ", "Wa lā ana 'ābidum mā 'abattum.", "Aku juga tidak pernah menjadi penyembah apa yang kamu sembah."),
        Ayat(5, 109, "وَلَآ اَنْتُمْ عٰبِدُوْنَ مَآ اَعْبُدُۗ", "Wa lā antum 'ābidūna mā a'bud(u).", "Kamu tidak pernah (pula) menjadi penyembah apa yang aku sembah."),
        Ayat(6, 109, "لَكُمْ دِيْنُكُمْ وَلِيَ دِيْنِࣖ", "Lakum dīnukum wa liya dīn(i).", "Untukmu agamamu dan untukku agamaku.\""),
        Ayat(1, 110, "اِذَا جَاۤءَ نَصْرُ اللّٰهِ وَالْفَتْحُۙ", "Iżā jā'a naṣrullāhi wal-fatḥ(u).", "Apabila telah datang pertolongan Allah dan kemenangan"),
        Ayat(2, 110, "وَرَاَيْتَ النَّاسَ يَدْخُلُوْنَ فِيْ دِيْنِ اللّٰهِ اَفْوَاجًاۙ", "Wa ra'aitan-nāsa yadkhulūna fī dīnillāhi afwājā(n).", "dan engkau melihat manusia berbondong-bondong masuk agama Allah,"),
        Ayat(3, 110, "فَسَبِّحْ بِحَمْدِ رَبِّكَ وَاسْتَغْفِرْهُۗ اِنَّهٗ كَانَ تَوَّابًاࣖ", "Fasabbiḥ biḥamdi rabbika wastagfirh(u), innahū kāna tawwābā(n).", "bertasbihlah dengan memuji Tuhanmu dan mohonlah ampun kepada-Nya. Sesungguhnya Dia Maha Penerima tobat."),
        Ayat(1, 111, "تَبَّتْ يَدَآ اَبِيْ لَهَبٍ وَّتَبَّۗ", "Tabbat yadā abī lahabiw wa tabb(a).", "Binasalah kedua tangan Abu Lahab dan benar-benar binasa dia."),
        Ayat(2, 111, "مَآ اَغْنٰى عَنْهُ مَالُهٗ وَمَا كَسَبَۗ", "Mā agnā 'anhu māluhū wa mā kasab(a).", "Tidaklah berguna baginya hartanya dan apa yang dia usahakan."),
        Ayat(3, 111, "سَيَصْلٰى نَارًا ذَاتَ لَهَبٍۙ", "Sayaṣlā nāran żāta lahab(in).", "Kelak dia akan memasuki api yang bergejolak (neraka),"),
        Ayat(4, 111, "وَّامْرَاَتُهٗ ۗحَمَّالَةَ الْحَطَبِۚ", "Wamra'atuh(ū), ḥammālatal-ḥaṭab(i).", "(begitu pula) istrinya, pembawa kayu bakar (penyebar fitnah)."),
        Ayat(5, 111, "فِيْ جِيْدِهَا حَبْلٌ مِّنْ مَّسَدٍࣖ", "Fī jīdihā ḥablum mim masad(in).", "Di lehernya ada tali dari sabut yang dipintal."),
        Ayat(1, 112, "قُلْ هُوَ اللّٰهُ اَحَدٌۚ", "Qul huwallāhu aḥad(un).", "Katakanlah (Nabi Muhammad), \"Dialah Allah Yang Maha Esa."),
        Ayat(2, 112, "اَللّٰهُ الصَّمَدُۚ", "Allāhuṣ-ṣamad(u).", "Allah tempat meminta segala sesuatu."),
        Ayat(3, 112, "لَمْ يَلِدْ وَلَمْ يُوْلَدْۙ", "Lam yalid wa lam yūlad.", "Dia tidak beranak dan tidak pula diperanakkan"),
        Ayat(4, 112, "وَلَمْ يَكُنْ لَّهٗ كُفُوًا اَحَدٌࣖ", "Wa lam yakul lahū kufuwan aḥad(un).", "serta tidak ada sesuatu pun yang setara dengan-Nya."),
        Ayat(1, 113, "قُلْ اَعُوْذُ بِرَبِّ الْفَلَقِۙ", "Qul a'ūżu birabbil-falaq(i).", "Katakanlah (Nabi Muhammad), \"Aku berlindung kepada Tuhan yang (menjaga) fajar (subuh)"),
        Ayat(2, 113, "مِنْ شَرِّ مَا خَلَقَۙ", "Min syarri mā khalaq(a).", "dari kejahatan (makhluk yang) Dia ciptakan,"),
        Ayat(3, 113, "وَمِنْ شَرِّ غَاسِقٍ اِذَا وَقَبَۙ", "Wa min syarri gāsiqin iżā waqab(a).", "dari kejahatan malam apabila telah gelap gulita,"),
        Ayat(4, 113, "وَمِنْ شَرِّ النَّفّٰثٰتِ فِى الْعُقَدِۙ", "Wa min syarrin-naffāṡāti fil-'uqad(i).", "dari kejahatan perempuan-perempuan (penyihir) yang meniup pada buhul-buhul (talinya),"),
        Ayat(5, 113, "وَمِنْ شَرِّ حَاسِدٍ اِذَا حَسَدَࣖ", "Wa min syarri ḥāsidin iżā ḥasad(a).", "dan dari kejahatan orang yang dengki apabila dia dengki.\""),
        Ayat(1, 114, "قُلْ اَعُوْذُ بِرَبِّ النَّاسِۙ", "Qul a'ūżu birabbin-nās(i).", "Katakanlah (Nabi Muhammad), \"Aku berlindung kepada Tuhan manusia,"),
        Ayat(2, 114, "مَلِكِ النَّاسِۙ", "Malikin-nās(i).", "raja manusia,"),
        Ayat(3, 114, "اِلٰهِ النَّاسِۙ", "Ilāhin-nās(i).", "sembahan manusia"),
        Ayat(4, 114, "مِنْ شَرِّ الْوَسْوَاسِ ەۙ الْخَنَّاسِۖ", "Min syarril-waswāsil-khannās(i).", "dari kejahatan (setan) pembisik yang bersembunyi"),
        Ayat(5, 114, "الَّذِيْ يُوَسْوِسُ فِيْ صُدُوْرِ النَّاسِۙ", "Allażī yuwaswisu fī ṣudūrin-nās(i).", "yang membisikkan (kejahatan) ke dalam dada manusia,"),
        Ayat(6, 114, "مِنَ الْجِنَّةِ وَالنَّاسِࣖ", "Minal jinnati wan-nās(i).", "dari (golongan) jin dan manusia.\""),
    )

    fun uploadSurat() {
        suratList.forEach { surat ->
            suratCollection.document(surat.idSurat.toString()).set(surat)
                .addOnSuccessListener {
                    Log.d(TAG, "Upload surat ${surat.namaSurat} berhasil")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Upload surat ${surat.namaSurat} gagal", e)
                }
        }
    }

    fun uploadAyat() {
        suratList.forEach { surat ->
            // Filter listAyat sesuai idSurat yang sedang di-loop
            val ayatSurat = listAyat.filter { it.idSurat == surat.idSurat }

            ayatSurat.forEach { ayat ->
                suratCollection.document(surat.idSurat.toString()) // Dokumen surat
                    .collection("ayat").document(ayat.idAyat.toString()) // Subkoleksi ayat
                    .set(ayat)
                    .addOnSuccessListener {
                        Log.d(TAG, "Upload ayat berhasil: Surat ${surat.namaSurat}, Ayat ${ayat.idAyat}")
                    }
                    .addOnFailureListener { e ->
                        Log.w(TAG, "Upload ayat gagal: Surat ${surat.namaSurat}, Ayat ${ayat.idAyat}", e)
                    }
            }
        }
    }

    fun getListSurat(
        onSuccess: (List<Surat>) -> Unit,
        onFailure: (Exception) -> Unit
    ){
        suratCollection
            .orderBy("idSurat")
            .get()
            .addOnSuccessListener{ result ->
                val suratList = result.documents.mapNotNull { doc -> doc.toObject(Surat::class.java) }
                onSuccess(suratList)
            }
            .addOnFailureListener{ exception ->
                onFailure(exception)
            }
    }

    fun getAyatBySurat(
        idSurat:String,
        onSuccess: (List<Ayat>) -> Unit,
        onFailure: (Exception) -> Unit
    ){
        suratCollection.document(idSurat)
            .collection("ayat")
            .orderBy("idAyat")
            .get()
            .addOnSuccessListener{ result ->
                val ayatList = result.documents.mapNotNull { doc -> doc.toObject(Ayat::class.java) }
                onSuccess(ayatList)
            }
            .addOnFailureListener{ exception ->
                onFailure(exception)
            }
    }
}