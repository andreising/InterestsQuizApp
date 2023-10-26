package com.andreisingeleytsev.interestsquizapp.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.interestsquizapp.domain.datastore.usecase.GetFavouritesCategoryUseCase
import com.andreisingeleytsev.interestsquizapp.domain.quiz.usecase.ChoseCategoryUseCase
import com.andreisingeleytsev.interestsquizapp.presentation.screens.onboard.OnBoardScreenEvent
import com.andreisingeleytsev.interestsquizapp.presentation.utils.Routes
import com.andreisingeleytsev.interestsquizapp.presentation.utils.UIEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val choseCategoryUseCase: ChoseCategoryUseCase,
    private val getFavouritesCategoryUseCase: GetFavouritesCategoryUseCase
) : ViewModel() {
    private val _uiEvent = Channel<UIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.OnCategoryPressed -> {
                viewModelScope.launch {
                    choseCategoryUseCase.invoke(event.index)
                    sendUIEvent(UIEvents.Navigate(Routes.QUIZ_SCREEN))
                }
            }
        }
    }

    private fun sendUIEvent(event: UIEvents) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    private val _categoryList = mutableStateOf(listOf(0, 1, 2, 3, 4, 5))
    val categoryList: State<List<Int>> = _categoryList

    private fun generateCurrentList(list: List<Int>) {
        val result = mutableListOf<Int>()
        result.plus(list)
        listOf(0, 1, 2, 3, 4, 5).forEach {
            if (!result.contains(it)) result.add(it)
        }
    }

    init {
        viewModelScope.launch {
            getFavouritesCategoryUseCase.invoke().collect { list ->
                generateCurrentList(list)
            }
        }
    }
}