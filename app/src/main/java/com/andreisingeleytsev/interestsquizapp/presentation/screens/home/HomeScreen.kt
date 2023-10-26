package com.andreisingeleytsev.interestsquizapp.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.andreisingeleytsev.interestsquizapp.R
import com.andreisingeleytsev.interestsquizapp.domain.quiz.model.QuizCategory
import com.andreisingeleytsev.interestsquizapp.presentation.utils.UIEvents

@Composable
fun HomeScreen(navHostController: NavHostController) {

    val viewModel: HomeScreenViewModel = hiltViewModel()
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
        LazyColumn(modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)) {
            items(viewModel.categoryList.value) {
                HomeScreenItem(index = it) {
                    viewModel.onEvent(HomeScreenEvent.OnCategoryPressed(it))
                }
            }
        }
    }
}

@Composable
fun HomeScreenItem(index: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(vertical = 6.dp)
            .fillMaxWidth()
            .clickable {
                onClick.invoke()
            },
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(Modifier.padding(5.dp)) {
            Text(
                text = when (index) {
                    0 -> QuizCategory.Art.title
                    1 -> QuizCategory.Science.title
                    2 -> QuizCategory.Biology.title
                    3 -> QuizCategory.History.title
                    4 -> QuizCategory.Language.title
                    5 -> QuizCategory.Math.title
                    else -> QuizCategory.Art.title
                }, style = TextStyle(
                    fontWeight = FontWeight.Bold, fontSize = 12.sp
                )
            )
            Text(
                text = ((index + 1) * 10).toString() + " min",
                color = Color.Gray,
                fontSize = 10.sp
            )
        }
    }
}