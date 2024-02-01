package com.example.musictherapy.di

import com.example.musictherapy.data.repository.AuthRepositoryImpl
import com.example.musictherapy.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun firebaseBuilder() : FirebaseAuth = FirebaseAuth.getInstance()

    @Singleton
    @Provides
    fun provideFirebase(impl: AuthRepositoryImpl) : AuthRepository = impl


}