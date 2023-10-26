package com.andreisingeleytsev.interestsquizapp.presentation.screens.quiz

sealed class QuizScreenEvent{
    data object OnNext: QuizScreenEvent()
    data object OnRestart: QuizScreenEvent()
    data object OnNewQuiz: QuizScreenEvent()
    data class OnChose(val answer: Int): QuizScreenEvent()
}
