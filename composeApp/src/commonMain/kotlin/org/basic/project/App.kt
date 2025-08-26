package org.basic.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmpbasico.composeapp.generated.resources.Res
import kmpbasico.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.MainScope

@Composable
fun App(){
    MaterialTheme {
        Navigator(
            screen = MainScreen()
        )


    }
}

class MainScreen : Screen {

    @Composable
    fun Content() {
        MaterialTheme {
            val navigator : Navigator = LocalNavigator.currentOrThrow
            var name: String by remember { mutableStateOf("") }
            var edad: String by remember { mutableStateOf("") }
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .safeContentPadding()
                    .fillMaxSize(),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = name,
                    onValueChange = {
                        name = it
                    }
                )

                Spacer(modifier = Modifier.height(40.dp))

                AnimatedVisibility(name.isNotEmpty()) {
                    Text(
                        text = "Version Animada $name",
                        fontSize = 20.sp
                    )

                }
                TextField(
                    value = edad,
                    onValueChange = {
                        edad = it
                    }
                )

                AnimatedVisibility(edad.isNotEmpty()) {
                    Text(
                        text = "Tu edad es: $edad",
                        fontSize = 20.sp
                    )
                }

                Button(
                    onClick = {
                        navigator.push(SecondScreen())
                    }
                ){
                    Text(
                        text = "¿Que hacemos?"
                    )
                }


                Button(
                    onClick = {
                        navigator.push(TerceraScreen())
                    }
                ){
                    Text(
                        text = "Acerca del Sitio"
                    )
                }
            }
        }
    }
}

class SecondScreen: Screen {

    val navigator : Navigator = LocalNavigator.ofCurrentThrow

    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Segunda pantalla",
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )

            Text(
                text = "Somos una compañia de seguros de autos",
                fontSize = 15.sp,
                color = Color.Gray
            )

            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text(
                    text = "Vamos para atrás"
                )
            }
        }
    }

}


class TerceraScreen: Screen {

    val navigator : Navigator = LocalNavigator.ofCurrentThrow

    @Composable
    override fun Content() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Tercera pantalla",
                fontSize = 20.sp,
                color = Color.Black
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )


            Text(
                text = "Tenemos a los mejores profecionales",
                fontSize = 20.sp,
                color = Color.Gray
            )

            Spacer(
                modifier = Modifier
                    .height(15.dp)
            )

            Button(
                onClick = {
                    navigator.pop()
                }
            ) {
                Text(
                    text = "Vamos para atrás"
                )
            }
        }
    }

}