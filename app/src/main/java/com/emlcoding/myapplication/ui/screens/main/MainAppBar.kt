package com.emlcoding.myapplication.ui.screens.main

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun MainAppBar() {
    TopAppBar(
        title = {
            Text(text = "App de prueba")
        },
        actions = {
            AppBarAction(imageVector = Icons.Default.Search, onclick = { /* TODO */ })
            AppBarAction(imageVector = Icons.Default.Share, onclick = { /* TODO */ })
        }
    )
}

@Composable
private fun AppBarAction(
    imageVector: ImageVector,
    onclick: () -> Unit
) {
    IconButton(onClick = onclick) {
        Icon(imageVector = imageVector, contentDescription = null)
    }
}