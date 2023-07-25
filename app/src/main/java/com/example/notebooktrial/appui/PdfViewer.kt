package com.example.notebooktrial.appui

import android.util.Log
import android.view.View
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notebooktrial.R
import com.github.barteksc.pdfviewer.PDFView

import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import kotlinx.coroutines.flow.update

// PDf view Composable

@Composable
fun PdfDocViewer(
    fileName: String,
    pdfViewModel: PdfViewModel = viewModel()
) {
    pdfViewModel.PdfViewer(fileName)

}
