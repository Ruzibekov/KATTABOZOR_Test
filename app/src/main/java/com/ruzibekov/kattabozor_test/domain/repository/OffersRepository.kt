package com.ruzibekov.kattabozor_test.domain.repository

import com.ruzibekov.kattabozor_test.data.model.OfferBaseResponse
import com.ruzibekov.kattabozor_test.data.service.MainService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OffersRepository @Inject constructor(
    private val service: MainService
) : IOffersRepository {

    override fun getOffers(): Flow<Result<OfferBaseResponse>> {
        return flow {
            val response = service.getOffers()

            if (response.isSuccessful && response.body() != null)
                emit(Result.success(response.body()!!))
            else
                emit(Result.failure(Exception("Loading failed")))
        }
    }

}