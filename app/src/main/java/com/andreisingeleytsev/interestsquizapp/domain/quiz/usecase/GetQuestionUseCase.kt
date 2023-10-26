package com.andreisingeleytsev.interestsquizapp.domain.quiz.usecase

import com.andreisingeleytsev.interestsquizapp.domain.quiz.model.QuestionItem
import com.andreisingeleytsev.interestsquizapp.domain.quiz.repository.QuizRepository
import javax.inject.Inject

class GetQuestionUseCase@Inject constructor(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke(): QuestionItem {
        return quizRepository.getQuestion()
    }
}