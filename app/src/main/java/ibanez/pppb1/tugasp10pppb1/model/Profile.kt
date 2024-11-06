package ibanez.pppb1.tugasp10pppb1.model

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("data")
    val `data`: List<Data>
)
