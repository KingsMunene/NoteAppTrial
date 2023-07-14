package com.example.notebooktrial.appui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notebooktrial.data.Course
import com.example.notebooktrial.data.DataManager

@Composable
fun CoursesList(
    courses: List<Course>,
    courseClicked: (String) -> Unit
    ) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
    )
    {
        items(
            courses,
            key = { it.courseName }

            ){course ->
            OptionItem(
                itemName = course.courseName,
                onItemClicked = {courseClicked(course.courseName)}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoursesListPrev() {

//    var courses = getUnits(DataManager.courses)
    CoursesList(DataManager.courses, courseClicked = {})
}

// get units as per course
