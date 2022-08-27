package com.emlcoding.myapplication.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.emlcoding.myapplication.model.MediaItem
import com.emlcoding.myapplication.ui.MyApplicationApp

@Composable
fun MainScreen(onMediaClick: (MediaItem) -> Unit) {
    // Por defecto aqui pondra MyApplicationTheme, pero se extrae esa parte para que todos los @Composable puedan utilizar la misma configuracion de temas
    MyApplicationApp {
        /*// Para que se pueda repintar la pantalla por el cambio de valor de una propiedad hay que utilizar el mutableStateOf
        // rememberSaveable sirve para que no se ejecute la linea del text cada vez que se repinta la pantalla, ni cuando se rota la pantalla
        val (value, onValueChange) = rememberSaveable{ mutableStateOf("") }
        StateSample(
            value = value,
            onValueChange = onValueChange
        )*/
        Scaffold(
            topBar = {
                /*TopAppBar(
                                title = {
                                    Row {
                                        Text(text = "App de prueba")
                                        Spacer(modifier = Modifier.width(16.dp))
                                        Icon(Icons.Default.Android, contentDescription = null)
                                    }
                                })*/
                /*TopAppBar(
                                title = {
                                    Text(text = "App de prueba")
                                },
                                navigationIcon = {
                                    IconButton(onClick = { *//*TODO*//* }) {
                                            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                                        }
                                    }
                                )*/
                MainAppBar()
            }
        ) { padding ->
            MainContent(onMediaClick = onMediaClick, modifier = Modifier.padding(padding))
        }
    }

}