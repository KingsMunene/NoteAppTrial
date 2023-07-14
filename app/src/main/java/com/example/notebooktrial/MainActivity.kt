package com.example.notebooktrial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    NoteBookViewModel: NoteBookViewModel = viewModel()
)
{

    var units by remember{mutableStateOf(ArrayList<CourseUnit>())}
    NavHost(
        navController = navController,
        startDestination = Screen.Start.name,
        modifier = Modifier
    ){
        composable(Screen.Start.name){
            CoursesList(DataManager.courses, courseClicked = {courseName ->  })
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