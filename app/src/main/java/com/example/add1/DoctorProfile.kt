package com.example.add1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DocProfile(dtoke:String) {
    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )

    val ktorClient = KtorClient()

    var docg by remember {
        mutableStateOf<GDoctor?>(null)
    }


    LaunchedEffect(key1 = Unit) {

        docg = ktorClient.getDoctor("profile", dtoke.toString())

    }


    Box(
        modifier = Modifier.fillMaxSize()


    ) {
        Image(
            painter = painterResource(id = R.drawable.docsprofile), contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
    Column {

        Box(modifier = Modifier.offset(y = 25.dp)) {
            Column {
                androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.logo1), contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(100.dp),
                    contentScale = ContentScale.Fit

                )
                Box {
                    androidx.compose.foundation.Image(
                        painter = painterResource(id = R.drawable.rectangle),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(size = 35.dp))
                            .padding(45.dp)
                    )
                    Text(
                        text = "Name: ${docg?.name}",
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontFamily = fontFamily, fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(65.dp)
                    )
                    Text(
                        text = "Registration Number: ${docg?.registrationNumber}",
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontFamily = fontFamily, fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(65.dp)
                            .align(Alignment.CenterStart)
                    )
                    Text(
                        text = "Specialization: ${docg?.specialization}",
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontFamily = fontFamily, fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(65.dp)
                            .align(Alignment.BottomStart)
                    )
                }
            }

        }
        Box( modifier=Modifier.align(Alignment.CenterHorizontally).offset(y= 30.dp)) {


            Image(
                painter = painterResource(id = R.drawable.green1),
                contentDescription = null,
                modifier = Modifier
                    .clickable { println("Button Clicked!") }
                    .offset(y = 80.dp)

            )
            Text(text = "patient history",
                modifier = Modifier
                    .clickable {  }
                    .offset(y =80.dp)
                    .align(Alignment.Center),
                fontSize = 18.sp,
//            fontFamily= FontFamily(),
                fontWeight = FontWeight.SemiBold,
                color = Color.White)


        }
//        Text(text = "sign out",
//            modifier = Modifier
//                .align(Alignment.CenterHorizontally)
//                .clickable { println("Button Clicked!") }
//                .offset(y = 200.dp),
//            fontSize = 20.sp,
////            fontFamily= FontFamily(),
//            fontWeight = FontWeight.SemiBold,
//            color = Color.White
//
//        )
    }
}