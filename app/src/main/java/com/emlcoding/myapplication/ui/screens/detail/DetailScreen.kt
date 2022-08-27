package com.emlcoding.myapplication.ui.screens.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.emlcoding.myapplication.model.getMedia
import com.emlcoding.myapplication.ui.screens.common.ArrowBackIcon
import com.emlcoding.myapplication.R
import com.emlcoding.myapplication.ui.screens.common.Thumb

@Composable
fun DetailScreen(mediaId: Int, onUpClick: () -> Unit) {
    val mediaItem = remember { getMedia().first { it.id == mediaId }}

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = mediaItem.title) },
                navigationIcon = { ArrowBackIcon(onUpClick) }
            )
        }
    ) { padding ->
        DetailContent(
            item = mediaItem,
            modifier = Modifier
                .padding(padding)
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.cell_thumb_height))
        )
    }
}