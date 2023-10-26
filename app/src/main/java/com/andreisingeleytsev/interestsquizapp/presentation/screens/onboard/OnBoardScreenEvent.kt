package com.andreisingeleytsev.interestsquizapp.presentation.screens.onboard

sealed class OnBoardScreenEvent{
    data object OnFinish: OnBoardScreenEvent()
    data class OnCategoryPressed(val index: Int): OnBoardScreenEvent()
}
