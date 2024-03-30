package com.example.add1

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
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
import com.example.add1.graphs.DocScreen
import com.example.add1.graphs.Graph
import com.example.add1.graphs.Patscreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Doc_signup(navController: NavHostController) {
    val fontFamily = FontFamily(
        Font(R.font.jost_bold, FontWeight.Bold)
    )
    val fontFamily2 = FontFamily(
        Font(R.font.inter_medium, FontWeight.Medium)
    )
    val fontFamily3 = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )

//    val ktorClient = KtorClient()

    var doctor by remember {
        mutableStateOf<String>("")
    }

    var dtoke by remember {
        mutableStateOf<String>("")
    }

    var snackbarHostState = remember {
        SnackbarHostState()
    }

    var shouldTriggerSignup by remember {
        mutableStateOf<Boolean>(false)
    }


    var rgno by remember {
        mutableStateOf("")
    }
    var name by remember {
        mutableStateOf("")
    }
    var spc by remember {
        mutableStateOf("")
    }
    var pwd by remember {
        mutableStateOf("")
    }
    var cpwd by remember {
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
            painterResource(id = R.drawable.upper_design),
            contentDescription = null,
            modifier = Modifier.offset(y = -9.dp)
        )


        Column(
            modifier = Modifier.offset(y = -25.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Row(modifier = Modifier.offset(y = -10.dp)) {
                Text(
                    text = "Create",
                    fontSize = 36.sp,
                    fontFamily = fontFamily3,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = " Account",
                    fontSize = 36.sp,
                    fontFamily = fontFamily3,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF97DDD5)
                )

            }



            Text(
                text = "Please enter your credentials to proceed",
                modifier = Modifier
                    .padding(0.dp)
                    .offset(y = -9.dp),
                fontSize = 12.sp,
                fontFamily = fontFamily,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF7D7D7D)
            )

            OutlinedTextField(
                value = rgno, {
                    rgno = it
                },
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = "Enter Registration Number",
                        color = Color(0xFF7E7B7B),
                        fontSize = 15.sp,
                        fontFamily = fontFamily2,
                        fontWeight = FontWeight.SemiBold,

                        )
                },

                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0XFFBFBFBF),
                )

            )

            OutlinedTextField(
                value = name, {
                    name = it
                },
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = "Enter Phone Number",
                        color = Color(0xFF7E7B7B),
                        fontSize = 15.sp,
                        fontFamily = fontFamily2,
                        fontWeight = FontWeight.SemiBold
                    )
                },
//            colors = TextFieldDefaults.textFieldColors(Color(0xFFBFBFBF)
//            )
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0XFFBFBFBF),
                )

            )

            OutlinedTextField(
                value = spc, {
                    spc = it
                },
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = "Enter Specialisation",
                        color = Color(0xFF7E7B7B),
                        fontSize = 15.sp,
                        fontFamily = fontFamily2,
                        fontWeight = FontWeight.SemiBold
                    )
                },
//            colors = TextFieldDefaults.textFieldColors(Color(0xFFBFBFBF)
//            )
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0XFFBFBFBF),
                )

            )


            OutlinedTextField(
                value = pwd, {
                    pwd = it
                },
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = "Enter Password",
                        color = Color(0xFF7E7B7B),
                        fontSize = 15.sp,
                        fontFamily = fontFamily2,
                        fontWeight = FontWeight.SemiBold
                    )
                },
//            colors = TextFieldDefaults.textFieldColors(Color(0xFFBFBFBF)
//            )
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0XFFBFBFBF),
                )

            )
            OutlinedTextField(
                value = cpwd, {
                    cpwd = it
                },
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = "Confirm Password",
                        color = Color(0xFF7E7B7B),
                        fontSize = 15.sp,
                        fontFamily = fontFamily2,
                        fontWeight = FontWeight.SemiBold
                    )
                },
//            colors = TextFieldDefaults.textFieldColors(Color(0xFFBFBFBF)
//            )
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color(0XFFBFBFBF),
                )

            )
        }






        Scaffold(
            snackbarHost = {

                SnackbarHost(hostState = snackbarHostState)
            }, modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.offset(y = 0.dp)
            ) {
                Button(
                    onClick = {
                        shouldTriggerSignup = true
                    },
                    modifier = Modifier.offset(x= 150.dp,y = 0.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9C9F)),
                    shape = RoundedCornerShape(16.dp)
                )
                {
                    Text(text = "Sign Up")
                }
                LaunchedEffect(key1 = shouldTriggerSignup) {
                    if (shouldTriggerSignup) {
//                        doctor = ktorClient.postDoctor("signup", Doctor(rgno, spc, name, pwd))
                            dtoke  = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWMxZGUzMDA1NDAzMjZmMmM3YzdmMDciLCJpYXQiOjE3MTE3MjM2MTcsImV4cCI6MTcxMTc0MTYxN30.0-6O7E1y31imWA915mFUa_4N8kK4x4WfvE_IHf_3Myc"

//                        if (doctor.contains("created")) {
                        snackbarHostState.showSnackbar(
                            "Doctor successfully registered."
                        )

                        navController.navigate((Graph.DHOME)+"/$dtoke")


//                        } else {
//                            snackbarHostState.showSnackbar(
//                                "User not registered successfully. $doctor"
//                            )


                        shouldTriggerSignup = false
                        rgno = ""
                        name = ""
                        pwd = ""
                        cpwd = ""
                        spc = ""

                    }
                }
            }


            Row(modifier = Modifier.offset(x=120.dp,y = 50.dp)) {
                Text(
                    text = "Already have one?",
                    color = Color(0xFF7D7D7D),
                    fontSize = 12.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = " Sign in",
                    fontSize = 12.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF509B92),
                    modifier = Modifier.clickable {

                        navController.navigate((DocScreen.SignIn.route))
                    }
                )


            }

            Image(
                painterResource(id = R.drawable.lower_design),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.offset(y = 16.dp)

            )
        }
    }


}

