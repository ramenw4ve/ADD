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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.add1.graphs.Graph
import com.example.add1.graphs.Patscreen

//import com.example.add1.patient.graphs.Graph


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun User_signup(navController: NavHostController) {


    val ktorClient = KtorClient()

    var patient by remember {
        mutableStateOf<String?>("")
    }

    var shouldTriggerSignup by remember {
        mutableStateOf<Boolean>(false)
    }

    var toke by remember {
        mutableStateOf<String>("")
    }

    var snackbarHostState = remember {
        SnackbarHostState()
    }


    val fontFamily = FontFamily(
        Font(R.font.jost_bold, FontWeight.Bold)
    )
    val fontFamily2 = FontFamily(
        Font(R.font.inter_medium, FontWeight.Medium)
    )
    val fontFamily3 = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )

    var name by remember {
        mutableStateOf("")
    }
    var phno by remember {
        mutableStateOf("")
    }
    var pw by remember {
        mutableStateOf("")
    }
    var confpw by remember {
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
        )

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
            fontSize = 12.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF7D7D7D)
            ,modifier = Modifier.offset(y = -10.dp)
        )

        OutlinedTextField(
            value = name, {
                name = it
            },
            shape = RoundedCornerShape(16.dp),
            label = {
                Text(
                    text = "Enter Name",
                    color = Color(0xFF7E7B7B),
                    fontSize = 15.sp,
                    fontFamily = fontFamily2,
                    fontWeight = FontWeight.SemiBold
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFBFBFBF)
            )

        )

        OutlinedTextField(
            value = phno, {
                phno = it
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
                    fontWeight = FontWeight.SemiBold
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFBFBFBF)
            )

        )

        OutlinedTextField(
            value = confpw, {
                confpw = it
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
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFFBFBFBF)
            )

        )

//        Spacer(modifier = Modifier.height(15.dp))


        Scaffold(
            snackbarHost = {

                SnackbarHost(hostState = snackbarHostState)
            }, modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.offset(y = -20.dp)
            ) {
                Button(
                    onClick = {

                        shouldTriggerSignup = true


                    },
                    modifier = Modifier.offset(y = -25.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9C9F)),
                    shape = RoundedCornerShape(16.dp)
                )
                {
                    Text(text = "Sign Up")
                }
                LaunchedEffect(key1 = shouldTriggerSignup) {
                    if (shouldTriggerSignup) {
                        patient = ktorClient.postPatient("signup", Patient(name, phno, pw))
                        toke = ktorClient.postLPatient("login", LPatient(patient.toString(), pw)).toString()

//                        toke = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWMxZGNmYzA1NDAzMjZmMmM3YzdmMDMiLCJpYXQiOjE3MTE3MjM2NTEsImV4cCI6MTcxMTc0MTY1MX0.kEp7PcqzMYxvfD0BAwM6i7nxEQIQHyPN8lzuOxMg05Y"



//                        if (!patient?.contains("e")!!) {
                            snackbarHostState.showSnackbar(
                                "User successfully registered."

                            )


//                            navController.navigate("php/$toke")
                            navController.navigate((Graph.PHOME)+"/$toke")
//                        } else {
//                            snackbarHostState.showSnackbar(
//                                "User not registered successfully. $patient"
//                            )
                        }



                        shouldTriggerSignup = false
                        name = ""
                        phno = ""
                        pw = ""
                        confpw = ""


//                    }
                }
                Row {
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
                            navController.navigate((Patscreen.SignIn.route))
                        }
                    )


                }
                Image(
                    painterResource(id = R.drawable.lower_design),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.offset(y = 100.dp)
                )
            }

        }

    }

}



