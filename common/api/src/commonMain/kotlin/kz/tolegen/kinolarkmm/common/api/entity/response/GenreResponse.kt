package kz.tolegen.kinolarkmm.common.api.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenreResponse(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String
)