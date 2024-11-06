package ibanez.pppb1.tugasp10pppb1.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("avatar")
    val avatar: String
)
