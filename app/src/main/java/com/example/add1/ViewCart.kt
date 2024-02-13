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
    tablist: List<Talbet>
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

//    var total by remember {
//        mutableStateOf<Int>(0)
//    }

    var total:Int = 0

//    var allMed by remember {
//        mutableStateOf<AllMed?>(null)
//    }

    var allMed:AllMed? = null

    val ktorClient = KtorClient()

    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )


    LaunchedEffect(Unit) {
       allMed = ktorClient.getAllMeds("medicines")
    }

    for(i in tablist)
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
                            Text(text = i.totalprice.value.toString(),
                                modifier = Modifier.offset(x = -15.dp))

                        }

                    }
                }
            }

            val mutabletabs = mutableListOf<Talbet>()
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



            Text(total.toString(),
                modifier = Modifier
                    .offset(x = 55.dp, y = 670.dp))
            Image(
                painterResource(id = R.drawable.checkout), contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .offset(x = 55.dp, y = 725.dp)
                    .clickable {

                        shouldprescribe = true

                    }
            )

            LaunchedEffect(key1 = shouldprescribe) {

                    val medicineList = postablelist.map {
                        Medicine(
                            name = it.name,
                            mg = it.mg,
                            quantity = it.quantity.value.toString()
                        )
                    }

                    val am = AMedicines(medicineList)

                    if (shouldprescribe) {
                        toke =
                            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWMxZGNmYzA1NDAzMjZmMmM3YzdmMDMiLCJpYXQiOjE3MDc4MDk5MzUsImV4cCI6MTcwNzgyNzkzNX0.aMWXiDqET9tL3A4eauUTmLjP052tg7vv6gbbnkYiVxQ"
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
