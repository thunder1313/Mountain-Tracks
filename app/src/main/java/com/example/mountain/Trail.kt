package com.example.mountain

class Trail(
    val id: Int,
    val name: String,
    val description: String,
    val points: Array<String>,
    val thumbnail: String,
    var isRunning: Boolean = false,
    var seconds: Int = 0,
    var minutes: Int = 0,
    var hours: Int = 0,
    var savedSeconds: Int=0,
    var savedMinutes: Int=0,
    var savedHours: Int=0
) {
    companion object {
        val trails = arrayOf(
            Trail(0, "Czupel", "Najwyższy szczyt Beskidu Małego - ma 933 metry n.p.m. Zaliczany jest jednocześnie do Korony Gór Polski (28 najwyższych szczytów pasm górskich Polski) i do Małej Korony Beskidów (15 szczytów Beskidu Śląskiego, Żywieckiego i Małego).", arrayOf("Przełęcz Przegibek", " Schronisko PTTK Na Magurce", "Czupel"), thumbnail = "https://ocdn.eu/pulscms-transforms/1/m2Gk9kpTURBXy80MTI0NDcyYjM4YjA2NzQ4ZTJkZmZkMjRlZDFkMTQxZS5qcGeTlQMAHM0DhM0B-pUCzQSwAMPDkwmmM2I3ZjQyBt4AAaEwAQ/beskid-slaski.jpeg"),
            Trail(1, "Babia Góra", "Najwyższy szczyt Beskidu Żywieckiego i całego zachodniego Beskidu Śląskiego, oraz trzeci co do wysokości szczyt Polski (po Rysach i Czarnym Groniu).", arrayOf("Przełęcz Krowiarki", "Schodnie Koniarki", "Babia Góra"), thumbnail = "https://portaltatrzanski.pl/upload/article/fcf58149b97ee41d499c32a77e7c5cb0.jpeg"),
            Trail(2, "Giewont", "Jedna z najbardziej charakterystycznych gór Polski. Jej zachodnie stoki opadają stromo ku Zakopanemu, tworząc charakterystyczny, 1-kilometrowej długości garb w formie graniowego cypla zwieńczonego trzema turniami, położonymi jedna za drugą.", arrayOf("Polana Strążyska", "Przełęcz Bystra Ławka", "Giewont"), thumbnail = "https://portaltatrzanski.pl/upload/article/5baf7382a3d07b2a8c2c7f3c2b9218f2.jpeg"),
            Trail(3, "Kasprowy Wierch", "Drugoroczna kolejka górska w Polsce, czynna od grudnia do kwietnia. Z dworca na Kasprowy Wierch rozciąga się szeroki widok na Tatry.", arrayOf("Dolina Kasprowa", "Przełęcz Kondracka", "Kasprowy Wierch"), thumbnail = "https://portaltatrzanski.pl/upload/article/669287da5a7bdefdee4a7571e2b3f136.jpeg"),
            Trail(4, "Rusinowa Polana", "Kaplica Matki Bożej Jaworzyńskiej na Wiktorówkach znana też jako Kaplica Matki Bożej Królowej Tatr lub Sanktuarium Matki Bożej Jaworzyńskiej Królowej Tatr to miejsce chętnie odwiedzane przez turystów. Położona w gęstym świerkowym lesie sprzyja zadumie i kontemplacji.", arrayOf("Wierchoporoniec", "Rusinowa Polana"), thumbnail = "https://hasajacezajace.com/wp-content/uploads/2021/01/rusinowa-polana-39.jpg"),
            Trail(5, "Chybotek", "Najwyżej położony siedmiokątny kamień o wadze kilkudziesięciu ton i średnicy około czterech metrów wsparty jest jedynie w dwóch miejscach. Daje się on rozkołysać i stąd nazwa – „Chybotek”. Obok są inne mniejsze skałki, podobnie poukładane. Związane są z nimi walońskie legendy o Duchu Gór. Jedna z nich podaje, że skała zamykała wejście do podziemnego skarbca, a otaczała ją aura tajemniczości.", arrayOf("Szklarska Poręba", "Chybotek"), thumbnail = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/1304_Chybotek_Szklarska_Por%C4%99ba_DJE_2.jpg/1200px-1304_Chybotek_Szklarska_Por%C4%99ba_DJE_2.jpg"),
            Trail(6, "Połonina Wetlińska", "Połonina Wetlińska wraz ze słynną Chatką Puchatka na grani to bez wątpienia jeden z najpiękniejszych fragmentów Bieszczadzkiego Parku Narodowego.", arrayOf("Przełęcz Wyżna", "Brzegi Górne", "Chatka Puchatka", "Przełęcz Orłowicza", "Wetlina"), thumbnail = "https://www.info.bieszczady.pl/wp-content/uploads/2023/08/14-1.jpg"),
            Trail(7, "Sokolica", "Sokolica jest jednym najbardziej rozpoznawalnych pienińskich szczytów a do tego miejscem z którego roztacza się przepyszna panorama. I to zarazem wertykalnej jak i w horyzontalnej perspektywie. Widok okraszony jest obecnością słynnej sosenki, która pomimo przeciwności losu, wciąż trwa i przyciąga kolejne rzesze turystów.", arrayOf("Krościenko", "Sokolica"), thumbnail = "https://gorskim-szlakiem.pl/wp-content/uploads/2021/12/P1000533-e1638879467786-1024x640.jpg"),
            Trail(8, "Śnieżka", "Śnieżka znacznie góruje nad otaczającymi ją grzbietami. Wznosi się w zachodniej części Czarnego Grzbietu.", arrayOf("Karpacz", "Samotnica", "Strzecha Akademicka", "Snieżka"), thumbnail = "https://i.wpimg.pl/1200x/filerepo.grupawp.pl/api/v1/display/embed/56567d5f-1879-4c99-9249-5a4727332138"),
            Trail(9, "Łysica", "Łysica zbudowana jest z kwarcytów i łupków kambryjskich. Od strony północnej i południowej szczyt otaczają gołoborza. Łysica jest całkowicie porośnięta lasem. W partiach szczytowych rośnie jodła, a poniżej las jodłowo-bukowy. Na stoku południowym, na wysokości ok. 590 m, położone jest niewielkie torfowisko.", arrayOf("Święta Katarzyna", "Puszcza Jodłowa", "Łysica"), thumbnail = "https://marcinkarpinski.pl/img/relacja/kgp-lysica/1200-kgp-lysica-023.webp"),
            Trail(10, "Dolina Kościeliska", "Dolina Kościeliska ma licznych wielbicieli. Bywa uważana za jedną z najpiękniejszych tatrzańskich dolin, bogatą w atrakcje przyrodnicze oraz pamiątki historyczne.", arrayOf("Kiry", "Polana Pisana", "Dolina Kościelicka"), thumbnail = "https://i.wpimg.pl/640x480/i1.nocimg.pl/d14/160/18-dolina-koscieliska-najpiekniejsza-dolina.jpg"),
            Trail(11, "Szczeliniec Wielki", "Szczeliniec Wielki jest najwyższym szczytem Gór Stołowych i to od niego warto rozpocząć zwiedzanie tutejszych szlaków. Trasa nie jest ani trudna, ani czasochłonna, za to chwilami pysznie widokowa i pasjonująca.", arrayOf("Karłów", "Szczeliniec Mały", "Szczeliniec Wielki"), thumbnail = "https://www.ahojprzygodo.com/wp-content/uploads/2020/08/szczeliniec-wielki-gory-stolowe-park-narodowy-korona-gor-polski-dolnoslaskie-szczyt-dla-dzieci-70.jpg")

        )

        val hardTrails = arrayOf(
            Trail(0, "Mountain Trail", "Discover the beauty of mountain landscapes.", arrayOf("Mountain Peak", "Valley View"), thumbnail = "https://i.pinimg.com/originals/1d/e4/ab/1de4ab9701560f33903a119b1609003d.jpg"),
            Trail(1, "Forest Hike", "Explore serene forests with diverse wildlife.", arrayOf("Old Oak Tree", "Clearing"), thumbnail = "https://www.pittsburghmagazine.com/content/uploads/2020/03/cb-cook-forest-trail1.jpg"),
            Trail(2, "Lakeside Walk", "Enjoy a peaceful stroll along the lake shore.", arrayOf("Lakeside View", "Docks"), thumbnail = "https://leitrimtourism.com/wp-content/uploads/2020/07/walking-keeldra-lake-01.jpg"),
            Trail(3, "Ridge Run", "Challenge yourself with a run along mountain ridges.", arrayOf("Scenic Ridge", "Narrow Path"), thumbnail = "https://winddrinkers.org/wp-content/uploads/2014/08/baldy_mountain_3-705x529.jpg"),
            Trail(4, "Waterfall Trail", "Experience the power and beauty of waterfalls.", arrayOf("Waterfall Cascade", "Rocky Path"), thumbnail = "https://www.example.com/image5.jpg"),
            Trail(5, "Sunset Climb", "Climb to the top for breathtaking sunset views.", arrayOf("Sunset Peak", "Twilight Ridge"), thumbnail = "https://www.example.com/image6.jpg"),
            Trail(6, "Canyon Exploration", "Discover hidden canyons and winding paths.", arrayOf("Canyon Walls", "Narrow Gorge"), thumbnail = "https://www.example.com/image7.jpg"),
            Trail(7, "Desert Trek", "Traverse vast deserts and sandy dunes.", arrayOf("Desert Oasis", "Endless Horizon"), thumbnail = "https://www.example.com/image8.jpg"),
            Trail(8, "Coastal Walk", "Enjoy ocean views and salty sea breeze.", arrayOf("Cliffside Trail", "Coastal Rocks"), thumbnail = "https://www.example.com/image9.jpg"),
            Trail(9, "Winter Wonderland", "Embrace the winter wonderland with snowy trails.", arrayOf("Snowy Forest", "Frozen Lake"), thumbnail = "https://www.example.com/image10.jpg"),
            Trail(10, "Historic Route", "Walk through history on ancient paths.", arrayOf("Ruins", "Historic Markers"), thumbnail = "https://www.example.com/image11.jpg")
        )
    }
}
