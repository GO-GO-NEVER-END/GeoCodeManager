package model.GeoModel

import kotlinx.serialization.Serializable

@Serializable
data class GeocodeModel(
    val addresses: List<Addresse>? = null,
    val errorMessage: String? = null,
    val meta: Meta? = null,
    val status: String? = null
)