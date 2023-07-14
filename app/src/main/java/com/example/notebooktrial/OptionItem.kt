package com.example.notebooktrial

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notebooktrial.ui.theme.NoteBookTrialTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionItem(itemName: String, onItemClicked: () -> Unit) {

    Card(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        onClick = {onItemClicked}

    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
        ){
            Text(
                text = itemName,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OptionsPrev() {
    NoteBookTrialTheme() {
        OptionItem("Information Technology", onItemClicked = {})
    }
}