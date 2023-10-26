package com.andreisingeleytsev.interestsquizapp.domain.quiz.usecase

import com.andreisingeleytsev.interestsquizapp.domain.quiz.repository.QuizRepository
import javax.inject.Inject


class ChoseCategoryUseCase@Inject constructor(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke(index: Int){
        quizRepository.choseCategory(index)
    }
}