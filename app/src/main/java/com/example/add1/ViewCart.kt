package com.example.add1

//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.add1.graphs.activescreen
import com.example.add1.graphs.selfpscreen


@Composable
fun ViewCart(
    meds: List<Talbet>
    , toke: String, navController: NavHostController
)
{

    val context = LocalContext.current


    var shouldprescribe by remember {
        mutableStateOf(false)
    }
//    var toke by remember {
//        mutableStateOf<String>("")
//    }
    var resp by remember {
        mutableStateOf<String>("")
    }
    var medicineList: List<Medicine> = listOf(Medicine("Gelusil MPS",600,6))

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



    var total: Int = 0



    var allMed: AllMed? = null

    val ktorClient = KtorClient()

    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )




    val mutabletabs = meds.toMutableList()


//    val mutabletabs2 = mutableListOf<Talbet>()
//    val mutabletabs2 = meds.toMutableStateList()

    var mutabletabs2 by remember {
        mutableStateOf( meds.toMutableStateList())
    }

    for (i in mutabletabs2) {

        total += i.totalprice.value

    }

//    for (i in meds) {
//        if (i.quantity.value != 0) {
//            mutabletabs2.add(i)
//        }
//    }

    for(i in mutabletabs2.toList())
    {
        if(i.quantity.value == 0)
        {
            mutabletabs2.remove(i)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
//            .background(Color.Gray)
            .height(775.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {

        Image(painterResource(id = R.drawable.yourcartwithbg), contentDescription = null)


        Box(
            modifier = Modifier
//                .offset(y = -170.dp)
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .width(350.dp)
                .border(width = 0.3.dp, color = Color.Gray, shape = RoundedCornerShape(20.dp))
                .padding(7.dp)
//                .weight(f)
//                .offset(y = -10.dp)
        )
        {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
//                    .offset(y = 90.dp)
//                    .size(470.dp)
//                .background(Color.Cyan)
            ) {
                items(mutabletabs2)
                { i ->
                    Box(
                        modifier = Modifier.fillParentMaxWidth(),
                        contentAlignment = Alignment.Center
                    )
                    {

                        Row(
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .padding(2.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(
                                modifier = Modifier
//                                                            .background(Color.Cyan)
                                    .weight(0.5f)
                                    .offset(30.dp)

                            ) {
                                Text(
                                    i.name,
                                    fontSize = 20.sp,
                                    fontFamily = fontFamily,
                                    color = Color(0xFF6CB5AC)
                                )


                                Text(
                                    i.mg + " mg",
                                    fontSize = 16.sp,
                                    fontFamily = fontFamily,
                                    color = Color(0xFFFF9c9f)
                                )
                                Text(
                                    "₹ " + i.price,
                                    fontSize = 18.sp,
                                    fontFamily = fontFamily,
                                    color = Color.Black
                                )
                            }


                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
//                                                                .background(Color.Green)
                                    .weight(0.5f)
                                    .offset(45.dp, y = 6.dp)
                            ) {
                                Image(
                                    painterResource(id = R.drawable.horiborder),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillBounds
                                )
                                Row(horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.
                                width(60.dp)
//                                .background(Color.Cyan)
                                )
                                {
                                    Image(painterResource(id = R.drawable.horiminus),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .offset(y = 6.dp)
                                            .clickable {
                                                if (i.quantity.value == 0) {
//                                                    mutabletabs.remove(i)
                                                } else {
//                                                    val index =
//                                                        meds.indexOfFirst { it.name == i.name }
//                                                    meds[index].quantity.value--
//                                                    meds[index].totalprice.value =
//                                                        meds[index].price.toInt() * meds[index].quantity.value

                                                    i.quantity.value--
                                                    i.totalprice.value =
                                                        i.price.toInt() * i.quantity.value

                                                }

                                            }
                                    )

                                    Image(painterResource(id = R.drawable.horiplus),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .offset(y = (0).dp)
                                            .clickable {
                                                i.quantity.value++
                                                i.totalprice.value =
                                                    i.price.toInt() * i.quantity.value
//                                                val index = meds.indexOfFirst { it.name == i.name }
//                                                meds[index].quantity.value++
//                                                meds[index].totalprice.value =
//                                                    meds[index].price.toInt() * meds[index].quantity.value

                                            }
                                    )
                                }
//                                val index = meds.indexOfFirst { it.name == i.name }
                                Text(
//                                    meds[index].quantity.value.toString()
                                    i.quantity.value.toString(),
                                    fontSize = 20.sp,
                                    fontFamily = fontFamily,
                                    color = Color(0xFFF1878A)
                                )

                            }
//                            val index = meds.indexOfFirst { it.name == i.name }
                            Text(text = "₹ " + i.totalprice.value.toString(),
                                modifier = Modifier.offset(x = -15.dp,y = 50.dp))

                        }

                    }
                }
            }

            

            LaunchedEffect(key1 = shouldprescribe) {

                 medicineList = mutabletabs2.map {
                    Medicine(
                        name = it.name,
                        mg = it.mg.toInt(),
                        quantity = it.quantity.value
                    )
                }

                val am = Postselfmeds(medicineList)
                if (shouldprescribe) {
//                    toke =
//                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWMxZGNmYzA1NDAzMjZmMmM3YzdmMDMiLCJpYXQiOjE3MDc4MDk5MzUsImV4cCI6MTcwNzgyNzkzNX0.aMWXiDqET9tL3A4eauUTmLjP052tg7vv6gbbnkYiVxQ"
                    resp = ktorClient.postSelfMeds("selfPrescription", am, toke).toString()

                }
                shouldprescribe = false
            }

        }
        Button(onClick = {

            shouldprescribe = true
            Toast.makeText(context, "Prescribed Successfully", Toast.LENGTH_SHORT).show()

        }) {
            Text("Prescribe")

        }
        

        Box(modifier = Modifier.offset(y = 0.dp))
        {

          Row {
              Image(
                  painterResource(id = R.drawable.totalvector),
                  contentDescription = null,
                  contentScale = ContentScale.FillBounds
              )
              Image(
                  painterResource(id = R.drawable.payvector),
                  contentDescription = null,
                  contentScale = ContentScale.FillBounds,
                  modifier = Modifier.clickable {
                      navController.navigate(selfpscreen.viewselfqr.route)

                  }
              )
          }
            Text(text = "Total ₹ $total",
                fontSize = 20.sp,
                fontFamily = fontFamily,
                color = Color(0xFF509B92),
                modifier = Modifier.offset(30.dp,y = 17.dp))
        }


    }
}



//@Preview
//@Composable
//fun ViewCartPreview() {
//    ViewCart()
//}
