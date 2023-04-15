package com.example.proyecto25febrero.Screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.proyecto25febrero.navigation.Cartas
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@Composable
fun AddCartas(navController: NavHostController) {
    var NombreCarta by remember { mutableStateOf(("")) }
    var linkCarta by remember { mutableStateOf("") }
    var imageCarta by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)) {
            TextField(
                value = NombreCarta,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {NombreCarta = it},
                label = { Text(text = "Informacion de la carta")}
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = linkCarta,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {linkCarta = it},
                label = { Text(text = "Informacion con link de la wiki")}
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = imageCarta,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {imageCarta = it},
                label = { Text(text = "Agregue el URL de cualquier carta")}
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    val cartas = Cartas( imageCarta, NombreCarta , linkCarta)
                    Firebase.firestore.collection("cartas").add(cartas)
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            ){
                Text(text = "Añadir alumno")
            }
        }
    }

}

