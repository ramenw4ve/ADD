package com.example.add1

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.add1.graphs.AuthScreen
import com.example.add1.graphs.DocScreen
import com.example.add1.graphs.Patscreen


@Composable
fun Login_as(navController: NavHostController) {

    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )
    val fontFamily2 = FontFamily(
        Font(R.font.inter_semibold, FontWeight.SemiBold)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Image(
            painterResource(id = R.drawable.topvector3x),
            contentDescription = null,
        )

        Row {
            Text(
                text = "Login",
                fontSize = 40.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = " as",
                fontSize = 40.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF97DDD5)
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Image(
                    painterResource(id = R.drawable.doc_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .border(
                            BorderStroke(1.dp, Color(0xFFBFBFBF)),
                            shape = RoundedCornerShape(38.dp)
                        )
                        .padding(25.dp)
                        .clickable {
                            navController.navigate(
                                DocScreen.SignUp.route)
                        }
                    
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(text = "Doctor",
                    fontSize = 16.sp,
                    fontFamily = fontFamily2,
                    fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()

                    .weight(1f)
            ) {
                Image(
                    painterResource(id = R.drawable.patient_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .border(
                            BorderStroke(1.dp, Color(0xFFBFBFBF)),
                            shape = RoundedCornerShape(38.dp)
                        )
                        .padding(25.dp)
                        .clickable {
                            navController.navigate(
                                Patscreen.SignUp.route)
                        }

                    )

                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Patient",
                    fontSize = 16.sp,
                    fontFamily = fontFamily2,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }

        Image(painterResource(id = R.drawable.bottomvector),
            contentDescription = null)

    }
}