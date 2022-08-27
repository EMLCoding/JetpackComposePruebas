package com.emlcoding.myapplication.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.emlcoding.myapplication.model.MediaItem

@Composable
fun MainContent(onMediaClick: (MediaItem) -> Unit, modifier: Modifier = Modifier) {
    MediaList(
        onMediaClick = onMediaClick,
        modifier = modifier
    )
}