package com.andreisingeleytsev.interestsquizapp.data.quiz.repository

import com.andreisingeleytsev.interestsquizapp.domain.quiz.model.QuestionItem
import com.andreisingeleytsev.interestsquizapp.domain.quiz.model.QuizCategory
import com.andreisingeleytsev.interestsquizapp.domain.quiz.repository.QuizRepository


class QuizManager: QuizRepository {
    private var currentCategory: QuizCategory = QuizCategory.Art
    private var count = 0
    override suspend fun choseCategory(index: Int) {
        currentCategory = categoryConverter(index)
    }

    override suspend fun getQuestion(): QuestionItem {
        val result = currentCategory.list[count]
        if (count==19) count=0
        else count++
        return result
    }

    private fun categoryConverter(index: Int): QuizCategory{
        return when(index){
            0 -> QuizCategory.Art
            1 -> QuizCategory.Science
            2 -> QuizCategory.Biology
            3 -> QuizCategory.History
            4 -> QuizCategory.Language
            5 -> QuizCategory.Math
            else -> QuizCategory.Art
        }
    }
}