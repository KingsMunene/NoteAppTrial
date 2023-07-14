package com.example.notebooktrial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notebooktrial.appui.CoursesList
import com.example.notebooktrial.appui.NoteBookViewModel
import com.example.notebooktrial.appui.UnitsList

import com.example.notebooktrial.ui.theme.NoteBookTrialTheme

enum class Screen(){
    Start,
    Units
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
        startDestination = Screen.Start.name,
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

        composable(Screen.Units.name){
            UnitsList(
                units = noteBookViewModel.units,
                onUnitClicked = {fileName -> }
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteBookTrialTheme {
        HomeScreen()
    }
}