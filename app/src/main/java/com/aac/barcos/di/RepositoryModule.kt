package com.aac.barcos.di

import com.aac.barcos.data.repository.NauticaRepositoryImpl
import com.aac.barcos.domain.NauticaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
/*
    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindIntradayInfoParser(
        intradayInfoParser: IntradayInfoParser
    ): CSVParser<IntradayInfo>

 */
    @Binds
    @Singleton
    abstract fun bindNauticaRepository(
        stockRepositoryImpl: NauticaRepositoryImpl
    ): NauticaRepository

}