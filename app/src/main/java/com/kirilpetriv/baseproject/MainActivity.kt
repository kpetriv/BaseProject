package com.kirilpetriv.baseproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.kirilpetriv.baseproject.ui.theme.BaseProject
import com.kirilpetriv.baseproject.uilayer.BaseScreenState
import com.kirilpetriv.baseproject.uilayer.BaseViewModel
import com.kirilpetriv.baseproject.uilayer.Loading
import com.kirilpetriv.baseproject.uilayer.LoadingIndicator
import com.kirilpetriv.baseproject.uilayer.Success
import com.kirilpetriv.baseproject.uilayer.toThumbnailUrl
import kotlinx.serialization.Serializable
import org.koin.android.ext.android.inject

private const val id = 285041801

@Serializable
data object BaseScreen

class MainActivity : ComponentActivity() {

    private val viewModel: BaseViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            BaseProject {
                val navHostController = rememberNavController()
                NavHost(
                    navController = navHostController,
                    startDestination = BaseScreen::class.java.simpleName,
                    popEnterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None },
                ) {
                    composable(BaseScreen::class.java.simpleName) {
                        BaseScreen(
                            viewModel = viewModel,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun BaseScreen(
    viewModel: BaseViewModel,
    modifier: Modifier = Modifier,
) {

    LaunchedEffect(Unit) { viewModel.fetchBaseModel(id) }

    Box(
        modifier = modifier
    ) {
        when (val carState = viewModel.state.collectAsState().value) {
            is BaseScreenState.Loading -> {
                Loading(modifier = Modifier.fillMaxSize())
            }

            is BaseScreenState.Success -> {
                Success(modifier = Modifier.systemBarsPadding(), state = carState)
            }

            is BaseScreenState.Error -> {
                // Show error
            }
        }
    }
}