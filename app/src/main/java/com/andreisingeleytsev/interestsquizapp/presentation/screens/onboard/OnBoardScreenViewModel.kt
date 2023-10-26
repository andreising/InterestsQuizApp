package com.andreisingeleytsev.interestsquizapp.presentation.screens.onboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.interestsquizapp.domain.datastore.usecase.OnBoardFinishUseCase
import com.andreisingeleytsev.interestsquizapp.presentation.utils.Routes
import com.andreisingeleytsev.interestsquizapp.presentation.utils.UIEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardScreenViewModel @Inject constructor(
    private val onBoardFinishUseCase: OnBoardFinishUseCase
) : ViewModel() {
    private val _uiEvent = Channel<UIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: OnBoardScreenEvent) {
        when (event) {
            is OnBoardScreenEvent.OnCategoryPressed -> {
                val item = event.index
                if (indexList.contains(item)) indexList.remove(item)
                else indexList.add(item)
            }

            is OnBoardScreenEvent.OnFinish -> {
                viewModelScope.launch {
                    onBoardFinishUseCase.invoke(indexList)
                }
                sendUIEvent(UIEvents.Navigate(Routes.HOME_SCREEN))
            }
        }
    }

    private fun sendUIEvent(event: UIEvents) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    private val indexList = mutableListOf<Int>()

}