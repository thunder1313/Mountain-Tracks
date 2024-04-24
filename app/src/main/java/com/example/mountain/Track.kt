package com.example.mountain

class Track(
    val id: Int,
    val name: String,
    val description: String,
    val points: Array<String>,
    val thumbnail: String,
    var times: MutableList<String> = mutableListOf(), // Ensure times is a MutableList
    var isRunning: Boolean = false,
    var seconds: Int = 0,
    var minutes: Int = 0,
    var hours: Int = 0
) {
    companion object {
        val tracks = arrayOf(
            Track(0, "Mountain Trail", "Discover the beauty of mountain landscapes.", arrayOf("Mountain Peak", "Valley View"), thumbnail = "https://www.example.com/image1.jpg"),
            Track(1, "Forest Hike", "Explore serene forests with diverse wildlife.", arrayOf("Old Oak Tree", "Clearing"), thumbnail = "https://www.example.com/image2.jpg"),
            Track(2, "Lakeside Walk", "Enjoy a peaceful stroll along the lake shore.", arrayOf("Lakeside View", "Docks"), thumbnail = "https://www.example.com/image3.jpg"),
            Track(3, "Ridge Run", "Challenge yourself with a run along mountain ridges.", arrayOf("Scenic Ridge", "Narrow Path"), thumbnail = "https://www.example.com/image4.jpg"),
            Track(4, "Waterfall Trail", "Experience the power and beauty of waterfalls.", arrayOf("Waterfall Cascade", "Rocky Path"), thumbnail = "https://www.example.com/image5.jpg"),
            Track(5, "Sunset Climb", "Climb to the top for breathtaking sunset views.", arrayOf("Sunset Peak", "Twilight Ridge"), thumbnail = "https://www.example.com/image6.jpg"),
            Track(6, "Canyon Exploration", "Discover hidden canyons and winding paths.", arrayOf("Canyon Walls", "Narrow Gorge"), thumbnail = "https://www.example.com/image7.jpg"),
            Track(7, "Desert Trek", "Traverse vast deserts and sandy dunes.", arrayOf("Desert Oasis", "Endless Horizon"), thumbnail = "https://www.example.com/image8.jpg"),
            Track(8, "Coastal Walk", "Enjoy ocean views and salty sea breeze.", arrayOf("Cliffside Trail", "Coastal Rocks"), thumbnail = "https://www.example.com/image9.jpg"),
            Track(9, "Winter Wonderland", "Embrace the winter wonderland with snowy trails.", arrayOf("Snowy Forest", "Frozen Lake"), thumbnail = "https://www.example.com/image10.jpg"),
            Track(10, "Historic Route", "Walk through history on ancient paths.", arrayOf("Ruins", "Historic Markers"), thumbnail = "https://www.example.com/image11.jpg")
        )

    }
}
