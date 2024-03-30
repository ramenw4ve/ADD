package com.example.add1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.add1.graphs.Graph

@Composable
fun Doc_signin(navController: NavHostController) {

    val ktorClient = KtorClient()


    val fontFamily = FontFamily(
        Font(R.font.jost_bold, FontWeight.Bold)
    )
    val fontFamily2 = FontFamily(
        Font(R.font.inter_medium, FontWeight.Medium)
    )
    val fontFamily3 = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )

    var unid by remember {
        mutableStateOf("")
    }

    var disp by remember {
        mutableStateOf("")
    }

    var shouldTriggerSignin by remember {
        mutableStateOf<Boolean>(false)
    }
    var toke by remember {
        mutableStateOf<String>("")
    }
    var pw by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Image(
            painterResource(id = R.drawable.uppersigni),
            contentDescription = null,
        )

        Column(modifier = Modifier.padding(end = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Row(modifier = Modifier.padding(end = 150.dp)) {
                Text(
                    text = "Sign",
                    fontSize = 36.sp,
                    fontFamily = fontFamily3,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = " In",
                    fontSize = 36.sp,
                    fontFamily = fontFamily3,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF97DDD5)
                )

            }

            Text(
                text = "Please enter your credentials to proceed",
                fontSize = 12.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF7D7D7D)
            )
        }
        Column(verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.height(140.dp)) {

            OutlinedTextField(
                value = unid, {
                    unid = it
                },
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = "Enter Doc UID",
                        color = Color(0xFF7E7B7B),
                        fontSize = 15.sp,
                        fontFamily = fontFamily2,
                        fontWeight = FontWeight.SemiBold,

                        )
                },modifier = Modifier
                    .width(350.dp)
                    .height(65.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFBFBFBF)
                )


            )


            OutlinedTextField(
                value = pw, {
                    pw = it
                },
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = "Enter Password",
                        color = Color(0xFF7E7B7B),
                        fontSize = 15.sp,
                        fontFamily = fontFamily2,
                        fontWeight = FontWeight.SemiBold,

                        )
                },modifier = Modifier
                    .width(350.dp)
                    .height(65.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0xFFBFBFBF)
                )

            )
        }



//        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                shouldTriggerSignin = true
            },
            modifier = Modifier
                .padding(18.dp)
                .width(282.dp)
                .height(53.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9C9F), )
            , shape = RoundedCornerShape(16.dp))
        {
            Text(text = "Sign In ",
                fontSize = 20.sp,
                fontFamily = fontFamily3)
        }
        LaunchedEffect(key1 = shouldTriggerSignin) {
            if (shouldTriggerSignin) {
                toke = ktorClient.postLDoctor("login", LDoctor(unid, pw)).toString()

                navController.navigate((Graph.DHOME)+"/$toke")


                shouldTriggerSignin = false
                pw = ""
                unid = ""


            }
        }

        Text(text = toke)

        Row {
            Text(
                text = "Create one?",
                color = Color(0xFF7D7D7D),
                fontSize = 12.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = " Sign up",
                fontSize = 12.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF509B92),
                modifier = Modifier.clickable {
                    navController.popBackStack()
                }
            )



        }


        Image(
            painterResource(id = R.drawable.lowersignin),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

    }
}