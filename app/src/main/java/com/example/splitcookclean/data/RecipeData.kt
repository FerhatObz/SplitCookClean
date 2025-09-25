package com.example.splitcookclean.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.Blender
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.RamenDining
import androidx.compose.material.icons.filled.SoupKitchen
import androidx.compose.material.icons.filled.Water
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

enum class ChefRole(val displayName: String) {
    Female("Kadın Şef"),
    Male("Erkek Şef")
}

data class Recipe(
    val name: String,
    val calories: Int,
    val ingredients: List<String>,
    val femaleSteps: List<String>,
    val maleSteps: List<String>,
    val inspiration: String,
    val icon: ImageVector
)

data class RecipeCategory(
    val id: String,
    val displayName: String,
    val icon: ImageVector,
    val accentColor: Color,
    val recipes: List<Recipe>
)

object RecipeRepository {
    val categories: List<RecipeCategory> = listOf(
        RecipeCategory(
            id = "pasta",
            displayName = "Makarna",
            icon = Icons.Filled.RamenDining,
            accentColor = Color(0xFFFAE8E0),
            recipes = listOf(
                recipe(
                    baseName = "Fırında Beşamel Makarna",
                    romanticAlias = "Sıcacık Sarılma",
                    calories = 690,
                    ingredients = listOf(
                        "400 g tam buğday penne",
                        "45 g tereyağı",
                        "3 yemek kaşığı un",
                        "4 su bardağı tam yağlı süt",
                        "1/4 muskat rendesi",
                        "150 g rendelenmiş eski kaşar",
                        "1 su bardağı haşlanmış bezelye",
                        "1 adet havuç, minik küpler",
                        "Taze çekilmiş karabiber"
                    ),
                    inspiration = "Arda Türkmen'in 'Arda ile Omuz Omuza' programındaki fırın makarna tekniğinden esinlenildi.",
                    icon = Icons.Filled.RamenDining,
                    steps = arrayOf(
                        "Tereyağını ağır tabanlı tencerede eritip unu ekleyerek 2 dakika kokusu çıkana dek kavur." to "Makarnayı 3 litre tuzlu suda al dente haşla, 1 su bardağı nişastalı sudan ayır.",
                        "Sütü üç partide ekleyip sürekli çırparak parlak bir beşamel elde et; muskat ve karabiberle tatlandır." to "Haşlanan makarnayı süzüp geniş bir kaseye al, ayrılan makarna suyuyla nemlendir.",
                        "Bezelye, havuç ve kaşarın yarısını sosla buluşturup ipeksi bir karışım hazırla." to "Makarnayı sos karışımıyla harmanlayıp tereyağlanmış fırın kabına eşit katmanla yay.",
                        "Üzeri için kalan kaşarı serpip 5 dakika dinlendirerek sosun koyulaşmasını bekle." to "190°C fanlı fırında 18 dakika pişir, servis öncesi 5 dakika dinlendirip porsiyonla."
                    )
                ),
                recipe(
                    baseName = "Limonlu Karidesli Linguine",
                    romanticAlias = "Deniz Öpücüğü",
                    calories = 540,
                    ingredients = listOf(
                        "320 g linguine",
                        "280 g temizlenmiş iri karides",
                        "2 yemek kaşığı sızma zeytinyağı",
                        "2 diş sarımsak, ince dilim",
                        "1 limonun kabuğu ve suyu",
                        "1/2 çay kaşığı acı pul biber",
                        "1/2 su bardağı beyaz şarap",
                        "30 g tuzsuz tereyağı",
                        "1 avuç roka yaprağı"
                    ),
                    inspiration = "Jamie Oliver'ın '15 Minute Meals' kitabındaki limonlu karides tekniğinden uyarlanmıştır.",
                    icon = Icons.Filled.RamenDining,
                    steps = arrayOf(
                        "Sarımsak dilimlerini ve limon kabuğu rendesini hazırla; rokayı yıka ve iyice kurula." to "Linguine'yi al dente haşla, 1 kepçe haşlama suyunu ayırıp makarnayı süz.",
                        "Karidesleri kağıt havluda kurulayıp pul biber ve deniz tuzuyla harmanla." to "Geniş tavada zeytinyağını ısıtıp karidesleri 2 dakika yüksek ateşte çevir.",
                        "Sarımsağı ekleyip 30 saniye kokusunu salmasını sağla; limon suyunu ve şarabı ilave et." to "Tavayı sallayarak sosu kaynat, tereyağı ekleyip emülsifiye olana dek karıştır.",
                        "Ayırdığın haşlama suyunun yarısıyla sosu parlatarak karidesleri dinlenmeye al." to "Makarnayı tavaya ekleyip sosla harmanla, kalan suyu ayarlayarak parlak kıvam ver ve rokayla servis tabağını hazırla."
                    )
                ),
                recipe(
                    baseName = "Sebzeli Penne Primavera",
                    romanticAlias = "İlkbahar Flörtü",
                    calories = 480,
                    ingredients = listOf(
                        "340 g penne rigate",
                        "1 adet kabak, jülyen",
                        "1 sarı dolmalık biber, jülyen",
                        "1 kırmızı kapya biber, jülyen",
                        "200 g cherry domates",
                        "2 yemek kaşığı sızma zeytinyağı",
                        "1 çay kaşığı limon kabuğu rendesi",
                        "4 dal taze fesleğen",
                        "20 g rendelenmiş parmesan"
                    ),
                    inspiration = "Yotam Ottolenghi'nin 'Plenty' kitabındaki sebzeli primavera yaklaşımından ilham alındı.",
                    icon = Icons.Filled.RamenDining,
                    steps = arrayOf(
                        "Kabak ve biberleri ince şeritler halinde doğra; domatesleri ikiye böl." to "Penne'yi bol tuzlu suda al dente haşla, 1 kepçe suyunu ayır.",
                        "Sebzeleri zeytinyağı, tuz ve limon kabuğuyla harmanlayıp 10 dakika marine et." to "Döküm tavayı kızdırıp sebzeleri 4 dakika yüksek ateşte sotele.",
                        "Marine suyunu tencereye alıp kısık ateşte hafifçe kaynat." to "Haşlanmış penneyi tavaya ekleyip ayrılan su ile parlak sos oluştur.",
                        "Fesleğen yapraklarını elinle koparıp karışıma ekle." to "Parmesanı yağmur gibi serpip tabakları hazırlarken makarnayı maşa ile katmanla."
                    )
                ),
                recipe(
                    baseName = "Kremalı Mantarlı Tagliatelle",
                    romanticAlias = "Orman Randevusu",
                    calories = 560,
                    ingredients = listOf(
                        "300 g taze tagliatelle",
                        "250 g kestane mantarı, dilimlenmiş",
                        "80 g shiitake mantarı",
                        "1 küçük arpacık soğan, ince doğranmış",
                        "120 ml krema",
                        "1 diş sarımsak, ezilmiş",
                        "1 yemek kaşığı zeytinyağı",
                        "30 g tereyağı",
                        "Taze kekik yaprakları"
                    ),
                    inspiration = "Massimo Bottura'nın kremalı mantar denge tekniğinden esinlenildi.",
                    icon = Icons.Filled.RamenDining,
                    steps = arrayOf(
                        "Mantarları nemli bezle temizleyip eşit dilimler halinde hazırla." to "Büyük bir tencerede tagliatelle'yi 2 dakika kısa haşla, 1 kepçe suyu ayır.",
                        "Arpacık soğanını zeytinyağında 2 dakika şeffaflaştır; sarımsağı ekleyip kokusunu sal." to "Mantarları yüksek ateşte 3 dakika karamelize et, tereyağını ekle.",
                        "Kremayı ve kekik yapraklarını ekleyip sosu kısık ateşte yoğunlaştır." to "Haşlanmış makarnayı sosla birleştirip ayrılan suyla ipeksi kıvam yakala.",
                        "Tatlandırmak için deniz tuzu ve taze karabiber serpiştir." to "Tavayı ocaktan alıp 1 dakika dinlendirdikten sonra tabaklara spiral formunda yerleştir."
                    )
                ),
                recipe(
                    baseName = "Ispanaklı Ricotta Ravioli",
                    romanticAlias = "Yeşil Fısıltı",
                    calories = 520,
                    ingredients = listOf(
                        "20 adet taze ravioli yaprağı",
                        "200 g ricotta peyniri",
                        "150 g ıspanak, hafifçe sotelenmiş",
                        "40 g parmesan",
                        "1 adet küçük muskat rendesi",
                        "40 g tereyağı",
                        "6 yaprak adaçayı",
                        "1 diş sarımsak",
                        "Deniz tuzu"
                    ),
                    inspiration = "Luca Manfé'nin ravioli dolgu dengesi anlatımından faydalanıldı.",
                    icon = Icons.Filled.RamenDining,
                    steps = arrayOf(
                        "Sotelenmiş ıspanağı ince kıy; ricotta ve parmesanla karıştırıp muskatla tatlandır." to "Ravioli yapraklarını temiz yüzeye serip kenarlara yumurta akı sür.",
                        "Dolgu karışımını 20 eşit parçaya bölüp yaprakların merkezine yerleştir." to "İkinci yaprağı kapatıp kenarlarını parmaklarınla bastırarak hava çıkışını sağla.",
                        "Sarımsağı tereyağında hafifçe çevirip adaçayı yapraklarını ekle." to "Büyük bir tencerede raviolileri 3 dakika haşla, delikli kepçeyle sos tavasına aktar.",
                        "Haşlama suyundan 2 yemek kaşığı ekleyip sosu emülsifiye et." to "Raviolileri sosla nazikçe çevirip tabaklarda adaçayı yapraklarıyla süsle."
                    )
                ),
                recipe(
                    baseName = "Domates Konfit Bucatini",
                    romanticAlias = "Akşam Kızıllığı",
                    calories = 510,
                    ingredients = listOf(
                        "320 g bucatini",
                        "400 g cherry domates",
                        "4 diş sarımsak, bütün",
                        "60 ml sızma zeytinyağı",
                        "1 çay kaşığı balzamik sirke",
                        "5 dal taze kekik",
                        "1/2 çay kaşığı kırmızı pul biber",
                        "Deniz tuzu",
                        "40 g pecorino romano"
                    ),
                    inspiration = "Samin Nosrat'ın 'Salt Fat Acid Heat' yaklaşımındaki konfit domates tekniğinden uyarlanmıştır.",
                    icon = Icons.Filled.RamenDining,
                    steps = arrayOf(
                        "Domatesleri ikiye böl; sarımsakları hafifçe ez." to "Fırını 140°C'ye ısıtıp domatesleri zeytinyağı ve baharatla konfit et, 45 dakika pişir.",
                        "Konfitten çıkan aromatik yağı küçük bir kâsede toparla." to "Bucatini'yi al dente haşla, 1 kepçe suyunu ayır.",
                        "Balzamik sirkeyi konfit domateslere ekleyip hafifçe karıştır." to "Makarnayı tavada konfit yağla buluştur, ayrılan suyu ekleyerek sosu bağla.",
                        "Kekik yapraklarını saplarından sıyırıp karışıma dahil et." to "Domatesleri makarnaya katıp tavanın ateşini kapat, pecorino ile servis hazırla."
                    )
                ),
                recipe(
                    baseName = "Cevizli Pesto Farfalle",
                    romanticAlias = "Fısıldayan Kanatlar",
                    calories = 530,
                    ingredients = listOf(
                        "320 g farfalle",
                        "60 g ceviz içi",
                        "40 g fesleğen yaprağı",
                        "30 g roka",
                        "50 g parmesan",
                        "1 diş sarımsak",
                        "80 ml zeytinyağı",
                        "1/2 limonun suyu",
                        "Tuz ve karabiber"
                    ),
                    inspiration = "Gennaro Contaldo'nun pesto dengeleme tekniklerinden ilham alındı.",
                    icon = Icons.Filled.RamenDining,
                    steps = arrayOf(
                        "Cevizleri tavada 3 dakika kavurup soğumaya bırak." to "Farfalle'yi tuzlu suda al dente haşla, 1 kepçe suyunu ayır.",
                        "Fesleğen, roka, sarımsak ve cevizi mutfak robotunda çek." to "Zeytinyağını ince akışla ekleyip pürüzsüz pesto elde et.",
                        "Parmesanı ve limon suyunu pestoya katıp tuz-karabiberle ayarla." to "Makarnayı süzüp geniş kaseye al, pesto ve haşlama suyuyla sosa bağla.",
                        "Servis için kaseleri hazırlayıp üzerine ekstra fesleğen yaprakları serp." to "Makarnayı tabaklara böl, kalan pesto damlalarını gezdirip sıcak servis et."
                    )
                ),
                recipe(
                    baseName = "Sarımsaklı Karidesli Spagetti",
                    romanticAlias = "Gece Parıltısı",
                    calories = 550,
                    ingredients = listOf(
                        "320 g tam buğday spagetti",
                        "260 g jumbo karides",
                        "4 diş sarımsak, ezilmiş",
                        "1 yemek kaşığı tereyağı",
                        "2 yemek kaşığı zeytinyağı",
                        "1/2 çay bardağı beyaz şarap",
                        "1/2 çay kaşığı kırmızı pul biber",
                        "1 limonun suyu",
                        "2 dal maydanoz"
                    ),
                    inspiration = "José Andrés'in hızlı karides soteleri üzerine kurduğu teknikten esinlenildi.",
                    icon = Icons.Filled.RamenDining,
                    steps = arrayOf(
                        "Karidesleri temizleyip sırt çizgisini çıkar, kâğıt havluyla kurula." to "Spagettiyi al dente haşla ve 1 kepçe suyunu ayır.",
                        "Sarımsağı ince dilimle; maydanozu kıy." to "Geniş tavada zeytinyağını ısıtıp karidesleri 1 dakika mühürle.",
                        "Sarımsak ve pul biberi ekleyip kokusunu açığa çıkar." to "Tereyağı ve beyaz şarabı ekleyip 2 dakika kaynat, limon suyu sık.",
                        "Ayırdığın suyun yarısıyla sosu emülsifiye et." to "Spagettiyi tavada çevirip kalan suyu ayarla, maydanozla bitirip tabakla."
                    )
                ),
                recipe(
                    baseName = "Trüflü Pappardelle",
                    romanticAlias = "Şehir Işıkları",
                    calories = 600,
                    ingredients = listOf(
                        "280 g taze pappardelle",
                        "40 g tereyağı",
                        "60 ml krema",
                        "20 g taze rendelenmiş parmesan",
                        "1 tatlı kaşığı trüf yağı",
                        "1 adet küçük kara trüf mantarı",
                        "1 diş sarımsak",
                        "Taze çekilmiş karabiber",
                        "Deniz tuzu"
                    ),
                    inspiration = "Gordon Ramsay'in pappardelle sunumundaki sade-lüks dengesi referans alındı.",
                    icon = Icons.Filled.RamenDining,
                    steps = arrayOf(
                        "Sarımsağı bütün halde hafifçe ez; trüfü ince tıraşlar halinde hazırla." to "Pappardelle'yi tuzlu suda 2 dakika kısa haşla, 1 kepçe suyunu ayır.",
                        "Tereyağını tavada eritirken sarımsağı aromalandırması için ekle." to "Kremayı ve parmesanını ekleyip hafifçe koyulaştır.",
                        "Tavayı ocaktan alıp trüf yağını damlat, tuz ve karabiberle tatlandır." to "Makarnayı sosla birleştirip ayrılan suyla kıvamı ayarla.",
                        "Sarımsağı tavadan çıkarıp trüf dilimlerini sosun üzerine serp." to "Makarnayı tabaklara spiralleyip taze trüf tıraşlarını son dokunuş olarak ekle."
                    )
                ),
                recipe(
                    baseName = "Kabak Çiçekli Orzo",
                    romanticAlias = "Gölgede Buluşma",
                    calories = 470,
                    ingredients = listOf(
                        "300 g orzo makarna",
                        "6 adet kabak çiçeği",
                        "1 küçük soğan, minik küp",
                        "1 diş sarımsak",
                        "2 yemek kaşığı zeytinyağı",
                        "400 ml sebze suyu",
                        "1 limon kabuğu rendesi",
                        "40 g tulum peyniri",
                        "Taze nane yaprakları"
                    ),
                    inspiration = "Şef Maksut Aşkar'ın kabak çiçekli orzo sunumundan esinlenildi.",
                    icon = Icons.Filled.RamenDining,
                    steps = arrayOf(
                        "Kabak çiçeklerini saplarından ayırıp iç kısımlarını temizle." to "Orzoyu 1 yemek kaşığı zeytinyağı ile hafifçe kavur.",
                        "Soğan ve sarımsağı zeytinyağında şeffaflaştır." to "Sebze suyunu 3 partide ekleyerek pilav gibi pişir.",
                        "Kabak çiçeklerini ince şerit yap; limon kabuğunu rendele." to "Orzo suyunu çekince çiçekleri ekleyip 2 dakika karıştır.",
                        "Nane yapraklarını elle koparıp tulum peyniriyle harmanla." to "Ocaktan alıp 2 dakika dinlendir, sonra tabaklara yayıp peynir serpiştir."
                    )
                )
            )
        ),
        RecipeCategory(
            id = "chicken",
            displayName = "Tavuk",
            icon = Icons.Filled.LocalDining,
            accentColor = Color(0xFFE8F5E9),
            recipes = listOf(
                recipe(
                    baseName = "Narenciyeli Fırın Tavuk Göğsü",
                    romanticAlias = "Güneşli Sarılma",
                    calories = 430,
                    ingredients = listOf(
                        "4 adet tavuk göğsü",
                        "1 portakalın suyu ve kabuğu",
                        "1 limonun suyu",
                        "2 yemek kaşığı zeytinyağı",
                        "2 dal taze biberiye",
                        "2 diş sarımsak",
                        "1 yemek kaşığı bal",
                        "1 çay kaşığı öğütülmüş kişniş",
                        "Deniz tuzu ve karabiber"
                    ),
                    inspiration = "Donna Hay'in narenciyeli tavuk pişirme tekniğinden uyarlanmıştır.",
                    icon = Icons.Filled.LocalDining,
                    steps = arrayOf(
                        "Portakal ve limon kabuğunu rendele, sularını sık." to "Fırını 200°C'ye ısıtıp döküm tavayı ısıt.",
                        "Zeytinyağı, bal, kişniş ve rendelenmiş kabukla marine sosunu çırp." to "Tavuk göğüslerini kağıt havluyla kurulayıp tuz-karabiberle ov.",
                        "Marine sosuna sarımsak ve ince kıyılmış biberiyeyi ekle." to "Tavukları her iki yüzü 2 dakika mühürleyip fırına ver.",
                        "Kalan marinadı tavaya döküp 5 dakika dinlendirmeye bırak." to "Tavukları 12 dakika fırınla, çıkınca dilimlemeden önce 5 dakika dinlendirip sosla servis et."
                    )
                ),
                recipe(
                    baseName = "Ballı Hardallı Tavuk Şiş",
                    romanticAlias = "Tatlı Kıvılcım",
                    calories = 520,
                    ingredients = listOf(
                        "600 g tavuk but kuşbaşı",
                        "2 yemek kaşığı bal",
                        "1 yemek kaşığı Dijon hardal",
                        "1 yemek kaşığı tane hardal",
                        "2 yemek kaşığı zeytinyağı",
                        "1 kırmızı soğan",
                        "1 kırmızı biber",
                        "1 çay kaşığı füme paprika",
                        "Taze kekik yaprakları"
                    ),
                    inspiration = "Arda Türkmen'in şiş marinasyonlarından ilham alınmıştır.",
                    icon = Icons.Filled.LocalDining,
                    steps = arrayOf(
                        "Soğanı ve biberi iri karelere böl." to "Şiş çubuklarını suya batırıp beklet.",
                        "Bal, hardal çeşitleri, zeytinyağı ve paprikayı cam kâsede karıştır." to "Tavuk kuşbaşlarını sosla harmanlayıp 30 dakika buzdolabında dinlendir.",
                        "Şiş dizimi için sebze ve tavuk parçalarını dönüşümlü sırala." to "Izgara tavasını kızdırıp şişleri 10 dakika, çevirerek pişir.",
                        "Kekik yapraklarını kıy." to "Pişen şişleri kekikle süsleyip kalan sosla fırça yardımıyla parlatarak servis et."
                    )
                ),
                recipe(
                    baseName = "Fıstıklı Tavuklu Pilav",
                    romanticAlias = "İstanbul Melodisi",
                    calories = 560,
                    ingredients = listOf(
                        "2 adet tavuk but, kemiksiz",
                        "1 su bardağı baldo pirinç",
                        "2 yemek kaşığı çam fıstığı",
                        "1 orta boy soğan",
                        "1 yemek kaşığı tereyağı",
                        "2 yemek kaşığı zeytinyağı",
                        "1 çay kaşığı tarçın",
                        "2 su bardağı tavuk suyu",
                        "Kuru kuş üzümü"
                    ),
                    inspiration = "Refika Birgül'ün İstanbul esintili iç pilav yorumlarından esinlenildi.",
                    icon = Icons.Filled.LocalDining,
                    steps = arrayOf(
                        "Soğanı minik küp doğra; kuş üzümünü ılık suda beklet." to "Tavuk butlarını zeytinyağında 5 dakika mühürle, kenara al.",
                        "Tereyağı ile çam fıstığını hafifçe kavur." to "Soğanı ekleyip karamelize et, pirinci ilave ederek 4 dakika kavur.",
                        "Tarçın ve kuş üzümünü ekleyip karıştır." to "Sıcak tavuk suyunu döküp kapağını kapat, kısık ateşte 12 dakika pişir.",
                        "Pilavı 10 dakika demlenirken tavukları dilimle." to "Pilavı hafifçe havalandırıp dilimlenmiş tavukla katmanla, demleyip servis tabağını hazırla."
                    )
                ),
                recipe(
                    baseName = "Yoğurtlu Izgara Tavuk But",
                    romanticAlias = "Akşamüstü Esintisi",
                    calories = 480,
                    ingredients = listOf(
                        "4 adet kemiksiz tavuk but",
                        "4 yemek kaşığı süzme yoğurt",
                        "2 diş sarımsak",
                        "1 yemek kaşığı limon suyu",
                        "1 tatlı kaşığı sumak",
                        "1 tatlı kaşığı toz kırmızı biber",
                        "2 yemek kaşığı zeytinyağı",
                        "Taze nane yaprakları",
                        "Tuz"
                    ),
                    inspiration = "Cenk Sönmezsoy'un yoğurt marinasyon tekniklerinden uyarlanmıştır.",
                    icon = Icons.Filled.LocalDining,
                    steps = arrayOf(
                        "Sarımsağı rendele, yoğurt ve limon suyuyla sosu hazırla." to "Tavuk butlarını çizikler atarak aç.",
                        "Yoğurt sosuna sumak, kırmızı biber ve zeytinyağı ekleyip karıştır." to "Tavukları sosla kaplayıp 1 saat buzdolabında dinlendir.",
                        "Nane yapraklarını iri parçalara ayır." to "Izgara tavasını kızdırıp tavukları her yüzü 4 dakika pişir.",
                        "Servis için yoğurt sosundan bir kaşık ayır." to "Tavukları dinlendirip nane ve kalan sosla tabaklara yerleştir."
                    )
                ),
                recipe(
                    baseName = "Hindistan Cevizli Köri Tavuk",
                    romanticAlias = "Uzak Doğu Daveti",
                    calories = 540,
                    ingredients = listOf(
                        "500 g tavuk göğsü, şerit",
                        "1 adet büyük soğan",
                        "2 diş sarımsak",
                        "1 yemek kaşığı taze zencefil rendesi",
                        "1 yemek kaşığı sarı köri ezmesi",
                        "400 ml hafif hindistan cevizi sütü",
                        "1 yemek kaşığı hindistan cevizi yağı",
                        "1 adet kırmızı dolmalık biber",
                        "Taze kişniş"
                    ),
                    inspiration = "Madhur Jaffrey'in köri dengesi anlatımlarından yararlanıldı.",
                    icon = Icons.Filled.LocalDining,
                    steps = arrayOf(
                        "Soğanı yarım ay doğra; sarımsak ve zencefili rendele." to "Tavuk şeritlerini tuzlayıp kağıt havluda kurut.",
                        "Köri ezmesini hindistan cevizi yağıyla aç." to "Tavada tavukları 4 dakika yüksek ateşte mühürleyip kenara al.",
                        "Soğan, sarımsak ve zencefili tavada 5 dakika sotele." to "Köri ezmesini ekleyip 1 dakika kokusunu açığa çıkar.",
                        "Biber şeritlerini ve hindistan cevizi sütünü ekle." to "Tavukları tencereye geri koy, sos kıvam alınca kişnişle servis et."
                    )
                ),
                recipe(
                    baseName = "Mantarlı Tavuk Stroganoff",
                    romanticAlias = "Şefkatli Masal",
                    calories = 550,
                    ingredients = listOf(
                        "600 g tavuk göğsü, jülyen",
                        "200 g kültür mantarı",
                        "1 adet soğan",
                        "2 yemek kaşığı tereyağı",
                        "1 yemek kaşığı un",
                        "150 ml tavuk suyu",
                        "100 ml krema",
                        "1 yemek kaşığı Dijon hardal",
                        "Taze maydanoz"
                    ),
                    inspiration = "Julia Child'ın Stroganoff yorumundan esinlenildi.",
                    icon = Icons.Filled.LocalDining,
                    steps = arrayOf(
                        "Soğanı piyazlık doğra; mantarları dilimle." to "Tavuk jülyenlerini tuzlayıp 10 dakika dinlendir.",
                        "Tereyağının yarısıyla soğanı karamelize etmeye başla." to "Tavukları geniş tavada 4 dakika yüksek ateşte çevirip tabağa al.",
                        "Mantarları kalan tereyağında kızartıp un serpiştir." to "Tavuk suyunu ekleyip topakları aç, hardalı karıştır.",
                        "Kremayı ve ince kıyılmış maydanozu karışıma ekle." to "Tavukları tavaya geri alıp 3 dakika kısık ateşte sosla bağla, servis tabağına aktar."
                    )
                ),
                recipe(
                    baseName = "Taze Otlu Tavuk Ruloları",
                    romanticAlias = "Kalp Sarılısı",
                    calories = 500,
                    ingredients = listOf(
                        "4 adet tavuk göğsü",
                        "60 g labne peyniri",
                        "1 yemek kaşığı ince kıyılmış dereotu",
                        "1 yemek kaşığı ince kıyılmış maydanoz",
                        "1 yemek kaşığı ince kıyılmış fesleğen",
                        "1 yemek kaşığı zeytinyağı",
                        "8 dilim prosciutto veya füme hindi",
                        "1 çay kaşığı limon kabuğu rendesi",
                        "Taze çekilmiş karabiber"
                    ),
                    inspiration = "Danilo Zanna'nın ot dolgulu tavuk tekniklerinden uyarlanmıştır.",
                    icon = Icons.Filled.LocalDining,
                    steps = arrayOf(
                        "Tavuk göğüslerini iki yağlı kağıt arasında ince döv." to "Fırını 190°C'ye ısıt, fırın tepsisine yağlı kağıt ser.",
                        "Labne ve ince kıyılmış otları limon kabuğu ile karıştır." to "Tavukların üzerine karışımı yay, prosciutto dilimleriyle sar.",
                        "Ruloları sıkıca sarıp kürdanla sabitle." to "Ruloları 15 dakika fırınla, son 3 dakikada ızgara moduna al.",
                        "Dinlenirken kürdanları çıkar." to "Ruloları 2 cm kalınlığında dilimleyip tabaklarda çiğ zeytinyağı gezdirerek servis et."
                    )
                ),
                recipe(
                    baseName = "Kinoa Tabuleli Tavuk",
                    romanticAlias = "Bahar Dansı",
                    calories = 450,
                    ingredients = listOf(
                        "2 adet tavuk göğsü",
                        "1 su bardağı kinoa",
                        "1 salatalık",
                        "2 domates",
                        "1/2 demet maydanoz",
                        "4 dal taze nane",
                        "1 limonun suyu",
                        "2 yemek kaşığı zeytinyağı",
                        "Tuz ve sumak"
                    ),
                    inspiration = "Hazer Amani'nin tabule yorumundan esinlenildi.",
                    icon = Icons.Filled.LocalDining,
                    steps = arrayOf(
                        "Kinoyu yıkayıp süz; salatalık ve domatesi küp doğra." to "Kinoayı 2 su bardağı suyla 15 dakika pişir, soğumaya bırak.",
                        "Maydanoz ve naneyi ince kıy." to "Tavuk göğüslerini zeytinyağı, tuz ve sumakla ovup ızgarada pişir.",
                        "Limon suyu ve zeytinyağını çırparak sos hazırla." to "Kinoa soğuduğunda sebzeler ve otlarla karıştır, sosu ekle.",
                        "Servis kaselerine tabuleyi paylaştır." to "Tavukları dilimleyip tabule üzerine yerleştir, kalan sosu gezdir."
                    )
                ),
                recipe(
                    baseName = "Parmesan Kremalı Tavuk",
                    romanticAlias = "Altın Harmoni",
                    calories = 520,
                    ingredients = listOf(
                        "4 adet tavuk but fileto",
                        "2 yemek kaşığı zeytinyağı",
                        "3 diş sarımsak",
                        "200 ml krema",
                        "50 g rendelenmiş parmesan",
                        "1 çay kaşığı kuru kekik",
                        "1/2 su bardağı tavuk suyu",
                        "100 g baby ıspanak",
                        "Karabiber"
                    ),
                    inspiration = "Giada De Laurentiis'in kremalı tavuk tarifinden esinlenildi.",
                    icon = Icons.Filled.LocalDining,
                    steps = arrayOf(
                        "Sarımsakları ince dilimle, ıspanağı yıka." to "Tavuk filetoları tuzlayıp zeytinyağında iki yüzünü mühürle.",
                        "Tavadan çıkan suyu bir kenara al." to "Aynı tavada sarımsağı 1 dakika sotele, kremayı ve tavuk suyunu ekle.",
                        "Parmesan ve kekiği sos içine karıştır." to "Tavukları yeniden tavaya koy, sos koyulaşana dek 5 dakika pişir.",
                        "Ispanak yapraklarını iri kopar." to "Ocaktan almadan ıspanakları ekleyip solana dek karıştır, servis tabağına aktar."
                    )
                ),
                recipe(
                    baseName = "Sebzeli Tavuk Güveç",
                    romanticAlias = "Yuva Sıcaklığı",
                    calories = 580,
                    ingredients = listOf(
                        "600 g tavuk baget, kemikleriyle",
                        "2 adet havuç",
                        "2 adet patates",
                        "1 adet kabak",
                        "1 adet soğan",
                        "3 diş sarımsak",
                        "2 yemek kaşığı zeytinyağı",
                        "1 yemek kaşığı domates salçası",
                        "2 su bardağı tavuk suyu"
                    ),
                    inspiration = "Jamie Oliver'ın rustik güveç tekniklerinden uyarlanmıştır.",
                    icon = Icons.Filled.LocalDining,
                    steps = arrayOf(
                        "Havuç, patates ve kabağı iri küpler halinde doğra." to "Güveç kabını 200°C fırına uygun hale getir, zeytinyağını ısıt.",
                        "Soğan ve sarımsağı piyazlık doğrayıp salçayla karıştır." to "Tavuk bagetleri güveçte 5 dakika mühürle.",
                        "Sebzeleri güvece yay, salçalı karışımı üzerine gezdir." to "Tavuk suyunu ekleyip kapağını kapat, 45 dakika pişir.",
                        "Pişmeye yakın taze kekik yapraklarını hazırla." to "Fırından çıkarınca kekik serp, 10 dakika dinlendirip sıcak servis et."
                    )
                )
            )
        ),
        RecipeCategory(
            id = "dessert",
            displayName = "Tatlı",
            icon = Icons.Filled.BakeryDining,
            accentColor = Color(0xFFFCE7F3),
            recipes = listOf(
                recipe(
                    baseName = "Bitter Çikolatalı Mousse",
                    romanticAlias = "Gece Fısıltısı",
                    calories = 420,
                    ingredients = listOf(
                        "150 g %70 kakao bitter çikolata",
                        "3 adet yumurta, sarısı ve beyazı ayrılmış",
                        "30 g hindistan cevizi şekeri",
                        "150 ml soğuk krema",
                        "1 çay kaşığı vanilya özütü",
                        "1 tutam deniz tuzu",
                        "Taze frambuaz"
                    ),
                    inspiration = "Pierre Hermé'nin çikolata mousse tekniğinden esinlenildi.",
                    icon = Icons.Filled.BakeryDining,
                    steps = arrayOf(
                        "Çikolatayı benmari usulü eritin; yumurta sarılarını şekerle çırp." to "Çikolatayı ılıtıp yumurta sarısı karışımıyla homojen hale getir.",
                        "Vanilya ve tuzu ekle." to "Yumurta beyazlarını sert tepecikler oluşana dek çırp.",
                        "Çırpılmış kremayı üç aşamada karışıma spatula ile yedir." to "Yumurta beyazlarını iki aşamada katlayarak hacmi koru.",
                        "Servis kaselerine paylaştırıp frambuazla süsle." to "Mousseleri en az 2 saat buzdolabında dinlendirip soğuk servis et."
                    )
                ),
                recipe(
                    baseName = "Frambuazlı Cheesecake Parfe",
                    romanticAlias = "Aşk Bulutu",
                    calories = 480,
                    ingredients = listOf(
                        "200 g labne peyniri",
                        "150 g light krem peynir",
                        "60 g bal",
                        "150 g frambuaz",
                        "80 g yulaflı bisküvi",
                        "2 yemek kaşığı tereyağı",
                        "1 limon kabuğu rendesi",
                        "1 çay kaşığı vanilya"
                    ),
                    inspiration = "Claire Saffitz'in fırınsız cheesecake tekniklerinden esinlenildi.",
                    icon = Icons.Filled.BakeryDining,
                    steps = arrayOf(
                        "Bisküvileri rondodan geçir, tereyağıyla karıştır." to "Kadehlerin tabanına bisküvi karışımını bastır.",
                        "Labne, krem peynir, bal ve vanilyayı kremamsı kıvam alana dek çırp." to "Karışımı ikiye böl; yarısına frambuazları ezerek ekle.",
                        "Limon kabuğunu beyaz kısmını almadan rendele." to "Beyaz karışıma limon kabuğu ekleyip kadehlere kat kat paylaştır.",
                        "Üzerini taze frambuaz ve bisküvi kırığıyla süsle." to "Parfeleri servis öncesi 1 saat soğutarak kıvam ver."
                    )
                ),
                recipe(
                    baseName = "Sütlaç Brûlée",
                    romanticAlias = "İstanbul Alevi",
                    calories = 380,
                    ingredients = listOf(
                        "1 litre süt",
                        "1/2 su bardağı kırık pirinç",
                        "1/2 su bardağı esmer şeker",
                        "1 yemek kaşığı pirinç unu",
                        "1 adet çubuk tarçın",
                        "1 adet vanilya çubuğu",
                        "Üzeri için toz şeker"
                    ),
                    inspiration = "Mehmet Gürs'ün sütlaç sunum tekniklerinden esinlenildi.",
                    icon = Icons.Filled.BakeryDining,
                    steps = arrayOf(
                        "Pirinçleri yıkayıp 10 dakika ılık suda beklet." to "Sütü tencereye alıp tarçın ve vanilya ile ısıt.",
                        "Pirinçleri süzüp sütle buluştur, kısık ateşte yumuşayana dek pişir." to "Pirinç ununu az sütle açıp karışıma ekle, koyulaştır.",
                        "Esmer şekeri ekleyip 5 dakika daha kaynat." to "Karışımı ramekin kaplara paylaştırıp soğut.",
                        "Üzerine toz şeker serpip pürmüzle karamelleştir." to "Karamel kabuğu sertleşince tarçınla süsleyip servis et."
                    )
                ),
                recipe(
                    baseName = "Chia Taneli Fit Tiramisu",
                    romanticAlias = "Sabah Öpücüğü",
                    calories = 320,
                    ingredients = listOf(
                        "200 g light labne",
                        "150 g yoğurt",
                        "3 yemek kaşığı chia tohumu",
                        "150 ml demli filtre kahve",
                        "2 yemek kaşığı akçaağaç şurubu",
                        "8 adet tam buğday kedidili",
                        "1 çay kaşığı kakao",
                        "1 çay kaşığı kakao nibs"
                    ),
                    inspiration = "Jamie Oliver'ın hafif tiramisu yorumundan esinlenildi.",
                    icon = Icons.Filled.BakeryDining,
                    steps = arrayOf(
                        "Chia tohumlarını kahveyle ıslatıp 15 dakika şişmeye bırak." to "Labne ve yoğurdu akçaağaç şurubuyla pürüzsüz hale getir.",
                        "Kedidillerini kahveye batırıp servis kabına yerleştir." to "Chia karışımını üzerlerine yayıp labneli kremayla katman oluştur.",
                        "Kalan kedidilleriyle ikinci katı hazırla." to "Üst katmanı kremayla kapla, kakao eleyip nibs serpiştir.",
                        "Tatlıyı streçle ört." to "En az 4 saat buzdolabında dinlendirip soğuk servis et."
                    )
                ),
                recipe(
                    baseName = "Şeftalili Galette",
                    romanticAlias = "Yaz Kucaklaşması",
                    calories = 410,
                    ingredients = listOf(
                        "180 g tam buğday unu",
                        "100 g tereyağı",
                        "2 yemek kaşığı esmer şeker",
                        "1 tutam deniz tuzu",
                        "60 ml soğuk su",
                        "3 olgun şeftali",
                        "1 yemek kaşığı mısır nişastası",
                        "1 tatlı kaşığı limon suyu",
                        "1 yemek kaşığı badem unu"
                    ),
                    inspiration = "Dorie Greenspan'in galette tariflerinden esinlenildi.",
                    icon = Icons.Filled.BakeryDining,
                    steps = arrayOf(
                        "Un, şeker ve tuzu karıştırıp küp tereyağıyla kum kıvamı yakala." to "Hamura soğuk su ekleyip toparla, streçle sarıp 30 dakika soğut.",
                        "Şeftalileri ince dilimler halinde kes; limon suyu ve nişastayla harmanla." to "Hamuru 0.5 cm kalınlığında aç, kenarlarına badem unu serp.",
                        "Meyveleri ortada toplayacak şekilde diz." to "Kenarları içe kıvırıp 180°C'de 30 dakika pişir.",
                        "Fırından çıkınca hafif soğut." to "Galette'i bal gezdirip fesleğen yapraklarıyla servis et."
                    )
                ),
                recipe(
                    baseName = "Tahinli Çikolatalı Brownie",
                    romanticAlias = "Karamel Sarhoşluğu",
                    calories = 450,
                    ingredients = listOf(
                        "120 g bitter çikolata",
                        "100 g tereyağı",
                        "120 g toz badem",
                        "80 g esmer şeker",
                        "2 adet yumurta",
                        "3 yemek kaşığı tahin",
                        "1 tatlı kaşığı espresso tozu",
                        "1 çay kaşığı kabartma tozu",
                        "Bir tutam tuz"
                    ),
                    inspiration = "Yotam Ottolenghi'nin tahinli tatlılarından esinlenildi.",
                    icon = Icons.Filled.BakeryDining,
                    steps = arrayOf(
                        "Çikolata ve tereyağını birlikte eritin." to "Yumurta ve şekeri 3 dakika hacim alana dek çırp.",
                        "Erimiş çikolatayı yumurta karışımına ince akışla ekle." to "Toz badem, espresso tozu ve kabartma tozunu eleyip karışıma kat.",
                        "Tahin şeritlerini hamura çizgiler halinde dök." to "Karışımı kalıba alın, 180°C'de 22 dakika pişir.",
                        "Fırından çıkınca 15 dakika soğut." to "Kare dilimler kesip tahin gezdirerek servis et."
                    )
                ),
                recipe(
                    baseName = "Limonlu Zeytinyağlı Kek",
                    romanticAlias = "Akdeniz Esintisi",
                    calories = 360,
                    ingredients = listOf(
                        "3 adet yumurta",
                        "180 g toz şeker",
                        "120 ml natürel sızma zeytinyağı",
                        "180 g un",
                        "1 paket kabartma tozu",
                        "2 limonun suyu",
                        "2 limon kabuğu rendesi",
                        "1 tutam tuz",
                        "80 g pudra şekeri"
                    ),
                    inspiration = "Nigel Slater'ın limonlu kek notlarından esinlenildi.",
                    icon = Icons.Filled.BakeryDining,
                    steps = arrayOf(
                        "Yumurtaları ve şekeri hacim alana dek çırp." to "Zeytinyağını ince akışla ekleyip emülsiyon oluştur.",
                        "Un, kabartma tozu ve tuzu eleyip karışıma kat." to "Limon suyu ve kabuğunu ekleyip spatula ile homojenleştir.",
                        "Kalıbı yağlayıp tabanına yağlı kağıt ser." to "180°C fırında 35 dakika pişir.",
                        "Pudra şekeri ve limon suyuyla glazür hazırla." to "Kek ılıyınca glazürü döküp kabuk rendesiyle süsle."
                    )
                ),
                recipe(
                    baseName = "Matcha Panna Cotta",
                    romanticAlias = "Zarif Es",
                    calories = 300,
                    ingredients = listOf(
                        "400 ml hindistan cevizi sütü",
                        "200 ml süt",
                        "2 yemek kaşığı bal",
                        "2 tatlı kaşığı matcha tozu",
                        "1 paket jelatin",
                        "1 çay kaşığı vanilya özütü",
                        "Üzeri için yaban mersini"
                    ),
                    inspiration = "Sadaharu Aoki'nin matcha tatlılarından esinlenildi.",
                    icon = Icons.Filled.BakeryDining,
                    steps = arrayOf(
                        "Jelatini 4 yemek kaşığı soğuk suda beklet." to "Hindistan cevizi sütü ve sütü tencerede ısıt.",
                        "Matcha tozunu az sütle açarak pürüzsüz hale getir." to "Isınan karışıma bal ve matchayı ekleyip karıştır.",
                        "Ocaktan alınca jelatini ve vanilyayı ekle." to "Karışımı kalıplara döküp 4 saat soğut.",
                        "Kalıpları kısa süre sıcak suya batır." to "Panna cotta'yı ters çevirip meyvelerle servis et."
                    )
                ),
                recipe(
                    baseName = "Fırınsız Hurmalı Trüf",
                    romanticAlias = "Tatlı Fısıltı",
                    calories = 260,
                    ingredients = listOf(
                        "200 g medjool hurma",
                        "80 g ceviz",
                        "40 g kakao",
                        "1 yemek kaşığı hindistan cevizi yağı",
                        "1 çay kaşığı tarçın",
                        "1 tutam tuz",
                        "Kaplamak için hindistan cevizi rendesi"
                    ),
                    inspiration = "Ella Mills'in bitkisel trüf tariflerinden ilham alınmıştır.",
                    icon = Icons.Filled.BakeryDining,
                    steps = arrayOf(
                        "Hurmaların çekirdeklerini çıkar; cevizleri hafifçe kavur." to "Robotta hurma ve cevizleri macun kıvamına gelene dek çek.",
                        "Kakao, tarçın ve tuzu ekleyip tekrar karıştır." to "Hindistan cevizi yağını ekleyip karışımı toparla.",
                        "Harçtan ceviz büyüklüğünde parçalar al." to "Yuvarlayıp hindistan cevizi rendesine bulayarak soğut.",
                        "Hava almayan kaba yerleştir." to "Servisten önce 30 dakika buzdolabında beklet."
                    )
                ),
                recipe(
                    baseName = "Profiterol Kulesi",
                    romanticAlias = "Balo Işıltısı",
                    calories = 520,
                    ingredients = listOf(
                        "200 ml su",
                        "100 g tereyağı",
                        "150 g un",
                        "4 adet yumurta",
                        "400 ml süt",
                        "80 g toz şeker",
                        "30 g nişasta",
                        "1 paket vanilya",
                        "120 g bitter çikolata"
                    ),
                    inspiration = "Philippe Conticini'nin croquembouche tekniğinden esinlenildi.",
                    icon = Icons.Filled.BakeryDining,
                    steps = arrayOf(
                        "Su ve tereyağını kaynat, unu ekleyip spatulayla toparla." to "Hamuru karıştırma kabına alıp 5 dakika soğut, yumurtaları tek tek ekle.",
                        "Hamuru sıkma torbasına doldur." to "200°C fırında 20 dakika pişirip soğut.",
                        "Kremayı süt, şeker, nişasta ve vanilya ile pişir." to "Soğuyan kremayı şuaşeler içine doldur.",
                        "Çikolatayı benmaride erit." to "Profiterolleri kule şeklinde dizip çikolatayla kapla, 10 dakika soğutup servis et."
                    )
                )
            )
        ),
        RecipeCategory(
            id = "soup",
            displayName = "Çorba",
            icon = Icons.Filled.SoupKitchen,
            accentColor = Color(0xFFE0F2F1),
            recipes = listOf(
                recipe(
                    baseName = "Bal Kabaklı Zencefilli Çorba",
                    romanticAlias = "Sonbahar Sarılması",
                    calories = 220,
                    ingredients = listOf(
                        "600 g bal kabağı",
                        "1 adet tatlı patates",
                        "1 büyük soğan",
                        "3 diş sarımsak",
                        "2 yemek kaşığı zeytinyağı",
                        "1 yemek kaşığı taze zencefil",
                        "750 ml sebze suyu",
                        "1 yemek kaşığı akçaağaç şurubu",
                        "1/2 limonun suyu"
                    ),
                    inspiration = "Nigel Slater'ın sonbahar çorbalarından esinlenildi.",
                    icon = Icons.Filled.SoupKitchen,
                    steps = arrayOf(
                        "Bal kabağı ve tatlı patatesi küp doğra; soğan ve sarımsağı ince kıy." to "Zeytinyağını tencerede ısıtıp soğan ve sarımsağı 3 dakika sotele.",
                        "Zencefili rendele, limon suyunu sık." to "Bal kabağı ve tatlı patatesi ekleyip 5 dakika kavur.",
                        "Sebze suyunu ve akçaağaç şurubunu eklenmeye hazır tut." to "Tencereye sebze suyunu ekleyip 20 dakika kısık ateşte pişir.",
                        "Limon suyunu ekleyip blenderı hazırlat." to "Çorbayı pürüzsüz hale gelene dek blenderdan geçir, sıcak servis et."
                    )
                ),
                recipe(
                    baseName = "Kırmızı Mercimek & Kahverengi Tereyağ Çorbası",
                    romanticAlias = "Anadolu Aşkı",
                    calories = 260,
                    ingredients = listOf(
                        "1 su bardağı kırmızı mercimek",
                        "1 soğan",
                        "1 havuç",
                        "2 yemek kaşığı tereyağı",
                        "1 yemek kaşığı un",
                        "1 tatlı kaşığı kırmızı pul biber",
                        "1 tatlı kaşığı kimyon",
                        "6 su bardağı sıcak su",
                        "1 yemek kaşığı nar ekşisi"
                    ),
                    inspiration = "Refika Birgül'ün Anadolu çorba notlarından esinlenildi.",
                    icon = Icons.Filled.SoupKitchen,
                    steps = arrayOf(
                        "Soğanı ve havucu küp doğra." to "Tereyağının yarısıyla tencerede soğan ve havucu 5 dakika sotele.",
                        "Mercimeği yıkayıp süz." to "Unu ekleyip hafifçe kavur, üzerine sıcak suyu ekle.",
                        "Baharatları ölç, nar ekşisini hazırla." to "Mercimekleri ekleyip yumuşayana dek 20 dakika pişir.",
                        "Kalan tereyağını küçük tavada eritip pul biber ve kimyonla köpürt." to "Çorbayı blenderdan geçirip nar ekşisi ve tereyağlı sosla servis et."
                    )
                ),
                recipe(
                    baseName = "Kremalı Mantar Çorbası",
                    romanticAlias = "Orman Öyküsü",
                    calories = 240,
                    ingredients = listOf(
                        "400 g mantar karışımı",
                        "1 adet arpacık soğan",
                        "2 diş sarımsak",
                        "2 yemek kaşığı tereyağı",
                        "1 yemek kaşığı un",
                        "750 ml tavuk suyu",
                        "120 ml krema",
                        "1 dal taze kekik",
                        "Taze çekilmiş karabiber"
                    ),
                    inspiration = "Thomas Keller'ın mantar çorbası tekniklerinden uyarlanmıştır.",
                    icon = Icons.Filled.SoupKitchen,
                    steps = arrayOf(
                        "Mantarları silip dilimle; soğan ve sarımsağı ince kıy." to "Tencerede tereyağını eritip soğan ve sarımsağı sotele.",
                        "Unu eleyip hazır tut." to "Mantarları ekleyip suyunu çekene kadar kavur.",
                        "Kremayı ve kekiği ölç." to "Unu ekleyip 2 dakika kavur, tavuk suyunu yavaşça ekle.",
                        "Kremayı eklemeden önce kekik yapraklarını ayıkla." to "Çorbayı 15 dakika pişirip blenderdan geçir, kremayı ekleyip bir taşım kaynat."
                    )
                ),
                recipe(
                    baseName = "Sebzeli Minestrone",
                    romanticAlias = "Bahçe Valsi",
                    calories = 210,
                    ingredients = listOf(
                        "1 soğan",
                        "1 sap kereviz",
                        "1 havuç",
                        "1 kabak",
                        "1 su bardağı haşlanmış barbunya",
                        "1 su bardağı küçük makarna",
                        "400 g doğranmış domates",
                        "1 litre sebze suyu",
                        "Taze fesleğen"
                    ),
                    inspiration = "Jamie Oliver'ın minestrone dengeleme tekniklerinden esinlenildi.",
                    icon = Icons.Filled.SoupKitchen,
                    steps = arrayOf(
                        "Soğan, kereviz ve havucu minik küp doğra." to "Zeytinyağında aromatik üçlüyü 5 dakika sotele.",
                        "Kabağı yarım ay doğra, domates konservesini hazırla." to "Domatesleri ekleyip 2 dakika pişir.",
                        "Sebze suyunu ve barbunyayı eklemeye hazır ol." to "Sebze suyunu döküp kaynama noktasına getir, 10 dakika pişir.",
                        "Makarnayı eklemeden fesleğeni kopar." to "Makarnayı ekleyip al dente pişir, fesleğenle servis et."
                    )
                ),
                recipe(
                    baseName = "Klasik Ezogelin",
                    romanticAlias = "Kırmızı Düş",
                    calories = 230,
                    ingredients = listOf(
                        "1 su bardağı kırmızı mercimek",
                        "1/2 su bardağı bulgur",
                        "1 adet soğan",
                        "2 diş sarımsak",
                        "1 yemek kaşığı domates salçası",
                        "1 yemek kaşığı biber salçası",
                        "1 tatlı kaşığı nane",
                        "1 tatlı kaşığı pul biber",
                        "7 su bardağı sıcak su"
                    ),
                    inspiration = "Arda Türkmen'in ezogelin yorumu referans alındı.",
                    icon = Icons.Filled.SoupKitchen,
                    steps = arrayOf(
                        "Mercimek ve bulguru yıka." to "Tencerede soğan ve sarımsağı zeytinyağıyla 4 dakika sotele.",
                        "Salçaları karıştırmak için küçük kâse hazırla." to "Salçaları ekleyip 2 dakika kavur, sıcak suyu dök.",
                        "Nane ve pul biberi ölç." to "Mercimek ve bulguru tencereye ekle, 25 dakika pişir.",
                        "Blenderı hazırlayıp limonu sık." to "Çorbayı hafifçe ezerek kıvam ver, nane ve pul biber yağını gezdir."
                    )
                ),
                recipe(
                    baseName = "Denizci Bouillabaisse",
                    romanticAlias = "Mavi Hatıra",
                    calories = 310,
                    ingredients = listOf(
                        "400 g beyaz etli balık",
                        "200 g midye",
                        "200 g karides",
                        "2 adet domates",
                        "1 soğan",
                        "1 rezene sapı",
                        "2 diş sarımsak",
                        "1 yemek kaşığı domates salçası",
                        "1 litre balık suyu"
                    ),
                    inspiration = "Paul Bocuse'un bouillabaisse tekniklerinden esinlenildi.",
                    icon = Icons.Filled.SoupKitchen,
                    steps = arrayOf(
                        "Soğan, rezene ve domatesleri küp doğra." to "Zeytinyağında soğan ve rezene dilimlerini 5 dakika sotele.",
                        "Sarımsakları ince kıy." to "Sarımsağı ve salçayı ekleyip kokusu çıkana dek kavur.",
                        "Balık suyunu ve domatesleri eklemeye hazırla." to "Balık suyunu ekleyip 15 dakika kaynat.",
                        "Deniz ürünlerini temizle." to "Balık parçalarını, karides ve midyeleri ekleyip 6 dakika pişir, safranlı aioliyle servis et."
                    )
                ),
                recipe(
                    baseName = "Soğuk Bademli Gazpacho",
                    romanticAlias = "Yaz Serinliği",
                    calories = 180,
                    ingredients = listOf(
                        "4 olgun domates",
                        "1 salatalık",
                        "1 yeşil biber",
                        "2 diş sarımsak",
                        "50 g badem içi",
                        "50 ml zeytinyağı",
                        "30 ml şeri sirkesi",
                        "1 dilim bayat ekmek",
                        "Deniz tuzu"
                    ),
                    inspiration = "José Andrés'in gazpacho sunumlarından esinlenildi.",
                    icon = Icons.Filled.SoupKitchen,
                    steps = arrayOf(
                        "Domatesleri kabuklarını kolay soymak için çent ve sıcak suya al." to "Kabukları soyup çekirdekleri çıkar, iri doğra.",
                        "Salatalık ve biberi kabuklu doğra; sarımsağı ez." to "Tüm sebzeleri ve bademi blendera al.",
                        "Ekmek dilimini sirkede beklet." to "Zeytinyağı ve sirkeyi ekleyip pürüzsüz hale gelene kadar çek.",
                        "Tuzunu ayarla, sürahiye aktar." to "En az 2 saat buzdolabında soğut, servis ederken buzla sun."
                    )
                ),
                recipe(
                    baseName = "Tavuklu Noodle Çorbası",
                    romanticAlias = "Şefkatli Buhar",
                    calories = 290,
                    ingredients = listOf(
                        "2 tavuk budu",
                        "1 adet havuç",
                        "1 sap kereviz",
                        "1 küçük soğan",
                        "2 diş sarımsak",
                        "80 g erişte",
                        "1 yemek kaşığı soya sosu",
                        "1 yemek kaşığı taze limon suyu",
                        "Taze kişniş"
                    ),
                    inspiration = "Ina Garten'in rahatlatıcı tavuk çorbasından esinlenildi.",
                    icon = Icons.Filled.SoupKitchen,
                    steps = arrayOf(
                        "Havuç, kereviz ve soğanı küp doğra." to "Tavuk butlarını tencerede 1 litre suyla kaynat, köpükleri al.",
                        "Sarımsağı ez, kişnişi kıy." to "Sebzeleri tencereye ekleyip 20 dakika pişir.",
                        "Erişteyi hazırla." to "Tavukları çıkarıp didikle, erişteleri ekleyerek 5 dakika pişir.",
                        "Soya sosu ve limon suyunu ölç." to "Tavuğu geri ekleyip soya sosu ve limon suyuyla tatlandır, kişnişle servis et."
                    )
                ),
                recipe(
                    baseName = "Yeşil Detoks Çorbası",
                    romanticAlias = "Taze Uyanış",
                    calories = 170,
                    ingredients = listOf(
                        "1 küçük brokoli",
                        "1 avuç ıspanak",
                        "1 sap kereviz",
                        "1 yeşil elma",
                        "1 adet pırasa",
                        "1 diş sarımsak",
                        "1 yemek kaşığı zeytinyağı",
                        "750 ml sebze suyu",
                        "1 yemek kaşığı limon suyu"
                    ),
                    inspiration = "Yotam Ottolenghi'nin yeşil çorbalarından esinlenildi.",
                    icon = Icons.Filled.SoupKitchen,
                    steps = arrayOf(
                        "Brokoli çiçeklerini ayır; elmayı çekirdeklerinden temizle." to "Pırasayı zeytinyağında 4 dakika sotele.",
                        "Ispanak ve kerevizi doğra." to "Brokoli, kereviz ve elmayı ekleyip 3 dakika kavur.",
                        "Sebze suyunu eklemek için hazır ol." to "Sebze suyunu döküp 12 dakika pişir.",
                        "Ispanak ve limon suyunu sonradan eklemek üzere kenarda tut." to "Ispanak ve limonu ekleyip blenderdan geçir, sıcak servis et."
                    )
                ),
                recipe(
                    baseName = "Tarhanalı Yoğurt Çorbası",
                    romanticAlias = "Anadolu Kucaklaşması",
                    calories = 240,
                    ingredients = listOf(
                        "3 yemek kaşığı tarhana",
                        "2 su bardağı yoğurt",
                        "1 yumurta sarısı",
                        "4 su bardağı su",
                        "1 yemek kaşığı tereyağı",
                        "1 tatlı kaşığı nane",
                        "1 tatlı kaşığı kırmızı pul biber",
                        "1 diş sarımsak",
                        "Tuz"
                    ),
                    inspiration = "Maksut Aşkar'ın geleneksel çorba sunumlarından esinlenildi.",
                    icon = Icons.Filled.SoupKitchen,
                    steps = arrayOf(
                        "Yoğurt, yumurta sarısı ve tarhanayı çırp." to "Tencerede karışımı yavaşça ısıtırken sürekli karıştır.",
                        "Sarımsağı rendele." to "Suyu azar azar ekleyerek kaynayana dek karıştır.",
                        "Tereyağı ve baharatları ölç." to "10 dakika kısık ateşte pişir, tereyağında nane ve pul biberi köpürt.",
                        "Servis kaselerini hazırla." to "Üzerine tereyağlı sosu gezdirip sıcak servis et."
                    )
                )
            )
        ),
        RecipeCategory(
            id = "salad",
            displayName = "Salata",
            icon = Icons.Filled.Blender,
            accentColor = Color(0xFFEFF6FF),
            recipes = listOf(
                recipe(
                    baseName = "Narlı Kinoa Salatası",
                    romanticAlias = "Kırmızı Parıltı",
                    calories = 360,
                    ingredients = listOf(
                        "1 su bardağı kinoa",
                        "1 su bardağı nar tanesi",
                        "1 salatalık",
                        "1 avuç roka",
                        "4 dal taze nane",
                        "1 limon suyu",
                        "3 yemek kaşığı zeytinyağı",
                        "1 yemek kaşığı nar ekşisi",
                        "1/2 çay kaşığı sumak"
                    ),
                    inspiration = "Yotam Ottolenghi'nin kinoa salatası yorumlarından esinlenildi.",
                    icon = Icons.Filled.Blender,
                    steps = arrayOf(
                        "Kinoyu süzgeçte yıka, nar tanelerini ayıkla." to "Kinoayı 2 su bardağı suyla haşla, soğumaya bırak.",
                        "Salatalığı küp doğra, roka ve naneyi iri kopar." to "Soğuyan kinoayı geniş kaseye al, zeytinyağı ve limon suyuyla gevşet.",
                        "Nar ekşisi ve sumağı sos için karıştır." to "Doğranmış sebzeleri ve nar tanelerini ekleyip nazikçe karıştır.",
                        "Servis tabaklarını hazırlayıp otlarla süsle." to "Salatayı tabaklara paylaştırıp kalan sosu gezdir."
                    )
                ),
                recipe(
                    baseName = "Izgara Halloumi & Biber Salatası",
                    romanticAlias = "Akdeniz Sarılışı",
                    calories = 400,
                    ingredients = listOf(
                        "200 g halloumi peyniri",
                        "2 renkli dolmalık biber",
                        "1 küçük kırmızı soğan",
                        "1 avuç cherry domates",
                        "1 avuç roka",
                        "2 yemek kaşığı zeytinyağı",
                        "1 yemek kaşığı limon suyu",
                        "1 tatlı kaşığı kekik",
                        "Deniz tuzu"
                    ),
                    inspiration = "Jamie Oliver'ın halloumi salatalarından uyarlanmıştır.",
                    icon = Icons.Filled.Blender,
                    steps = arrayOf(
                        "Biberleri şerit doğra, soğanı ince halka yap." to "Izgara tavasını ısıtıp biberleri hafifçe karamelize et.",
                        "Halloumiyi 1 cm dilimler halinde kes." to "Peyniri tavada her yüzü 2 dakika pişir.",
                        "Zeytinyağı, limon suyu ve kekiği sos için karıştır." to "Izgara sebze ve halloumiyi karıştırıp sosla harmanla.",
                        "Roka ve domatesleri ikiye bölüp kaseye ekle." to "Salatayı tabaklara alıp tuz ve taze kekik yapraklarıyla bitir."
                    )
                ),
                recipe(
                    baseName = "Karpuz Feta Nane Salatası",
                    romanticAlias = "Yaz Flörtü",
                    calories = 300,
                    ingredients = listOf(
                        "500 g karpuz",
                        "150 g feta peyniri",
                        "1 küçük kırmızı soğan",
                        "1 avuç nane yaprağı",
                        "1 limon suyu",
                        "2 yemek kaşığı zeytinyağı",
                        "1 tatlı kaşığı bal",
                        "1 yemek kaşığı kabak çekirdeği",
                        "Deniz tuzu"
                    ),
                    inspiration = "Ina Garten'in yaz salatası esinlenilmiştir.",
                    icon = Icons.Filled.Blender,
                    steps = arrayOf(
                        "Karpuzu küp doğra, feta peynirini ufala." to "Soğanı ince dilimleyip buzlu suda beklet.",
                        "Bal, limon ve zeytinyağını çırparak sos hazırla." to "Karpuz ve fetayı geniş kaseye alıp sosun yarısıyla karıştır.",
                        "Nane yapraklarını kopar, çekirdekleri kavur." to "Soğan dilimlerini süzüp salataya ekle, kalan sosla harmanla.",
                        "Servis için tabakları soğut." to "Salatayı tabaklara paylaştırıp nane ve kabak çekirdekleriyle süsle."
                    )
                ),
                recipe(
                    baseName = "Çilekli Ispanak & Badem Salatası",
                    romanticAlias = "Tatlı Bahar",
                    calories = 320,
                    ingredients = listOf(
                        "150 g taze ıspanak",
                        "200 g çilek",
                        "40 g dilim badem",
                        "60 g keçi peyniri",
                        "1 yemek kaşığı balzamik sirke",
                        "2 yemek kaşığı zeytinyağı",
                        "1 tatlı kaşığı bal",
                        "1 çay kaşığı Dijon hardal",
                        "Taze çekilmiş karabiber"
                    ),
                    inspiration = "Martha Stewart'ın meyveli salata önerilerinden esinlenildi.",
                    icon = Icons.Filled.Blender,
                    steps = arrayOf(
                        "Ispanakları yıkayıp kurutucuya al." to "Badem dilimlerini tavada hafifçe kavur.",
                        "Çilekleri dilimle, keçi peynirini ufala." to "Zeytinyağı, balzamik, bal ve hardalı çırparak sos hazırla.",
                        "Servis kasesine ıspanakları ser." to "Çilek, badem ve peynir ekleyip sosun yarısıyla karıştır.",
                        "Sunum için ekstra çilek ayır." to "Salatayı tabaklara paylaştırıp kalan sosu gezdir."
                    )
                ),
                recipe(
                    baseName = "Köz Patlıcanlı Buğday Salatası",
                    romanticAlias = "İstanbul Esintisi",
                    calories = 380,
                    ingredients = listOf(
                        "1 su bardağı haşlanmış aşurelik buğday",
                        "2 adet közlenmiş patlıcan",
                        "1 kırmızı biber",
                        "3 dal taze soğan",
                        "1 diş sarımsak",
                        "3 yemek kaşığı zeytinyağı",
                        "1 yemek kaşığı nar ekşisi",
                        "1 yemek kaşığı sumak",
                        "Yarım demet maydanoz"
                    ),
                    inspiration = "Arda Türkmen'in meze kültürü notlarından esinlenildi.",
                    icon = Icons.Filled.Blender,
                    steps = arrayOf(
                        "Köz patlıcanların kabuklarını soy, biberi doğra." to "Buğdayı süzüp geniş bir kaseye al.",
                        "Sarımsak ve maydanozu ince kıy." to "Patlıcan, biber ve taze soğanı kaseye ekle.",
                        "Zeytinyağı, nar ekşisi ve sumağı sos için karıştır." to "Sosu salataya döküp nazikçe harmanla.",
                        "Servis tabağını hazırlayıp sumak serpiştir." to "Salatayı oda sıcaklığında dinlendirip soğuk servis et."
                    )
                ),
                recipe(
                    baseName = "Tahinli Mor Lahana Salatası",
                    romanticAlias = "Şehir Rüyası",
                    calories = 300,
                    ingredients = listOf(
                        "1/2 orta boy mor lahana",
                        "1 büyük havuç",
                        "2 yemek kaşığı tahin",
                        "2 yemek kaşığı limon suyu",
                        "1 yemek kaşığı elma sirkesi",
                        "1 yemek kaşığı bal",
                        "1 diş sarımsak",
                        "2 yemek kaşığı kavrulmuş susam",
                        "Tuz"
                    ),
                    inspiration = "Deb Perelman'ın tahinli salata soslarından esinlenildi.",
                    icon = Icons.Filled.Blender,
                    steps = arrayOf(
                        "Mor lahanayı ince şeritler halinde doğra." to "Lahanayı tuzla ovalayıp yumuşat.",
                        "Havucu jülyen doğra; sarımsağı ez." to "Tahin, limon suyu, sirke ve balı çırp.",
                        "Lahana ve havucu karıştırma kabına al." to "Sosu sebzelere ekleyip homojen karıştır.",
                        "Susamları tavada kısa süre kavur." to "Serviste salatanın üzerine susam serp."
                    )
                ),
                recipe(
                    baseName = "Turunçgil & Avokado Salatası",
                    romanticAlias = "Gün Batımı",
                    calories = 340,
                    ingredients = listOf(
                        "2 portakal",
                        "1 greyfurt",
                        "1 avokado",
                        "1 küçük kırmızı soğan",
                        "1 avuç roka",
                        "2 yemek kaşığı zeytinyağı",
                        "1 yemek kaşığı beyaz şarap sirkesi",
                        "1 çay kaşığı bal",
                        "Taze çekilmiş karabiber"
                    ),
                    inspiration = "Giada De Laurentiis'in turunçgil salatalarından esinlenildi.",
                    icon = Icons.Filled.Blender,
                    steps = arrayOf(
                        "Portakal ve greyfurtun kabuklarını fileto çıkacak şekilde soy." to "Meyve dilimlerini zarlarından ayır.",
                        "Avokadoyu dilimle, soğanı ince halka yap." to "Rokayı soğuk suda bekletip kurula.",
                        "Zeytinyağı, sirke ve balı çırp." to "Meyveler ve avokadoyu tabakta düzenle, soğan halkalarını ekle.",
                        "Rokayı son anda ekle." to "Sosu gezdirip karabiberle tamamla."
                    )
                ),
                recipe(
                    baseName = "Kremalı Patates & Taze Soğan Salatası",
                    romanticAlias = "Sahil Hatırası",
                    calories = 380,
                    ingredients = listOf(
                        "600 g bebek patates",
                        "4 dal taze soğan",
                        "100 g süzme yoğurt",
                        "2 yemek kaşığı mayonez",
                        "1 yemek kaşığı hardal",
                        "1 yemek kaşığı kapari",
                        "1 yemek kaşığı limon suyu",
                        "1 yemek kaşığı ince kıyılmış dereotu",
                        "Tuz ve karabiber"
                    ),
                    inspiration = "Nigella Lawson'un patates salatası notlarından uyarlanmıştır.",
                    icon = Icons.Filled.Blender,
                    steps = arrayOf(
                        "Patatesleri fırçalayarak temizle, taze soğanı ince doğra." to "Patatesleri tuzlu suda haşla, suyunu süzüp soğut.",
                        "Yoğurt, mayonez, hardal ve limon suyunu karıştır." to "Patatesleri ikiye bölüp sosla kapla.",
                        "Kapari ve dereotunu hazırla." to "Taze soğan ve kapariyi ekleyip tuz-karabiberle tatlandır.",
                        "Servis tabağını hazırlayıp dereotu serp." to "Salatayı soğuk veya ılık servis et."
                    )
                ),
                recipe(
                    baseName = "Falafelli Tabak Salatası",
                    romanticAlias = "Doğu Dansı",
                    calories = 420,
                    ingredients = listOf(
                        "12 adet mini falafel",
                        "1 su bardağı nohut filizi",
                        "1 salatalık",
                        "1 domates",
                        "1 avuç maydanoz",
                        "2 yemek kaşığı tahin",
                        "1 limon suyu",
                        "1 diş sarımsak",
                        "1 yemek kaşığı zeytinyağı"
                    ),
                    inspiration = "Michael Solomonov'un modern İsrail mutfağından esinlenildi.",
                    icon = Icons.Filled.Blender,
                    steps = arrayOf(
                        "Salatalığı küp doğra, domatesi çekirdeklerinden ayır." to "Falafelleri fırında 5 dakika ısıt.",
                        "Maydanozu ince kıy, limon suyunu sık." to "Tahin, limon, sarımsak ve zeytinyağını çırparak sos hazırla.",
                        "Geniş tabakta filiz ve sebzeleri yay." to "Falafelleri yerleştirip tahin sosu gezdir.",
                        "Servis için sumak ve maydanoz ayır." to "Son dokunuş olarak sumak serpip limon kabuğu rendesi ekle."
                    )
                ),
                recipe(
                    baseName = "Fırın Kök Sebzeli Mercimek Salatası",
                    romanticAlias = "Toprak Melodisi",
                    calories = 390,
                    ingredients = listOf(
                        "1 su bardağı yeşil mercimek",
                        "2 adet havuç",
                        "2 adet pancar",
                        "1 küçük tatlı patates",
                        "1 kırmızı soğan",
                        "3 yemek kaşığı zeytinyağı",
                        "1 yemek kaşığı elma sirkesi",
                        "1 yemek kaşığı hardal",
                        "Taze kekik"
                    ),
                    inspiration = "René Redzepi'nin kök sebze denge tekniklerinden esinlenildi.",
                    icon = Icons.Filled.Blender,
                    steps = arrayOf(
                        "Mercimeği yıkayıp 20 dakika haşla, süz." to "Fırını 200°C'ye ısıtıp sebzeleri küp doğra.",
                        "Sebzeleri zeytinyağı, tuz ve kekikle harmanla." to "Sebzeleri fırın tepsisine yayıp 25 dakika kızart.",
                        "Sirke ve hardalı çırp." to "Mercimeği ve fırın sebzelerini kasede buluşturup sosla karıştır.",
                        "Servis için kekik yaprakları ayır." to "Salatayı tabaklara alıp taze kekikle süsle."
                    )
                )
            )
        ),
        RecipeCategory(
            id = "fish",
            displayName = "Balık",
            icon = Icons.Filled.Water,
            accentColor = Color(0xFFE0F2FF),
            recipes = listOf(
                recipe(
                    baseName = "Izgara Levrek & Otlu Sos",
                    romanticAlias = "Deniz Rüyası",
                    calories = 420,
                    ingredients = listOf(
                        "2 adet levrek fileto",
                        "2 yemek kaşığı zeytinyağı",
                        "1 diş sarımsak",
                        "1 limonun suyu",
                        "1 yemek kaşığı ince kıyılmış dereotu",
                        "1 yemek kaşığı ince kıyılmış maydanoz",
                        "1 çay kaşığı kapari",
                        "Deniz tuzu",
                        "Taze çekilmiş karabiber"
                    ),
                    inspiration = "Mehmet Gürs'ün levrek ızgara tekniklerinden esinlenildi.",
                    icon = Icons.Filled.Water,
                    steps = arrayOf(
                        "Levrek filetolarını kılçıklarından arındır." to "Izgara tavasını yüksek ateşte ısıt.",
                        "Sarımsak, dereotu ve maydanozu ince kıy." to "Filetoları zeytinyağıyla fırçalayarak tuz-karabiberle tatlandır.",
                        "Kapari ve limon suyunu sos kasesinde birleştir." to "Balıkları derili yüzü aşağı gelecek şekilde 3 dakika pişir, çevirip 2 dakika daha pişir.",
                        "Otlu sosu servis öncesi hazırlayıp dinlendir." to "Balıkları tabaklara alıp sosu üzerinde gezdir, limon kabuğu rendesiyle bitir."
                    )
                ),
                recipe(
                    baseName = "Narenciyeli Fırın Somon",
                    romanticAlias = "Günışığı Sarmalı",
                    calories = 450,
                    ingredients = listOf(
                        "4 adet somon fileto",
                        "1 portakal",
                        "1 limon",
                        "2 yemek kaşığı bal",
                        "2 yemek kaşığı zeytinyağı",
                        "1 yemek kaşığı Dijon hardal",
                        "1 çay kaşığı taze zencefil",
                        "Taze kekik",
                        "Deniz tuzu"
                    ),
                    inspiration = "Jamie Oliver'ın narenciyeli somon tekniğinden esinlenildi.",
                    icon = Icons.Filled.Water,
                    steps = arrayOf(
                        "Portakal ve limonu ince dilimler halinde kes." to "Fırını 200°C'ye ısıt, tepsiyi yağla.",
                        "Bal, zeytinyağı, hardal ve rendelenmiş zencefili çırp." to "Somonları sosla kaplayıp tepsiye yerleştir.",
                        "Kekik dallarını hazırlayıp balıkların üzerine bırak." to "Narenciye dilimlerini somonların üstüne diz.",
                        "Servis tabağını önceden ısıt." to "Somonları 12 dakika fırınla, 3 dakika dinlendirip servis et."
                    )
                ),
                recipe(
                    baseName = "Sebzeli Fırın Morina",
                    romanticAlias = "Akşam Dalgası",
                    calories = 410,
                    ingredients = listOf(
                        "4 adet morina fileto",
                        "1 kırmızı biber",
                        "1 sarı biber",
                        "1 kabak",
                        "1 kırmızı soğan",
                        "3 yemek kaşığı zeytinyağı",
                        "1 yemek kaşığı beyaz şarap",
                        "1 tatlı kaşığı kekik",
                        "Deniz tuzu"
                    ),
                    inspiration = "Donna Hay'in tek tepsilik balık tariflerinden esinlenildi.",
                    icon = Icons.Filled.Water,
                    steps = arrayOf(
                        "Biberleri ve kabağı iri şeritlere, soğanı halka doğra." to "Sebzeleri zeytinyağı ve kekikle harmanlayıp fırın kabına yay.",
                        "Morina filetolarını kağıt havluyla kurula." to "Filetoları sebzelerin üzerine yerleştir.",
                        "Beyaz şarap ve zeytinyağını karıştır." to "Karışımı balıkların üzerine gezdirip 190°C'de 15 dakika pişir.",
                        "Servis için limon kabuğu rendele." to "Fırından çıkarıp 5 dakika dinlendir, limon kabuğu ve taze kekikle süsle."
                    )
                ),
                recipe(
                    baseName = "Zeytinli Çupra Buğulama",
                    romanticAlias = "Ege Fısıltısı",
                    calories = 420,
                    ingredients = listOf(
                        "2 adet çupra",
                        "1 kırmızı soğan",
                        "2 domates",
                        "1 avuç yeşil zeytin",
                        "2 diş sarımsak",
                        "2 yemek kaşığı zeytinyağı",
                        "1 çay bardağı beyaz şarap",
                        "1 dal defne yaprağı",
                        "Taze kekik"
                    ),
                    inspiration = "Şef Aydın Demir'in buğulama tekniklerinden esinlenildi.",
                    icon = Icons.Filled.Water,
                    steps = arrayOf(
                        "Çupraları temizleyip çizikler at." to "Soğanı yarım ay, domatesi dilimle.",
                        "Zeytinleri ikiye böl, sarımsağı ince dilimle." to "Geniş tencerenin tabanına soğan, domates ve zeytini yerleştir.",
                        "Şarap ve zeytinyağını karıştır, defne yaprağını hazırla." to "Balıkları sebzelerin üzerine koyup şarap karışımını dök.",
                        "Kapağı kapatıp kısık ateşe al." to "20 dakika pişir, servis ederken taze kekik serpiştir."
                    )
                ),
                recipe(
                    baseName = "Baharatlı Ton Balığı Tataki",
                    romanticAlias = "Gece Melodisi",
                    calories = 380,
                    ingredients = listOf(
                        "300 g sashimi kalitesinde ton balığı",
                        "2 yemek kaşığı soya sosu",
                        "1 yemek kaşığı susam yağı",
                        "1 tatlı kaşığı wasabi",
                        "1 yemek kaşığı kavrulmuş susam",
                        "1 lime",
                        "1 tatlı kaşığı togarashi",
                        "1 küçük avokado",
                        "Taze kişniş"
                    ),
                    inspiration = "Nobu Matsuhisa'nın tataki tekniklerinden esinlenildi.",
                    icon = Icons.Filled.Water,
                    steps = arrayOf(
                        "Ton balığını kağıt havluyla kurula, togarashiyle kapla." to "Döküm tavayı çok yüksek ateşte ısıt.",
                        "Soya sosu, susam yağı ve wasabiyi çırp." to "Ton balığını her yüzü 40 saniye mühürle.",
                        "Lime suyunu sık, avokadoyu dilimle." to "Balığı 5 dakika dinlendirip ince dilimle.",
                        "Kişnişi kıy, susamı hazırla." to "Dilimleri tabakta avokadoyla düzenle, sosu gezdirip susam ve kişnişle süsle."
                    )
                ),
                recipe(
                    baseName = "Şaraplı Midye Güveç",
                    romanticAlias = "Liman Buluşması",
                    calories = 360,
                    ingredients = listOf(
                        "1 kg temizlenmiş midye",
                        "2 diş sarımsak",
                        "1 küçük soğan",
                        "200 ml beyaz şarap",
                        "2 yemek kaşığı tereyağı",
                        "1 yemek kaşığı krema",
                        "1 avuç maydanoz",
                        "1 limon",
                        "Karabiber"
                    ),
                    inspiration = "Gordon Ramsay'in midye güveç tekniğinden esinlenildi.",
                    icon = Icons.Filled.Water,
                    steps = arrayOf(
                        "Sarımsağı ez, soğanı ince doğra." to "Tereyağını derin tencerede eritip soğan ve sarımsağı sotele.",
                        "Şarabı ve kremayı ölç." to "Midyeleri ekleyip yüksek ateşte 2 dakika karıştır.",
                        "Şarabı tencereye dök, kapağı kapat." to "Midyeler açılana dek 4 dakika pişir.",
                        "Maydanozu kıy, limonu dilimle." to "Kremayı ekleyip tencereyi çalkala, maydanoz ve limonla servis et."
                    )
                ),
                recipe(
                    baseName = "Karidesli Safranlı Risotto",
                    romanticAlias = "Ayışığı Dansı",
                    calories = 520,
                    ingredients = listOf(
                        "250 g arborio pirinç",
                        "300 g jumbo karides",
                        "1 litre sebze suyu",
                        "1 küçük soğan",
                        "2 diş sarımsak",
                        "1 paket safran",
                        "60 ml beyaz şarap",
                        "40 g parmesan",
                        "30 g tereyağı"
                    ),
                    inspiration = "Massimo Bottura'nın risotto tekniklerinden esinlenildi.",
                    icon = Icons.Filled.Water,
                    steps = arrayOf(
                        "Soğanı minik küp doğra, sarımsağı ez." to "Tereyağının yarısıyla soğanı tencerede şeffaflaştır.",
                        "Safranı sıcak suda demle, karidesleri temizle." to "Pirinçi ekleyip 2 dakika kavur, şarapla deglaze et.",
                        "Sebze suyunu kepçe kepçe eklemek için hazır ol." to "Her eklemede sürekli karıştırarak pirinci kremamsı kıvama getir.",
                        "Karidesleri ayrı tavada sotele." to "Son kepçede safranlı suyu ekle, parmesan ve kalan tereyağıyla bitirip karidesleri üzerine yerleştir."
                    )
                ),
                recipe(
                    baseName = "Tahinli Balık Köftesi",
                    romanticAlias = "Kıyı Sarılması",
                    calories = 390,
                    ingredients = listOf(
                        "400 g beyaz etli balık fileto",
                        "1 adet yumurta",
                        "2 yemek kaşığı galeta unu",
                        "1 yemek kaşığı ince kıyılmış dereotu",
                        "1 yemek kaşığı ince kıyılmış maydanoz",
                        "1 limon kabuğu rendesi",
                        "2 yemek kaşığı tahin",
                        "2 yemek kaşığı yoğurt",
                        "Zeytinyağı"
                    ),
                    inspiration = "Rick Stein'in balık köftesi tekniğinden esinlenildi.",
                    icon = Icons.Filled.Water,
                    steps = arrayOf(
                        "Balık filetolarını küp doğra." to "Mutfak robotunda balığı, yumurta ve galeta ununu çek.",
                        "Dereotu, maydanoz ve limon kabuğunu ince kıy." to "Karışıma otları ekleyip tuz-karabiber ayarla.",
                        "Tahin ve yoğurdu sos için karıştır." to "Karışımdan köfteler yapıp zeytinyağında altın rengi alıncaya dek kızart.",
                        "Servis için limon dilimle." to "Köfteleri tahin sosu ve limonla servis et."
                    )
                ),
                recipe(
                    baseName = "Izgara Kalamar & Otlu Salata",
                    romanticAlias = "Deniz Perdesi",
                    calories = 350,
                    ingredients = listOf(
                        "500 g temizlenmiş kalamar",
                        "2 yemek kaşığı zeytinyağı",
                        "1 limonun suyu",
                        "2 diş sarımsak",
                        "1 yemek kaşığı ince kıyılmış maydanoz",
                        "1 yemek kaşığı ince kıyılmış dereotu",
                        "1 kırmızı biber",
                        "1 avuç roka",
                        "Tuz ve karabiber"
                    ),
                    inspiration = "José Andrés'in kalamar ızgara tekniklerinden esinlenildi.",
                    icon = Icons.Filled.Water,
                    steps = arrayOf(
                        "Kalamarları halka veya bütün olarak hazırlayıp kağıt havluda kurut." to "Izgara tavasını yüksek ateşte ısıt.",
                        "Sarımsağı rendele, otları kıy." to "Kalamarları zeytinyağı ve limon suyu ile marine et.",
                        "Biberi ince şeritler halinde doğra." to "Kalamarları tavada her yüzünü 2 dakika pişir.",
                        "Roka ve otları kaseye al." to "Kalamarları otların üzerine yerleştirip biber şeritleri ve limon kabuğu ile servis et."
                    )
                ),
                recipe(
                    baseName = "Bademli Fırın Alabalık",
                    romanticAlias = "Dağ Aşkı",
                    calories = 430,
                    ingredients = listOf(
                        "2 adet alabalık",
                        "2 yemek kaşığı tereyağı",
                        "40 g file badem",
                        "1 limon",
                        "2 diş sarımsak",
                        "1 dal biberiye",
                        "2 yemek kaşığı beyaz şarap",
                        "Tuz",
                        "Karabiber"
                    ),
                    inspiration = "Dan Barber'ın sürdürülebilir balık tekniklerinden esinlenildi.",
                    icon = Icons.Filled.Water,
                    steps = arrayOf(
                        "Alabalıkları temizleyip içini kağıt havluyla kurula." to "Fırını 190°C'ye ısıt, fırın kabını yağla.",
                        "Sarımsağı ez, limonu dilimle." to "Balıkların içine sarımsak, biberiye ve limon dilimleri yerleştir.",
                        "Tereyağını erit, bademleri hafifçe kavur." to "Balıkları fırın kabına alıp üzerine tereyağı ve şarap gezdir.",
                        "Servis için ekstra badem hazırla." to "25 dakika fırınla, üzerini kavrulmuş bademle süsle."
                    )
                )
            )
        )
    )
}

private fun recipe(
    baseName: String,
    romanticAlias: String,
    calories: Int,
    ingredients: List<String>,
    inspiration: String,
    icon: ImageVector,
    steps: Array<Pair<String, String>>
): Recipe {
    val femaleSteps = steps.map { it.first }
    val maleSteps = steps.map { it.second }
    require(femaleSteps.size == maleSteps.size) { "Adım dağılımı eşit olmalı." }
    return Recipe(
        name = "$baseName ($romanticAlias)",
        calories = calories,
        ingredients = ingredients,
        femaleSteps = femaleSteps,
        maleSteps = maleSteps,
        inspiration = inspiration,
        icon = icon
    )
}
