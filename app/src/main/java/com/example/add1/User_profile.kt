package com.example.add1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun User_profile_Screen(
//    navController: NavHostController,
//    backStackEntry: NavBackStackEntry
    token:String
) {




//    val token = backStackEntry.arguments?.getString("token")

    val ktorClient = KtorClient()



    var patg by remember {
        mutableStateOf<GPatient?>(null)
    }

    LaunchedEffect(key1 = Unit) {

        patg = ktorClient.getPatient("profile", token.toString())

    }



val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.background_user_pp),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
    Column {
        Text(
            text = "",
            fontSize = 24.sp,
            color = Color.Black,
            fontFamily = fontFamily, fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(74.dp, 36.dp)
        )



        Box {
            Column {
                androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.profile_pic),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(100.dp)
                        .offset(y = -50.dp),
                    contentScale = ContentScale.Fit

                )
                Box {
                    androidx.compose.foundation.Image(
                        painter = painterResource(id = R.drawable.text_box_user_pp),
                        contentDescription = null,
                        modifier = Modifier
                            .offset(y = -30.dp)
                            .clip(RoundedCornerShape(size = 35.dp))
                            .padding(35.dp)
                    )
                    Column(modifier = Modifier
                        .offset(y=-40.dp)
                        .height(250.dp)
                        .padding(45.dp)
//                        .background(Color.Cyan)
                        ,
                        verticalArrangement = Arrangement.SpaceEvenly) {
                        Text(
                            text = "Name: ${patg?.name}",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            fontFamily = fontFamily, fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
//                            .align(Alignment.TopStart)
                            .padding(top = 10.dp)
                        )
                        Text(
                            text = "User Id: ${patg?.uniqueId}",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            fontFamily = fontFamily, fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                            .padding(top = 10.dp)
//                            .align(Alignment.CenterStart)
                        )
                        Text(
                            text = "Phone Number: ${patg?.phone_no}",
                            color = Color.Gray,
                            fontSize = 16.sp,
                            fontFamily = fontFamily, fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                            .padding(top = 10.dp)
//                            .align(Alignment.BottomStart)
                        )
                    }

                }

            }


        }
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {


            Image(
                painter = painterResource(id = R.drawable.prescriptions_history),
                contentDescription = null,
                modifier = Modifier
                    .clickable { println("Button Clicked!") }
                    .padding(bottom = 180.dp),
                contentScale = ContentScale.Fit

            )
            Text(text = "Prescription history",
                modifier = Modifier
                    .clickable {
//                        navController.navigate("user_prev_prescription")
                    }
                    .padding(bottom = 175.dp)
                    .align(Alignment.Center),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White)


        }
        Text(text = "sign out",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable { }
                .padding(top = 40.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White

        )
    }
}