package com.aac.barcos.di

import android.app.Application
import androidx.room.Room
import com.aac.barcos.data.local.NauticaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
/*
    @Provides
    @Singleton
    fun provideStockApi(): StockApi {
        return Retrofit.Builder()
            .baseUrl(StockApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }).build())
            .build()
            .create()
    }

 */

    @Provides
    @Singleton
    fun provideNauticaDatabase(app: Application): NauticaDatabase {
        return Room.databaseBuilder(
            app,
            NauticaDatabase::class.java,
            "nauticadb.db"
        ).build()
    }
}