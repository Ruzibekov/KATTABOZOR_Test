package com.ruzibekov.kattabozor_test.data.model

data class ProductOfferResponse(
    val attributes: List<ProductAttributeResponse>,
    val brand: String,
    val category: String,
    val id: Int,
    val image: ProductImageResponse,
    val merchant: String,
    val name: String
)