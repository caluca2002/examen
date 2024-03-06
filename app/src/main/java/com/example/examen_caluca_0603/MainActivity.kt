package com.example.examen_caluca_0603

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examen_caluca_0603.ui.theme.ExamenCaluca0603Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamenCaluca0603Theme {
                Pantallas()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Pantallas() {
    var estado = remember { mutableStateOf(false) }
    Scaffold {
        if (!estado.value) {
            PaginaInicio()
        } else {
            Greeting()
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Centered Top App Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    /*Icon(
                        painter = painterResource(R.drawable.baseline_directions_bus_24),
                        contentDescription = stringResource(id = R.string.bus_content_description)

                    )

                     */
                }
            )
        },
        content = { innerPadding ->
            Scroll()
        }
    )
}

@Composable
fun Scroll(modifier: Modifier = Modifier,
           names: List<String> = List(3) { "$it" }) {
    LazyColumn(modifier = modifier
        .padding(100.dp)
        .background(MaterialTheme.colorScheme.background)
        .fillMaxSize()
    ) {
        var filled = true
        items(items = names) { name ->
            Contenido(name = name)
        }
    }
}

@Composable
fun Contenido(name: String) {
    if ( name == "0") {
        Row {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "IMG",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.trespuntos),
                    contentDescription = "Puntos",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Text(
            text = "Elevated",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    } else if (name == "1") {
        Row {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "IMG",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.trespuntos),
                    contentDescription = "Puntos",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Text(
            text = "Elevated",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }else {
        Row {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "IMG",
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.trespuntos),
                    contentDescription = "Puntos",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Text(
            text = "Elevated",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun PaginaInicio() {
    var estado = remember { mutableStateOf(false) }
    var User by remember { mutableStateOf("Hello") }
    var Contra by remember { mutableStateOf("Hello") }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(50.dp)) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo basico",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }
        Column {
            Row(modifier = Modifier.padding(20.dp)) {
                TextField(
                    value = User,
                    onValueChange = { User = it },
                    label = { Text("Usuario") }
                )
            }
            Row(modifier = Modifier.padding(20.dp)) {
                TextField(
                    value = Contra,
                    onValueChange = { Contra = it },
                    label = { Text("Contraseña") }
                )
            }
        }
        ElevatedButton(
            onClick = { estado.value = !estado.value }
        ) {
            if (estado.value){
                Greeting()
            }
        }
    }
}








