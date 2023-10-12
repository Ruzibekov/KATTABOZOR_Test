package com.ruzibekov.kattabozor_test.data.model

data class OfferResponse(
    val id: Int,
    val attributes: List<OfferAttributeResponse>,
    val brand: String,
    val category: String,
    val image: OfferImageResponse,
    val merchant: String,
    val name: String
)