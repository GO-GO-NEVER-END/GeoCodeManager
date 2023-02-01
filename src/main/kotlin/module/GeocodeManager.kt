package module

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import model.Geocode
import model.GeoModel.GeocodeModel
import okhttp3.OkHttpClient
import okhttp3.Request

class GeocodeManager {

    private val client = OkHttpClient()
    private val basicRequestBuilder = Request
        .Builder()
        .addHeader("X-NCP-APIGW-API-KEY-ID", Private.CLIENT_KEY)
        .addHeader("X-NCP-APIGW-API-KEY", Private.CLIENT_SECRET)

    @OptIn(ExperimentalSerializationApi::class)
    fun convertToGeocode(location: String): Geocode {

        val request = basicRequestBuilder
            .url(BASE_URL + location)
            .build()

        val response = client.newCall(request).execute()

        if (response.isSuccessful) {
            val byteStream = response.body?.byteStream()

            val data = Json.decodeFromStream<GeocodeModel>(byteStream!!)

            if (data.addresses.isNullOrEmpty()) return Geocode.EMPTY_GEOCODE

            val longitude = data.addresses.first().x
            val latitude = data.addresses.first().y

            return Geocode(longitude, latitude)
        } else {
            throw Exception("${response.code}")
        }

    }

    companion object {
        private const val BASE_URL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="
    }

}