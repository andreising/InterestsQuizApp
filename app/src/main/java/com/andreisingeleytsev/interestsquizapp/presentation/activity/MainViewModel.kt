package com.andreisingeleytsev.interestsquizapp.presentation.activity

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andreisingeleytsev.interestsquizapp.domain.datastore.usecase.GetOnboardStateUseCase
import com.andreisingeleytsev.interestsquizapp.presentation.utils.Routes
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val getOnboardStateRepositoryUseCase: GetOnboardStateUseCase
): ViewModel() {


    private val _startDestination: MutableState<String?> = mutableStateOf(null)
    val startDestination: State<String?> = _startDestination

    init {
        viewModelScope.launch {
            getOnboardStateRepositoryUseCase.invoke().collect{completed ->
                if (completed) {
                    _startDestination.value = Routes.HOME_SCREEN
                } else {
                    _startDestination.value = Routes.ONBOARDING_SCREEN
                }
            }
        }
    }
}