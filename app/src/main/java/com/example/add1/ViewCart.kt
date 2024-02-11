package com.example.add1

//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ViewCart(
    tablist: List<Tablet>
) {
    var shouldprescribe by remember {
        mutableStateOf(false)
    }
    var toke by remember {
        mutableStateOf<String>("")
    }
    var resp by remember {
        mutableStateOf<String>("")
    }
    val ktorClient = KtorClient()

    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )

//    val medicine1 = Tablet(
//        name = remember { mutableStateOf("Gelusil MPS") },
//        mg = remember { mutableStateOf("600") },
//        quantity = remember { mutableIntStateOf(0) }
//    )
//
//    val medicine2 = Tablet(
//        name = remember { mutableStateOf("Okacet") },
//        mg = remember { mutableStateOf("10") },
//        quantity = remember { mutableIntStateOf(0) }
//    )
//
//    val medicine3 = Tablet(
//        name = remember { mutableStateOf("Dolo 650") },
//        mg = remember { mutableStateOf("650") },
//        quantity = remember { mutableIntStateOf(0) }
//    )
//
//    val medicine4 = Tablet(
//        name = remember { mutableStateOf("Saridon") },
//        mg = remember { mutableStateOf("550") },
//        quantity = remember { mutableIntStateOf(0) }
//    )
////    val medicine5 = Tablet(
////        name = remember { mutableStateOf("Ronny") },
////        mg = remember { mutableStateOf("550") },
////        quantity = remember { mutableIntStateOf(0) }
////    )
//    //    var TabletList = medlist.toMutableList()
//    val tablist = mutableListOf(medicine1, medicine2, medicine3, medicine4)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {


        Box(modifier = Modifier.fillMaxSize())
        {


            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 90.dp)
                    .size(545.dp)
//                .background(Color.Cyan)
            ) {
                items(tablist)
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
                                    i.name.value,
                                    fontSize = 20.sp,
                                    fontFamily = fontFamily,
                                    color = Color(0xFF6CB5AC)
                                )
                                Text(
                                    i.mg.value,
                                    fontSize = 16.sp,
                                    fontFamily = fontFamily,
                                    color = Color(0xFF6CB5AC)
                                )
                                Text(
                                    "Price",
                                    fontSize = 22.sp,
                                    fontFamily = fontFamily,
                                    color = Color(0xFF6CB5AC)
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

                        }

                    }
                }
            }

            val mutabletabs = mutableListOf<Tablet>()
            for (i in tablist) {
                if (i.quantity.value != 0) {
                    mutabletabs.add(i)

                }
            }

            var postablelist = mutabletabs.toList()
            Image(painterResource(id = R.drawable.yourcartbg) , contentDescription = null)
            Text("Your Cart",
                fontSize = 40.sp,
                fontFamily = fontFamily,
                color = Color.White,
                modifier = Modifier
                    .offset((10).dp)
                    .padding(10.dp)
            )


            Image(
                painterResource(id = R.drawable.checkoutbg), contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.offset(y = 632.dp)
            )
            Image(
                painterResource(id = R.drawable.checkout), contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.offset(x = 55.dp,y = 725.dp)
                    .clickable {

                        shouldprescribe = true

                    }
            )

            LaunchedEffect(key1 = shouldprescribe) {

                    val medicineList = postablelist.map {
                        Medicine(
                            name = it.name.value,
                            mg = it.mg.value,
                            quantity = it.quantity.value.toString()
                        )
                    }

                    val am = AMedicines(medicineList)

                    if (shouldprescribe) {
                        toke =
                            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWMxZGNmYzA1NDAzMjZmMmM3YzdmMDMiLCJpYXQiOjE3MDc2Njc3MTMsImV4cCI6MTcwNzY4NTcxM30.bs8ei-jThGRxzDYk0D_oJeg0EVU6bCJfwC5oRo8svCU"
                        resp = ktorClient.postSelfMeds("selfPrescription", am, toke).toString()

                    }
                    shouldprescribe = false
                }

        }


    }


}

//@Preview
//@Composable
//fun ViewCartPreview() {
//    ViewCart()
//}
