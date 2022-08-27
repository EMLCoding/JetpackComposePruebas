package com.emlcoding.myapplication.ui.screens.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.emlcoding.myapplication.model.MediaItem
import com.emlcoding.myapplication.ui.screens.common.Thumb

@Composable
fun DetailContent(item: MediaItem, modifier: Modifier = Modifier) {
    Thumb(item = item, modifier = modifier)
}