package com.ruzibekov.kattabozor_test.domain.repository

import com.ruzibekov.kattabozor_test.data.model.OfferBaseResponse
import kotlinx.coroutines.flow.Flow

interface IOffersRepository {

    fun getOffers(): Flow<Result<OfferBaseResponse>>
}