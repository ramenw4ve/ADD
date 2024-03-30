package com.example.add1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.add1.graphs.activescreen

@Composable
fun User_prescriptions(navController: NavHostController,toke:String) {

    val ktorClient = KtorClient()


    var patH by remember {
        mutableStateOf<HPatient?>(null)
    }

//    var toke =
//        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkMjBjNjMwODJmMWE1MjFiYzRjOWEiLCJpYXQiOjE3MDcwNDM2MDksImV4cCI6MTcwNzA0NzIwOX0.PWxQEWRT1X0K1hIV1Li4IqmtBsyvQbmhXx80kY4Iur0"

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



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFF9C9F)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(
            text = "Prescriptions",
            color = Color.White,
            fontSize = 34.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.offset(y = 20.dp)
        )

        Box(
            modifier = Modifier.offset(y = 0.dp),
            contentAlignment = Alignment.Center
        )
        {

            Image(
                painter = painterResource(id = R.drawable.drectangle),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
//            var re = listOf(1, 2, 3)

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    "Doctor name: ${patH?.doctorName}",
                    fontSize = 24.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.offset(y = -150.dp)
                )

                LazyColumn {
                    patH?.let {
                        items(it.Medicines) { med ->
                            Text(
                                text = "Medicine Name: ${med.Medicine_name}",
                                fontSize = 18.sp,
                                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "mg: ${med.mg}",
                                fontSize = 18.sp,
                                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "quantity: ${med.quantity}",
                                fontSize = 18.sp,
                                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "Days: ${med.days}",
                                fontSize = 18.sp,
                                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "Time: ${med.time}",
                                fontSize = 18.sp,
                                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }

                }

                Button(
                    onClick = {

                    },
                    modifier = Modifier.offset(x = 0.dp, y = 170.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9C9F)),
                    shape = RoundedCornerShape(16.dp)
                )
                {
                    Text(text = "Pay Now",
                        modifier = Modifier.clickable {
                            navController.navigate(activescreen.viewcart.route)
                        })
                }
            }
        }

    }

}