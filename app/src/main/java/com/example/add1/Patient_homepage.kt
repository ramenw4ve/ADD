package com.example.add1


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.navigation.NavHostController
import com.example.add1.graphs.activescreen


@Composable
fun User_home_page(toke: String,navController: NavHostController) {
    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )

    val ktorClient = KtorClient()


    var patH by remember {
        mutableStateOf<HPatient?>(null)
    }

    LaunchedEffect(key1 = Unit) {

        patH = ktorClient.getHPatient("home", toke.toString())

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFF9C9F)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        Image(
            painter = painterResource(id = R.drawable.upper_design_pthomepg),
            contentDescription = null
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(size = 40.dp))
                .background(Color.White)
                .padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            )
            {
                Text(
                    text = "Active Prescription",
                    modifier = Modifier.align(Alignment.CenterHorizontally),

                    fontSize = 24.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .offset(y = (-80).dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.greenthing),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,

                        )

                    Column(
                        modifier = Modifier
                            .padding(end = 0.dp, bottom = 0.dp)
                            .offset(x = -30.dp)
                    ) {

                        Text(
                            text = "Doctor: ${patH?.doctorName}",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier
                                .offset(x = 14.dp,y = -38.dp)
                        )
                        Column(modifier = Modifier.offset(y=-15.dp)) {
                            Text(
                                text = "Hospital Name: ",
                                color = Color.White,
                                fontSize = 15.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.SemiBold

                            )
                            Text(
                                text = "Number of Items: ${patH?.numberOfMedicines}",
                                color = Color.White,
                                fontSize = 15.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.SemiBold

                            )
                        }


                    }



                    Text(
                        text = "VIEW MEDICINE",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(top = 155.dp)
                            .clickable {
                                navController.navigate(activescreen.viewactive.route)
                            }
                    )


                }

            }


//            Image(
//                painter = painterResource(id = R.drawable.generate_qr),
//                contentDescription = null,
//                contentScale = ContentScale.FillBounds,
//                modifier = Modifier
//                    .align(Alignment.BottomCenter)
//                    .offset(y = -60.dp)
//                    .clickable {
//
//                    }
//            )
        }

    }

}
