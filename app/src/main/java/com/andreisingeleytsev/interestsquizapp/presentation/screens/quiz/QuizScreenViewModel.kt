package com.andreisingeleytsev.interestsquizapp.presentation.screens.quiz

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.interestsquizapp.domain.quiz.model.QuestionItem
import com.andreisingeleytsev.interestsquizapp.domain.quiz.model.QuizCategory
import com.andreisingeleytsev.interestsquizapp.domain.quiz.usecase.ChoseCategoryUseCase
import com.andreisingeleytsev.interestsquizapp.domain.quiz.usecase.GetQuestionUseCase
import com.andreisingeleytsev.interestsquizapp.presentation.screens.onboard.OnBoardScreenEvent
import com.andreisingeleytsev.interestsquizapp.presentation.theme.Blue80
import com.andreisingeleytsev.interestsquizapp.presentation.utils.Routes
import com.andreisingeleytsev.interestsquizapp.presentation.utils.UIEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizScreenViewModel @Inject constructor(
    private val getQuestionUseCase: GetQuestionUseCase,
    private val choseCategoryUseCase: ChoseCategoryUseCase
) : ViewModel() {
    private val _uiEvent = Channel<UIEvents>()
    val uiEvent = _uiEvent.receiveAsFlow()
    fun onEvent(event: QuizScreenEvent) {
        when (event) {
            is QuizScreenEvent.OnNext -> {
                if (index!=19) viewModelScope.launch {
                    getQuestion()
                    colors.forEach {
                        it.value = Blue80
                    }
                }
                else {
                    isQuiz.value = false
                    index = -1
                }
            }

            is QuizScreenEvent.OnChose -> {
                val index = event.answer
                colors[index].value =
                    if (_questionItem.value.answers[index] == currentAnswer) Color.Green
                    else Color.Red
            }

            is QuizScreenEvent.OnRestart -> {
                viewModelScope.launch {
                    getQuestion()
                }
                isQuiz.value = true
            }

            is QuizScreenEvent.OnNewQuiz -> {
                viewModelScope.launch {
                    choseCategoryUseCase.invoke((0..5).random())
                    getQuestion()
                }
                isQuiz.value = true
            }
        }
    }
    val isQuiz = mutableStateOf(true)
    private var index = -1
    val colors = listOf(
        mutableStateOf(Blue80),
        mutableStateOf(Blue80),
        mutableStateOf(Blue80),
        mutableStateOf(Blue80),
        mutableStateOf(Blue80)
    )

    private fun sendUIEvent(event: UIEvents) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    private var currentAnswer = ""
    private val _questionItem = mutableStateOf(QuizCategory.Art.list.first())
    val questionItem: State<QuestionItem> = _questionItem

    private suspend fun getQuestion() {
        index++
        val item = getQuestionUseCase.invoke()
        currentAnswer = item.answers.first()
        _questionItem.value = item.copy(answers = item.answers.shuffled())

    }

    init {
        viewModelScope.launch {
            getQuestion()
        }
    }
}