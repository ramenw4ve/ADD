package com.example.add1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.add1.graphs.selfpscreen

//import com.example.add1.graphs.selfpscreen

@Composable
fun User_self_prescription(
    navController: NavHostController
) {
    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )
    var toke by remember {
        mutableStateOf<String>("")
    }
    var resp by remember {
        mutableStateOf<String>("")
    }
    val ktorClient = KtorClient()

    var shouldprescribe by remember {
        mutableStateOf(false)
    }
//    var am: AMedicines? = null

    val medicine1 = Talbet(
        name = "Gelusil MPS",
        mg = "600",
        price = "24",
        quantity = remember { mutableStateOf(0) },
        totalprice = remember { mutableStateOf(0) }
    )

    val medicine2 = Talbet(
        name = "Okacet",
        mg = "10",
        price = "22",
        quantity = remember { mutableStateOf(0) },
        totalprice = remember { mutableStateOf(0) }
    )

    val medicine3 = Talbet(
        name = "Dolo 650",
        mg = "650",
        price = "31",
        quantity = remember { mutableStateOf(0) },
        totalprice = remember { mutableStateOf(0) }
    )

    val medicine4 = Talbet(
        name = "Saridon",
        mg = "550",
        price = "25",
        quantity = remember { mutableStateOf(0)},
        totalprice = remember { mutableStateOf(0) }
    )

    val medicine5 = Talbet(
        name = "Zincovit",
        mg = "25",
        price = "110",
        quantity = remember { mutableStateOf(0) },
        totalprice = remember { mutableStateOf(0) }
    )

    val meds = listOf(medicine1, medicine2, medicine3, medicine4, medicine5)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFF9C9F)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.self_prescription_top_design),
            contentDescription = null,
            modifier = Modifier.align(Alignment.End)
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(size = 40.dp))
                .background(Color.White),
            contentAlignment = Alignment.TopCenter


        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.offset(y = 0.dp)
            )
            {
                Row(
                    modifier = Modifier
                        .offset(x = 30.dp)
                        .padding(top = 35.dp)
                )
                {
                    Text(
                        text = medicine1.name,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .offset(x = 0.dp)
                            .weight(0.5f)

                    )
                    Text(text = medicine1.price)
                    Row(
                        modifier = Modifier
                            .weight(0.5f)

                            .offset(x = 50.dp)
                    )
                    {
                        Text(
                            text = "-",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    medicine1.quantity.value -= 1
                                }
                                .border(BorderStroke((1.5).dp, Color.Gray))
                                .padding(5.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = medicine1.quantity.value.toString(),
                            fontSize = 25.sp
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "+",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    medicine1.quantity.value += 1
                                }
                                .border(BorderStroke((1.5).dp, Color.Gray))
                                .padding(5.dp)
                        )
                        medicine1.totalprice.value = medicine1.price.toInt() * medicine1.quantity.value
                        Text(text = medicine1.totalprice.value.toString())
                    }


                }


                Spacer(modifier = Modifier.height(30.dp))


                Row(modifier = Modifier.offset(x = 30.dp))
                {
                    Text(
                        text = medicine2.name,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .offset(x = 0.dp)
                            .weight(0.5f)

                    )
                    Row(
                        modifier = Modifier
                            .weight(0.5f)

                            .offset(x = 50.dp)
                    )
                    {
                        Text(
                            text = "-",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    medicine2.quantity.value -= 1
                                }
                                .border(BorderStroke((1.5).dp, Color.Gray))
                                .padding(5.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = medicine2.quantity.value.toString(),
                            fontSize = 25.sp
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "+",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    medicine2.quantity.value += 1
                                }
                                .border(BorderStroke((1.5).dp, Color.Gray))
                                .padding(5.dp)
                        )
                    }


                }


                Spacer(modifier = Modifier.height(30.dp))



                Row(modifier = Modifier.offset(x = 30.dp))
                {
                    Text(
                        text = medicine3.name,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .offset(x = 0.dp)
                            .weight(0.5f)

                    )
                    Row(
                        modifier = Modifier
                            .weight(0.5f)

                            .offset(x = 50.dp)
                    )
                    {
                        Text(
                            text = "-",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    medicine3.quantity.value -= 1
                                }
                                .border(BorderStroke((1.5).dp, Color.Gray))
                                .padding(5.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = medicine3.quantity.value.toString(),
                            fontSize = 25.sp
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "+",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    medicine3.quantity.value += 1
                                }
                                .border(BorderStroke((1.5).dp, Color.Gray))
                                .padding(5.dp)
                        )
                    }


                }


                Spacer(modifier = Modifier.height(30.dp))


                Row(modifier = Modifier.offset(x = 30.dp))
                {
                    Text(
                        text = medicine4.name,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .offset(x = 0.dp)
                            .weight(0.5f)

                    )
                    Row(
                        modifier = Modifier
                            .weight(0.5f)

                            .offset(x = 50.dp)
                    )
                    {
                        Text(
                            text = "-",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    medicine4.quantity.value -= 1
                                }
                                .border(BorderStroke((1.5).dp, Color.Gray))
                                .padding(5.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = medicine4.quantity.value.toString(),
                            fontSize = 25.sp
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "+",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    medicine4.quantity.value += 1
                                }
                                .border(BorderStroke((1.5).dp, Color.Gray))
                                .padding(5.dp)
                        )
                    }


                }


                Spacer(modifier = Modifier.height(30.dp))

                Row(modifier = Modifier.offset(x = 30.dp))
                {
                    Text(
                        text = medicine5.name,
                        fontSize = 22.sp,
                        modifier = Modifier
                            .offset(x = 0.dp)
                            .weight(0.5f)

                    )
                    Row(
                        modifier = Modifier
                            .weight(0.5f)

                            .offset(x = 50.dp)
                    )
                    {
                        Text(
                            text = "-",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    medicine5.quantity.value -= 1
                                }
                                .border(BorderStroke((1.5).dp, Color.Gray))
                                .padding(5.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = medicine5.quantity.value.toString(),
                            fontSize = 25.sp
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = "+",
                            fontSize = 20.sp,
                            modifier = Modifier
                                .clickable {
                                    medicine5.quantity.value += 1
                                }
                                .border(BorderStroke((1.5).dp, Color.Gray))
                                .padding(5.dp)
                        )
                    }


                }

                Spacer(modifier = Modifier.height(30.dp))
