package com.example.notebooktrial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UnitsList(
    units: List<CourseUnit>,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
    )
    {
        items(
            units,
            key = { it.unitName },


        ){unit ->
            OptionItem(
                itemName = unit.unitName,
                onItemClicked = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Unit() {

//    var courses = getUnits(DataManager.courses)
    CoursesList(DataManager.courses, courseClicked = {})
}