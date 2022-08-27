package com.emlcoding.myapplication.ui.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import coil.compose.AsyncImage
import com.emlcoding.myapplication.R
import com.emlcoding.myapplication.model.MediaItem


@Composable
fun Thumb(item: MediaItem, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // contentDescription es para temas de accesibilidad, para que la imagen tenga un mensaje asociado
        AsyncImage(
            model = item.thumb,
            /*model = ImageRequest.Builder(LocalContext.current)
                .data("https://loremflickr.com/400/400/cat?lock=1")
                .transformations(CircleCropTransformation())
                .crossfade(true) // Hace un efecto cuando se navega a la pantalla. Si directamente carga esta pantalla no se ve el efecto
                .build(),*/
            contentDescription = null,
            // Este modifier tambien permite encuadrar la imagen en un circulo o en un rectangulo con curvas
            //modifier = Modifier.clip(RoundedCornerShape(4.dp))
            modifier = Modifier.fillMaxSize(),
            // Estira la imagen lo necesario sin perder el aspect ratio. Lo que no entre en el tamaño no se pinta
            contentScale = ContentScale.Crop
        )

        if (item.type == MediaItem.Type.VIDEO) {
            Icon(
                imageVector= Icons.Default.PlayCircleOutline,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.cell_play_icon_size))
                    .align(Alignment.Center)
            )
        }

        // Un icono que coge una imagen del proyecto
        /*Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            tint = Color.Green
        )*/
    }
}