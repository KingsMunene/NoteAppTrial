package com.example.notebooktrial.appui

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModel
import com.example.notebooktrial.R
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PdfViewModel: ViewModel() {

    //Data class to hold the document page number
    data class DocPage(val pageNumber: Int = 0)

    // State for the current page
    private var _uiState = MutableStateFlow(DocPage())


    //Backing state for the uiState
    val uiSate = _uiState.asStateFlow()


    // Function to update the current page of the document
    fun updateCurrentPage(page: Int){
        _uiState.update { it.copy(pageNumber = page)}
    }

}