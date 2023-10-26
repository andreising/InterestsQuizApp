package com.andreisingeleytsev.interestsquizapp.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andreisingeleytsev.interestsquizapp.presentation.navigation.InterestsQuizAppMainNavigationGraph
import com.andreisingeleytsev.interestsquizapp.presentation.theme.Blue80
import com.andreisingeleytsev.interestsquizapp.presentation.utils.Routes
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModel: MainViewModel

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel.startDestination.value?.let { startDestination ->
                val navHostController = rememberNavController()
                val backStackEntry by navHostController.currentBackStackEntryAsState()
                Scaffold(topBar = {
                    if (backStackEntry?.destination?.route != Routes.ONBOARDING_SCREEN) CenterAlignedTopAppBar(
                        title = {
                            Text(
                                text = when (backStackEntry?.destination?.route) {
                                    Routes.HOME_SCREEN -> "HOME"
                                    Routes.QUIZ_SCREEN -> "QUIZ"
                                    else -> ""
                                }, color = Blue80
                            )
                        },
                    )
                }) {
                    Box(modifier = Modifier.padding(it)) {
                        InterestsQuizAppMainNavigationGraph(
                            navHostController = navHostController,
                            startDestination = startDestination
                        )
                    }
                }
            }
        }
    }
}

