package com.ruzibekov.kattabozor_test.data.model

import com.google.gson.annotations.SerializedName

data class OfferBaseResponse(
    @SerializedName("offers") val offers: List<OfferResponse>
)