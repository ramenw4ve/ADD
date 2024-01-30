package com.example.add1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.add1.graphs.Graph


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocHomepage(
    navController: NavController,modifier:Modifier=Modifier
) {
    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )

    var patid by remember {
        mutableStateOf("")
    }
    Box(
        modifier = modifier.fillMaxSize()


    ) {
        Image(
            painter = painterResource(id = R.drawable.docshome), contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
//    Column {
//
//
//        Box(modifier = Modifier.align(Alignment.CenterHorizontally))
//        {
//            Text(
//                text = "Add Patient",
//                fontSize = 24.sp,
//                color = Color.Black,
//                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold,
//                modifier = Modifier.padding(30.dp, top = 340.dp)
//            )
//            androidx.compose.foundation.Image(
//                painter = painterResource(id = R.drawable.pink2), contentDescription = null,
//                modifier = Modifier
//                    .align(Alignment.BottomCenter)
//                    .padding(top = 250.dp),
//                contentScale = ContentScale.Fit
//            )
//            TextField(
//                    value = patid,
//            {
//                patid = it
//            },
//            label = {
//                Text(text = "Patient ID")
//            },
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(bottom = 200.dp),
//            shape = RoundedCornerShape(30),
//            textStyle = TextStyle(
//                textAlign = TextAlign.Center,
//                fontSize = 20.sp,
//                color = Color.Gray,
//                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold,
//
//
//                )
//            )
//            Text(
//                text = "+ ADD PATIENT",
//                fontSize = 18.sp,
//                color = Color.White,
//                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold,
//                modifier = Modifier
//                    .align(Alignment.BottomCenter)
//                    .padding(bottom = 120.dp)
//                    .clickable {
//                        navController.navigate(BottomBarScreen.SelfP.route + "/$patid")
//                        patid = ""
//                    }
//
//            )
//
//
//
//
//
//        }
//
//
//
//
//
//    }
}