package com.andreisingeleytsev.interestsquizapp.presentation.screens.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.andreisingeleytsev.interestsquizapp.R
import com.andreisingeleytsev.interestsquizapp.presentation.theme.Blue80
import com.andreisingeleytsev.interestsquizapp.presentation.theme.Secondary

@Composable
fun QuizScreen() {
    val viewModel: QuizScreenViewModel = hiltViewModel()
    val questionItem = viewModel.questionItem.value
    if (viewModel.isQuiz.value) Column(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxSize()
    ) {
        Text(
            text = questionItem.question, style = TextStyle(
                color = Color.Black,
                fontSize = 22.sp
            )
        )
        Column {
            questionItem.answers.forEach { answer ->
                val index = questionItem.answers.indexOf(answer)
                AnswerItems(
                    string = answer,
                    color = viewModel.colors[index]
                ) {
                    viewModel.onEvent(QuizScreenEvent.OnChose(index))
                }
            }
        }
        Button(
            onClick = { viewModel.onEvent(QuizScreenEvent.OnNext) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue80
            )
        ) {
            Text(
                text = "Next", style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp
                )
            )
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Wow! Congratilations!")
            Image(
                painter = painterResource(id = R.drawable.finish),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Button(
                onClick = { viewModel.onEvent(QuizScreenEvent.OnNewQuiz) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue80
                )
            ) {
                Text(
                    text = "Next Quiz", style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
            Button(
                onClick = { viewModel.onEvent(QuizScreenEvent.OnRestart) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Secondary
                )
            ) {
                Text(
                    text = "Play Again", style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }
        }
    }
}

@Composable
fun AnswerItems(string: String, color: State<Color>, onClick: () -> Unit) {
    Text(text = string, color = color.value, fontSize = 16.sp, modifier = Modifier
        .padding(vertical = 16.dp)
        .fillMaxWidth()
        .clickable {
            onClick.invoke()
        })
}