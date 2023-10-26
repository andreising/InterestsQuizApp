package com.andreisingeleytsev.interestsquizapp.domain.quiz.repository

import com.andreisingeleytsev.interestsquizapp.domain.quiz.model.QuestionItem


interface QuizRepository {
    suspend fun choseCategory(index: Int)
    suspend fun getQuestion(): QuestionItem
}