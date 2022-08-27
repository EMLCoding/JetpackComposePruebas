package com.emlcoding.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.emlcoding.myapplication.ui.navigation.Navigation
import com.emlcoding.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Este es el punto de arranque de toda la UI
        setContent {
            Navigation()
        }
    }
}




// Todos los elementos de UI deben llevar el @Composable. Las funciones de @Composable deben empezar con mayus
// La forma correcta de pasar modificadores visuales a un @Composable es a través de un parámetro Modifier
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}



// -------------- PRUEBAS ----------


@Preview(
    showBackground = true,
    name = "Android Greeting",
    widthDp = 400,
    heightDp = 200
)
@Composable
fun PruebasPreview() {
    MyApplicationTheme {
        // El Box por defecto se ajusta al tamaño de los elementos que tiene dentro. Con el modifier se cambian los valores del elemento
        /*
        Box(
            modifier = Modifier.fillMaxSize().background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Greeting("Android")
            Greeting(name = "Androids", modifier = Modifier.align(Alignment.BottomEnd))
        }
         */
        // verticalArrangmente permite configurar como se van a organizar los elementos en una columna en funcion del tamaño disponible
        /*
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Con el weight se establece la prioridad que tiene cada elemento a la hora de ocupar el espacio disponible
            Greeting(name = "Edu",
                modifier = Modifier.background(Color.Red).weight(2f))
            Greeting(name = "Android",
                modifier = Modifier.background(Color.Blue).weight(1f))
            Greeting(name = "Edu",
                modifier = Modifier.background(Color.Red).weight(3f))
        }
         */
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Con el weight se establece la prioridad que tiene cada elemento a la hora de ocupar el espacio disponible
            Greeting(
                name = "Edu",
                modifier = Modifier
                    .background(Color.Red)
                    .weight(2f)
            )
            Greeting(
                name = "Android",
                modifier = Modifier
                    .background(Color.Blue)
                    .weight(1f)
            )
            Greeting(
                name = "Edu",
                modifier = Modifier
                    .background(Color.Red)
                    .weight(3f)
            )
        }
    }
}

@Composable
fun StateSample(value: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(64.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = value, onValueChange = { onValueChange(it) }, modifier = Modifier.fillMaxWidth())
        Text(text = value, modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow)
            .padding(8.dp))
        Button(onClick = { onValueChange("") }, modifier = Modifier.fillMaxWidth(), enabled = value.isNotEmpty()) {
            Text(text = "Clear")
        }
    }
}

//@Preview(showBackground = true, widthDp = 400, heightDp = 200)
@Composable
fun ButtonText() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "hola mundosssss",
            color = Color.Red,
            // Las fuentes se pueden utilizar "dp" o "sp". Lo recomendable es "sp" para que este texto cuando el usuario tenga el texto más grande en el movil se ajuste solo
            /*fontSize = 25.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold*/
            /*fontFamily = FontFamily.Monospace,
            letterSpacing = 5.sp,
            textDecoration = TextDecoration.LineThrough*/
            textAlign = TextAlign.Justify,
            // em es la medida habitual para el lineHeight. 1em = la altura de una letra
            lineHeight = 2.em,
            maxLines = 1,
            // Por defecto el softWrap esta a true para que cuando no quepa todo el texto no corte una palabra a la mitad
            softWrap = false,
            // Para añadir los ... cuando no cabe el texto
            overflow = TextOverflow.Ellipsis,
            // style sirve para agrupar todos los estilos puestos antes y algunos mas
            //style = MaterialTheme.typography.h4
            // Se puede modificar un estilo ya establecido con el metodo "copy()"
            style = MaterialTheme.typography.h4.copy(
                shadow = Shadow(
                    offset = Offset(5f, 5f),
                    blurRadius = 5f
                )
            )
            /*modifier = Modifier
                .clickable { *//* TODO *//* }
                .background(Color.Cyan)
                .border(width = 2.dp, color = Color.Blue)
                .padding(horizontal = 16.dp, vertical = 8.dp)*/

        )
    }


}