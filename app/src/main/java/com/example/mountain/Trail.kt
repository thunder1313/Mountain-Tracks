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
            Trail(0, "Czupel", "Najwyższy szczyt Beskidu Małego - ma 933 metry n.p.m.Zaliczany jest jednocześnie do Korony Gór Polski (28 najwyższych szczytów pasm górskich Polski) i do Małej Korony Beskidów (15 szczytów Beskidu Śląskiego, Żywieckiego i Małego).", arrayOf("Przełęcz Przegibek", " Schronisko PTTK Na Magurce", "Czupel"), thumbnail = "https://ocdn.eu/pulscms-transforms/1/m2Gk9kpTURBXy80MTI0NDcyYjM4YjA2NzQ4ZTJkZmZkMjRlZDFkMTQxZS5qcGeTlQMAHM0DhM0B-pUCzQSwAMPDkwmmM2I3ZjQyBt4AAaEwAQ/beskid-slaski.jpeg"),
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