//            val counts = listOf(m1,m2,m3,m4,m5)

                val h = mutableListOf<Talbet>()
                for (i in meds) {
                    if (i.quantity.value != 0) {
                        h.add(i)

                    }
                }
                var tablist = h.toList()

                Button(
                    onClick =
                    {

                        shouldprescribe = true



                    }) {
                    Text(text = "Click me")
                }

                LaunchedEffect(key1 = shouldprescribe) {

                    val medicineList = h.map {
                        Medicine(
                            name = it.name,
                            mg = it.mg,
                            quantity = it.quantity.value.toString()
                        )
                    }

                    val am = AMedicines(medicineList)

                    if (shouldprescribe) {
                        toke =
                            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWMxZGNmYzA1NDAzMjZmMmM3YzdmMDMiLCJpYXQiOjE3MDczMjY1NjIsImV4cCI6MTcwNzM0NDU2Mn0._OhOROr2rOM6i_GZiLTsPcQy9Ohm6-pqAa_hfSm9KiA"
                        resp = ktorClient.postSelfMeds("selfPrescription", am, toke).toString()

                    }
                    shouldprescribe = false
                }

                Image(
                    painter = painterResource(id = R.drawable.view_cart_ii),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .offset(x = 9.dp, y = 40.dp)
                        .clickable {
                            navController.navigate(
                                "${selfpscreen.viewcart.route}/${
                                    tablist.joinToString(
                                        ","
                                    ) { TalbetToString(it) }
                                }"
                            )

                        }

                )

                for(i in tablist)
                {
                    Text("re "+i.name)
                }

            }

        }
    }


}

fun TalbetToString(Talbet: Talbet): String {
    return "${Talbet.name};${Talbet.mg};${Talbet.quantity.value};${Talbet.price};${Talbet.totalprice.value}"
}

//@Preview
//@Composable
//fun SelfPreview() {
//    User_self_prescription(navController = NavHostController)
//}
//