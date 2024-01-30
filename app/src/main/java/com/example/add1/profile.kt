package com.example.add1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Profile() {
    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        Text(text = "Profile")

        Icon(imageVector = Icons.Filled.Person, contentDescription = null,
            modifier = Modifier
                .size(80.dp))

        Text(text = "Username")
        Text(text = "ID")
        Text(text = "Phone Number")

    }
    
}