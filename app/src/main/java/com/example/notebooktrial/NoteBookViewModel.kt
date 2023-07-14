package com.example.notebooktrial

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NoteBookViewModel : ViewModel(){
    // uiState mutable state
    private var uiState = MutableStateFlow(DataManager)

    // Backing property

    val _uiState = uiState.asStateFlow()


    /** Function to get units for a specific course
     * It receives a course name and uses it to get a list of units associated to that
     * course
     * **/
    fun getUnits(course: String): List<CourseUnit> {
        var units: List<CourseUnit> = ArrayList()

        DataManager.courses.forEach {

            if (it.courseName == course){
                units = it.units
            }
        }
        return units

    }


}