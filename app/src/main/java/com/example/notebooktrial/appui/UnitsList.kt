package com.example.notebooktrial.appui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notebooktrial.data.CourseUnit
import com.example.notebooktrial.data.DataManager

@Composable
fun UnitsList(
    units: List<CourseUnit>,
    onUnitClicked: (String) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
    )
    {
        items(
            units
        ){unit ->
            OptionItem(
                itemName = unit.unitName,
                onItemClicked = {onUnitClicked(unit.fileName)}
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