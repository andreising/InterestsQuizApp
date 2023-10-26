package com.andreisingeleytsev.interestsquizapp.domain.datastore.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun getFavouritesCategories(): Flow<List<Int>>
    suspend fun onBoardFinish(list: List<Int>)
    suspend fun getState(): Flow<Boolean>
}