package com.andreisingeleytsev.interestsquizapp.domain.datastore.usecase

import com.andreisingeleytsev.interestsquizapp.domain.datastore.repository.DataStoreRepository
import javax.inject.Inject


class OnBoardFinishUseCase @Inject constructor(
    private val repository: DataStoreRepository
) {
    suspend operator fun invoke(list: List<Int>){
        repository.onBoardFinish(list)
    }
}