package uz.isystem.testproject.di.service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.isystem.testproject.data.network.FoodService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyService {

    @[Provides Singleton]
    fun provideHomeService(retrofit: Retrofit): FoodService {
        return retrofit.create(FoodService::class.java)
    }
}