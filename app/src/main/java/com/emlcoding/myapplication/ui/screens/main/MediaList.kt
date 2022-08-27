package com.emlcoding.myapplication.ui.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.emlcoding.myapplication.R
import com.emlcoding.myapplication.model.MediaItem
import com.emlcoding.myapplication.model.getMedia
import com.emlcoding.myapplication.ui.screens.common.Thumb


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MediaList(onMediaClick: (MediaItem) -> Unit, modifier: Modifier = Modifier) {
    // LazyVerticalGrid es todavia experimental
    LazyVerticalGrid(
        // Añade un padding de 4.dp a la lista
        contentPadding = PaddingValues(dimensionResource(R.dimen.padding_xsmall)),
        cells = GridCells.Adaptive(dimensionResource(R.dimen.cell_min_wedith)) // Mete tantos elementos en una fila como permita la pantalla permitiendo 150dp como tamaño minimo de cada elemento
        //verticalArrangement = Arrangement.spacedBy(10.dp) // Es para LazyColumn Añade un espacio entre cada elemento de la lista
        , modifier = modifier
    ) {
        items(getMedia()) { item ->
            MediaListItem(
                item = item,
                onClick = { onMediaClick(item) },
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_xsmall)))
        }
    }
}

@Composable
fun MediaListItem(
    item: MediaItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .clickable(onClick = onClick),
        elevation = 0.dp,
        border = BorderStroke(1.dp, Color.LightGray),
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.secondary // Esto cambia el color del contenido, en el caso de la App seria el titulo
    ) {
        Column {
            Thumb(
                item = item,
                modifier = modifier.height(dimensionResource(R.dimen.cell_thumb_height))
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    //.background(MaterialTheme.colors.secondary)
                    .padding(dimensionResource(R.dimen.padding_medium))
            ) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.h6
                )
            }

        }
    }
}
