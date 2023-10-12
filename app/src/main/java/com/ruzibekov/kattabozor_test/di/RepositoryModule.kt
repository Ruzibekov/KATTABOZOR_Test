package com.ruzibekov.kattabozor_test.di

import com.ruzibekov.kattabozor_test.domain.repository.IOffersRepository
import com.ruzibekov.kattabozor_test.domain.repository.OffersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bind(repository: OffersRepository): IOffersRepository
}