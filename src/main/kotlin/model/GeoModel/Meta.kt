package model.GeoModel

import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    val count: Int? = null,
    val page: Int? = null,
    val totalCount: Int? = null
)