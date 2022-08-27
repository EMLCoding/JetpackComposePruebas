package com.emlcoding.myapplication.ui.screens.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.emlcoding.myapplication.model.getMedia
import com.emlcoding.myapplication.ui.MyApplicationApp
import com.emlcoding.myapplication.ui.screens.detail.DetailContent

@Composable
fun MainDetailScreen() {
    var currentId by remember { mutableStateOf(1) }
    val mediaItem = getMedia().first { it.id == currentId }
    MyApplicationApp {
        Scaffold(
            topBar = { MainAppBar() }
        ) { padding ->
            Row(
                modifier = Modifier.padding(padding)
            ) {
                MainContent(
                    onMediaClick = { currentId = it.id},
                    modifier = Modifier.weight(1f)
                )

                DetailContent(
                    item = mediaItem,
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight()
                )
            }
        }
    }

}