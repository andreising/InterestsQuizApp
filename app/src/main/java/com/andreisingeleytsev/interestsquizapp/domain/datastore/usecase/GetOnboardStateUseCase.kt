package com.andreisingeleytsev.interestsquizapp.domain.datastore.usecase

import com.andreisingeleytsev.interestsquizapp.domain.datastore.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOnboardStateUseCase @Inject constructor(
    private val repository: DataStoreRepository
) {
    suspend operator fun invoke(): Flow<Boolean>{
        return repository.getState()
    }
}