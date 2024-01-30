package com.example.add1.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SignupContent(
    onClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "re",
            modifier = Modifier.clickable {  })

        Text(

            text = "SIGN UP",
//            fontSize = 30.dp,
//            fontWeight = FontWeight.Bold,
            modifier = Modifier.clickable { onClick() },
        )
        Text(
            modifier = Modifier.clickable { onSignUpClick() },
            text = "Log in",
//            fontSize = 30.dp,
//            fontWeight = FontWeight.Medium
        )
        Text(
            modifier = Modifier.clickable { onForgotClick() },
            text = "Forgot Password",
//            fontSize = 30.dp,
//            fontWeight = FontWeight.Medium
        )
    }
}