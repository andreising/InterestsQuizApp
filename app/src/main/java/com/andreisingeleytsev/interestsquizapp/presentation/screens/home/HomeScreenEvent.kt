package com.andreisingeleytsev.interestsquizapp.presentation.screens.home

sealed class HomeScreenEvent{
    data class OnCategoryPressed(val index: Int): HomeScreenEvent()
}
