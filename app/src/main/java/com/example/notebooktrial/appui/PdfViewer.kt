package com.example.notebooktrial.appui

import android.view.View
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.notebooktrial.R
import com.github.barteksc.pdfviewer.PDFView

@Composable
fun PdfDocViewer(fileName: String) {
    AndroidView(
        factory = {
            View.inflate(it, R.layout.pdf_viewer, null)
        },
        update = {
            val pdfViewer = it.findViewById<PDFView>(R.id.pdfViewer)
            pdfViewer.fromAsset(fileName).enableSwipe(true).load()
        },
        modifier = Modifier.fillMaxSize()
    )
}