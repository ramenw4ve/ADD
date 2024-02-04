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
import android.util.Base64
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.asImageBitmap



@Composable
fun PatViewQR() {

    val ktorClient = KtorClient()
    val base64String = "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"
    val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)

    var patH by remember {
        mutableStateOf<HPatient?>(null)
    }

    var toke = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkMjBjNjMwODJmMWE1MjFiYzRjOWEiLCJpYXQiOjE3MDY5NDUzNjksImV4cCI6MTcwNjk0ODk2OX0.YjVx5aMrL8SzWaim4zD_o5rYADj5aGXJRC2vNmGYc1w"

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

    val bitmap = BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    val imageBitmap = bitmap.asImageBitmap()


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

            Image(
                bitmap = imageBitmap,
                contentDescription = "Image from Base64",
                 modifier = Modifier.size(200.dp).offset(y = -100.dp)
            )

            LazyColumn(modifier  = Modifier.offset(y = 80.dp)) {
                patH?.let {
                    items(it.Medicines){ med ->
                        Text(text = "Medicine Name: ${med.Medicine_name}")
                        Text(text = "mg: ${med.mg}")
                        Text(text = "quantit: ${med.quantity}")

                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }

    }

}