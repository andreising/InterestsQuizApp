package com.andreisingeleytsev.interestsquizapp.presentation.screens.onboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.interestsquizapp.R
import com.andreisingeleytsev.interestsquizapp.domain.quiz.model.QuizCategory
import com.andreisingeleytsev.interestsquizapp.presentation.theme.Blue80
import com.andreisingeleytsev.interestsquizapp.presentation.utils.UIEvents

@Composable
fun OnBoardScreen(navHostController: NavHostController) {
    val viewModel: OnBoardScreenViewModel = hiltViewModel()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect {
            when (it) {
                is UIEvents.Navigate -> {
                    navHostController.navigate(it.route)
                }

                else -> {}
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Choose Your Interests", style = TextStyle(
                    color = Color.Black,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = "Select all that apply:", style = TextStyle(
                    color = Color.Black,
                    fontSize = 24.sp
                )
            )
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    for (i in 0 until 7) {
                        val color = remember {
                            mutableStateOf(Color.White)
                        }
                        OnBoardButton(index = i, color) {
                            if (i != 6) viewModel.onEvent(OnBoardScreenEvent.OnCategoryPressed(i))
                            else viewModel.onEvent(OnBoardScreenEvent.OnFinish)
                            color.value = if (color.value == Color.White) Blue80
                            else Color.White
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OnBoardButton(index: Int, color: MutableState<Color>, onClick: () -> Unit) {
    Button(
        onClick = { onClick.invoke() }, colors = ButtonDefaults.buttonColors(
            containerColor = if (index != 6) {
                color.value
            } else Blue80
        ), shape = RoundedCornerShape(24.dp)
    ) {
        Text(
            text = when (index) {
                0 -> QuizCategory.Art.title
                1 -> QuizCategory.Science.title
                2 -> QuizCategory.Biology.title
                3 -> QuizCategory.History.title
                4 -> QuizCategory.Language.title
                5 -> QuizCategory.Math.title
                6 -> "Get Started"
                else -> QuizCategory.Art.title
            }, style = TextStyle(
                color = if (index != 6) Color.Gray
                else Color.White, fontSize = 14.sp
            )
        )
    }
}