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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
        mg = "550",
        price = "25",
        quantity = remember { mutableStateOf(0)},
        totalprice = remember { mutableStateOf(0) }
    )



    val meds = listOf(medicine1, medicine2, medicine3, medicine4, medicine5)
    var total:Int = 0


    for(i in meds)
    {
        total+= i.totalprice.value
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {


        Box(modifier = Modifier.fillMaxSize())
        {
            Image(painterResource(id = R.drawable.greenbg), contentDescription = null, contentScale = ContentScale.FillBounds)


            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 90.dp)
                    .size(470.dp)
//                .background(Color.Cyan)
            )
            {
                items(meds)
                { i ->
                    Box(
                        modifier = Modifier.fillParentMaxWidth(),
                        contentAlignment = Alignment.Center
                    )
                    {
                        Image(
                            painterResource(id = R.drawable.shadowrectangle),
                            contentDescription = null
                        )
                        Row(
                            modifier = Modifier.fillParentMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(
                                modifier = Modifier
                                    //                        .background(Color.Cyan)
                                    .weight(0.5f)
                                    .offset(45.dp)
                            ) {
                                Text(
                                    i.name,
                                    fontSize = 24.sp,
                                    fontFamily = fontFamily,
                                    color = Color(0xFF6CB5AC)
                                )


                                Text(
                                    i.mg+" mg",
                                    fontSize = 20.sp,
                                    fontFamily = fontFamily,
                                    color = Color(0xFFFF9c9f)
                                )
                                Text(
                                    "₹ "+i.price.toString(),
                                    fontSize = 18.sp,
                                    fontFamily = fontFamily,
                                    color = Color.Black
                                )
                            }


                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    //                            .background(Color.Green)
                                    .weight(0.5f)
                                    .offset(35.dp, y = -5.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.border),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillBounds
                                )
                                Column(verticalArrangement = Arrangement.Top) {
                                    Image(painterResource(id = R.drawable.plus),
                                        contentDescription = null,
                                        modifier = Modifier.clickable { i.quantity.value++ }
                                    )
                                    Image(
                                        painterResource(id = R.drawable.midrect),
                                        contentDescription = null,
                                        contentScale = ContentScale.FillBounds,
                                        modifier = Modifier.offset(y = (0).dp)
                                    )
                                    Image(painterResource(id = R.drawable.minus),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .offset(y = (0).dp)
                                            .clickable {
                                                if (i.quantity.value != 0) {
                                                    i.quantity.value--
                                                }

                                            })
                                }
                                Text(
                                    i.quantity.value.toString(),
                                    fontSize = 20.sp,
                                    fontFamily = fontFamily,
                                    color = Color(0xFFF1878A)
                                )

                            }
                            i.totalprice.value = i.price.toInt()*i.quantity.value
//                            Text(text = i.totalprice.value.toString(),
//                                modifier = Modifier.offset(x = -15.dp))

                        }

                    }
                }
            }

            val mutabletabs = mutableListOf<Talbet>()
            for (i in meds) {
                if (i.quantity.value != 0) {
                    mutabletabs.add(i)
                }
            }

                var tablist = mutabletabs.toList()


            Image(painterResource(id = R.drawable.yourcartbg) , contentDescription = null)
            Text("Self Prescription",
                fontSize = 40.sp,
                fontFamily = fontFamily,
                color = Color.White,
                modifier = Modifier
                    .offset((39).dp)
                    .padding(10.dp)
            )


            Image(
                painterResource(id = R.drawable.checkoutbg), contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.offset(y = 560.dp)
            )





            Text("₹ "+total.toString(),
                fontSize = 18.sp,
                fontFamily = fontFamily,
                color = Color.Black,
                modifier = Modifier
                    .offset(x = 165.dp, y = 590.dp))
            Image(
                painterResource(id = R.drawable.checkout), contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .offset(x = 55.dp, y = 653.dp)
                    .clickable {

                        navController.navigate(
                            "${selfpscreen.viewcart.route}/${
                                meds.joinToString(
                                    ","
                                ) { TalbetToString(it) }
                            }"
                        )

                    }
            )



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