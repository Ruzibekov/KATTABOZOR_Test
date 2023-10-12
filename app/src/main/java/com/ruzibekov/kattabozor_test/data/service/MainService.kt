package com.ruzibekov.kattabozor_test.data.service

import com.ruzibekov.kattabozor_test.data.model.OfferBaseResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainService {

    @GET("offers")
    fun getOffers(): Response<OfferBaseResponse>
}