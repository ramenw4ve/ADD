package com.example.add1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.add1.graphs.activescreen


@Composable
fun User_payment(
    navController: NavHostController,
    toke:String
) {

    val ktorClient = KtorClient()

    var patH by remember {
        mutableStateOf<HPatient?>(null)
    }

    LaunchedEffect(key1 = Unit) {

        patH = ktorClient.getHPatient("home", toke.toString())

    }


    val fontFamilyjs = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )
    Column(
        modifier = Modifier
            .background(color = Color(0xFFFF9C9F))
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_payment_ellipse_top),
            contentDescription = null,
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(RoundedCornerShape(size = 40.dp))
                .background(color = Color.White), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                   Text(text = "Medicines",
                       fontSize = 20.sp,
                       color = Color.Black,
                       fontFamily = fontFamilyjs,
                       fontWeight = FontWeight.SemiBold)
                   Text(text = "Quantity",
                       fontSize = 20.sp,
                       color = Color.Black,
                       fontFamily = fontFamilyjs,
                       fontWeight = FontWeight.SemiBold)
                   Text(text = "Price",fontSize = 20.sp,
                       color = Color.Black,
                       fontFamily = fontFamilyjs,
                       fontWeight = FontWeight.SemiBold)
                }

                LazyRow(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    patH?.let {
                        items(it.Medicines) { med ->
                            Text(
                                text = "${med.Medicine_name}",
                                fontSize = 18.sp,
                                fontFamily = fontFamilyjs, fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.offset(x = 0.dp)
                            )
                            Spacer(modifier = Modifier.width(15.dp))
                            Text(
                                text = "${med.quantity}",
                                fontSize = 18.sp,
                                fontFamily = fontFamilyjs, fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.width(15.dp))
                            Text(
                                text = "${med.price}",
                                fontSize = 18.sp,
                                fontFamily = fontFamilyjs, fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }

                }




                Image(painter = painterResource(id = R.drawable.upi),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(y = 150.dp)
                        .size(250.dp)
//                        .clickable {  }
                )

                Button(
                    onClick = {

                    },
                    modifier = Modifier.offset(x = 0.dp, y = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9C9F)),
                    shape = RoundedCornerShape(16.dp)
                )
                {
                    Text(text = "Proceed to Check-Out",
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier.clickable {
                            navController.navigate(activescreen.viewqr.route)
                        }
                    )
                }

//                Image(painter = painterResource(id = R.drawable.credit_card), contentDescription = null
//                    , modifier = Modifier
//                        .clickable { }
//                        .offset(x = 45.dp))
            }
        }

    }
}