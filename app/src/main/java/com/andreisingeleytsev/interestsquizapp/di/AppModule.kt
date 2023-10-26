package com.andreisingeleytsev.interestsquizapp.di

import android.content.Context
import com.andreisingeleytsev.interestsquizapp.data.datastore.repository.DataStoreRepositoryImpl
import com.andreisingeleytsev.interestsquizapp.data.quiz.repository.QuizManager
import com.andreisingeleytsev.interestsquizapp.domain.datastore.repository.DataStoreRepository
import com.andreisingeleytsev.interestsquizapp.domain.quiz.repository.QuizRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDataStoreRepository(@ApplicationContext context: Context): DataStoreRepository{
        return DataStoreRepositoryImpl(context)
    }

    @Provides
    @Singleton
    fun provideQuizRepository(): QuizRepository{
        return QuizManager()
    }

}