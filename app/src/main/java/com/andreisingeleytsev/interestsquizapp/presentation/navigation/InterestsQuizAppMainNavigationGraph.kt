package com.andreisingeleytsev.interestsquizapp.presentation.navigation


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.interestsquizapp.InterestsQuizApp
import com.andreisingeleytsev.interestsquizapp.presentation.screens.home.HomeScreen
import com.andreisingeleytsev.interestsquizapp.presentation.screens.onboard.OnBoardScreen
import com.andreisingeleytsev.interestsquizapp.presentation.screens.quiz.QuizScreen
import com.andreisingeleytsev.interestsquizapp.presentation.utils.Routes



@Composable
fun InterestsQuizAppMainNavigationGraph(
    navHostController:NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navHostController, startDestination = startDestination,
        modifier = Modifier.background(Color.Transparent)
    ) {
        composable(Routes.ONBOARDING_SCREEN) {
            OnBoardScreen(navHostController = navHostController)
        }
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navHostController = navHostController)
        }
        composable(Routes.QUIZ_SCREEN) {
            QuizScreen()
        }
    }
}
