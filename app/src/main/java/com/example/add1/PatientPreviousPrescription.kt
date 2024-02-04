package com.example.add1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun User_prescriptions() {

    val ktorClient = KtorClient()


    var patH by remember {
        mutableStateOf<HPatient?>(null)
    }

    var toke = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkMjBjNjMwODJmMWE1MjFiYzRjOWEiLCJpYXQiOjE3MDY5NDA2NDUsImV4cCI6MTcwNjk0NDI0NX0.2pjbbJBzVPej60b-XYzHt8YTE0lNeVix-9Y84VR6jkw"

    LaunchedEffect(key1 = Unit) {

        patH = ktorClient.getHPatient("home", toke.toString())

    }

    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )



    Image(
        painter = painterResource(id = R.drawable.minbg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )



    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFF9C9F)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Text(
            text = "Prescriptions",
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.offset(y = 30.dp)
        )

        Box (modifier = Modifier.offset(y = 0.dp),
            contentAlignment = Alignment.Center){
            Image(
                painter = painterResource(id = R.drawable.drectangle),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            var re = listOf(1,2,3)
            Text("Doctor name: ${patH?.doctorName}",modifier = Modifier.offset(y = -280.dp))

            LazyColumn {
                patH?.let {
                    items(it.Medicines){ med ->
                        Text(text = "Medicine Name: ${med.Medicine_name}")
                        Text(text = "mg: ${med.mg}")
                        Text(text = "quantity: ${med.quantity}")

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }

    }

}