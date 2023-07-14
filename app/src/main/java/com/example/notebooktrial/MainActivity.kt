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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
fun HomeScreen()
{



   // var courses = getUnits(DataManager.courses)

    Column() {

        CoursesList(DataManager.courses, courseClicked = {courseName ->  })
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteBookTrialTheme {
        HomeScreen()
    }
}