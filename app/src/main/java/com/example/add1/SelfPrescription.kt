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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.add1.graphs.selfpscreen

//import com.example.add1.graphs.selfpscreen

@Composable
fun User_self_prescription(navController: NavHostController)
{
    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )
    var m1 by remember {
        mutableStateOf(0)
    }
    var m2 by remember {
        mutableStateOf(0)
    }
    var m3 by remember {
        mutableStateOf(0)
    }
    var m4 by remember {
        mutableStateOf(0)
    }
    var m5 by remember {
        mutableStateOf(0)
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFF9C9F)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.self_prescription_top_design),
            contentDescription = null,
            modifier = Modifier.align(Alignment.End)
        )
//        Row(modifier = Modifier.fillMaxWidth().offset(x = 50.dp,y = -30.dp)){


//            OutlinedTextField(
//                value = name, {
//                    name = it
//                },
//                shape = RoundedCornerShape(16.dp),
//                label = {
//                    Text(
//                        text = "Search Medicines",
//                        color =(Color.White),
//                        fontSize = 15.sp,
//                        fontWeight = FontWeight.SemiBold
//                    )
//                },
//                colors = OutlinedTextFieldDefaults.colors(
//                    unfocusedBorderColor = (Color.White)
//                )
//
//            )
//        }



        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(size = 40.dp))
                .background(Color.White),
            contentAlignment = Alignment.TopCenter



        ){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.offset(y = 90.dp)
            ){
                Row {
                    Text(
                        text = "Crocin",
                        fontSize = 22.sp,
                        modifier = Modifier.offset(x = -60.dp)
                    )
                    Spacer(modifier = Modifier.width(140.dp))
                    Text(
                        text = "-",
                        fontSize = 20.sp,
                        modifier = Modifier.clickable {
                            m1--
                        }.border(BorderStroke((1.5).dp, Color.Gray)).padding(5.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = m1.toString(),
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "+",
                        fontSize = 20.sp,
                        modifier = Modifier.clickable {
                            m1++
                        }.border(BorderStroke((1.5).dp, Color.Gray)).padding(5.dp)
                    )


                }
                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Text(
                        text = "Cetirizine",
                        fontSize = 22.sp,
                        modifier = Modifier.offset(x = -60.dp)
                    )
                    Spacer(modifier = Modifier.width(110.dp))
                    Text(
                        text = "-",
                        fontSize = 20.sp,
                        modifier = Modifier.clickable {
                            m2--
                        }.border(BorderStroke((1.5).dp, Color.Gray)).padding(5.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = m2.toString(),
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "+",
                        fontSize = 20.sp,
                        modifier = Modifier.clickable {
                            m2++
                        }.border(BorderStroke((1.5).dp, Color.Gray)).padding(5.dp)
                    )


                }
                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Text(
                        text = "Dolo 650",
                        fontSize = 22.sp,
                        modifier = Modifier.offset(x = -60.dp)
                    )
                    Spacer(modifier = Modifier.width(110.dp))
                    Text(
                        text = "-",
                        fontSize = 20.sp,
                        modifier = Modifier.clickable {
                            m3--
                        }.border(BorderStroke((1.5).dp, Color.Gray)).padding(5.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = m3.toString(),
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "+",
                        fontSize = 20.sp,
                        modifier = Modifier.clickable {
                            m3++
                        }.border(BorderStroke((1.5).dp, Color.Gray)).padding(5.dp)
                    )


                }
                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Text(
                        text = "Saridon",
                        fontSize = 22.sp,
                        modifier = Modifier.offset(x = -60.dp)
                    )
                    Spacer(modifier = Modifier.width(120.dp))
                    Text(
                        text = "-",
                        fontSize = 20.sp,
                        modifier = Modifier.clickable {
                            m4--
                        }.border(BorderStroke((1.5).dp, Color.Gray)).padding(5.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = m4.toString(),
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "+",
                        fontSize = 20.sp,
                        modifier = Modifier.clickable {
                            m4++
                        }.border(BorderStroke((1.5).dp, Color.Gray)).padding(5.dp)
                    )


                }
                Spacer(modifier = Modifier.height(30.dp))
                Row {
                    Text(
                        text = "Zincovit",
                        fontSize = 22.sp,
                        modifier = Modifier.offset(x = -60.dp)
                    )
                    Spacer(modifier = Modifier.width(115.dp))
                    Text(
                        text = "-",
                        fontSize = 20.sp,
                        modifier = Modifier.clickable {
                            m5--
                        }.border(BorderStroke((1.5).dp, Color.Gray)).padding(5.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = m5.toString(),
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "+",
                        fontSize = 20.sp,
                        modifier = Modifier.clickable {
                            m5++
                        }.border(BorderStroke((1.5).dp, Color.Gray)).padding(5.dp)
                    )


                }
                Spacer(modifier = Modifier.height(30.dp))

            }
            Image(
                painter = painterResource(id = R.drawable.view_cart_ii),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .offset(x = 9.dp, y = 500.dp)
                    .clickable {
                        navController.navigate(selfpscreen.viewcart.route)
                    }

            )
        }
    }
}