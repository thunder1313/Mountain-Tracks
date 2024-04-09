package com.example.mountain

class Track(val trackName: String, val trackDetails: String) {
    companion object {
        val tracks: Array<Track> = arrayOf(
            Track("Track 1", "1"),
            Track("Track 2", "2"),
            Track("Track 3", "3"),
            Track("Track 4", "4"),
            Track("Track 5", "5"),
            Track("Track 6", "6"),
            Track("Track 7", "7"),
            Track("Track 8", "8"),
            Track("Track 9", "9"),
            Track("Track 10", "10"),
            Track("Track 11", "11"),
            Track("Track 12", "12"),
            Track("Track 13", "13"),
            Track("Track 14", "14"),
            Track("Track 15", "15"),
            Track("Track 16", "16"),
            Track("Track 17", "17"),
            Track("Track 18", "18"),
            Track("Track 19", "19"),
            Track("Track 20", "20")
            // Add more tracks as needed
        )
    }

    fun getName(): String {
        return trackName;
    }

    fun getDetails(): String {
        return trackDetails;
    }
}
