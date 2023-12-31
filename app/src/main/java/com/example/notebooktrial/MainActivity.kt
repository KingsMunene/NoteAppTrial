package com.example.notebooktrial

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.notebooktrial.appui.CoursesList
import com.example.notebooktrial.appui.NoteBookViewModel
import com.example.notebooktrial.appui.PdfDocViewer
import com.example.notebooktrial.appui.UnitsList

import com.example.notebooktrial.ui.theme.NoteBookTrialTheme
import kotlinx.coroutines.delay

enum class Screen(){
    Start,
    Units,
    Pdfviewer,
    Splash
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteBookTrialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}



@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    noteBookViewModel: NoteBookViewModel = viewModel()
)
{

    val appViewModel = noteBookViewModel._uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.name,
        modifier = Modifier
    ){
        composable(Screen.Start.name){
            CoursesList(
                appViewModel.value.courses,
                courseClicked = {
                        courseName -> noteBookViewModel.units = noteBookViewModel.getUnits(courseName)
                        navController.navigate(Screen.Units.name)
                }
            )
        }

        // Composable to display the list of units
        composable(Screen.Units.name){
            UnitsList(
                units = noteBookViewModel.units,
                onUnitClicked = {
                        fileName -> noteBookViewModel.fileName = fileName
                    navController.navigate(Screen.Pdfviewer.name)
                }
            )
        }

        // Composable to display the Pdf files
        composable(Screen.Pdfviewer.name){
            PdfDocViewer(noteBookViewModel.fileName)
        }

        //Splash Screen composable
        composable(Screen.Splash.name){
            SplashScreen { navController.navigate(Screen.Start.name) }
        }
    }

}


@Composable
fun SplashScreen(navigate: () -> Unit) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.v2))

    // Get the progress of the animation
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = 1
    )

    // If the animation completes playing navigate to the next screen
    Column {
        LaunchedEffect(key1 = progress) {
            if (progress == 1f) run {
                navigate()
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()

        ) {
            LottieAnimation(
                composition = composition,
                progress = { progress }
            )

        }

        Text(
            text = "Comrade Buddy",
            style = MaterialTheme.typography.titleLarge
        )
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteBookTrialTheme {
        HomeScreen()
    }
}