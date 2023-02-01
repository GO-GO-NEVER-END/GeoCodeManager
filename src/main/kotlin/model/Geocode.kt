package model

data class Geocode(val longitude: String, val latitude: String) {
    companion object {
        val EMPTY_GEOCODE = Geocode("-1","-1")
    }
}

