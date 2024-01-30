package com.example.add1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.add1.R


@Composable
fun ViewCart()
{
    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )
//    var name by remember {
//        mutableStateOf("")
//    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFF9C9F)),
        horizontalAlignment = Alignment.CenterHorizontally,


        ){
        Image(
            painter = painterResource(id = R.drawable.self_prescription_top_design),
            contentDescription = null,
            modifier = Modifier.align(Alignment.End)
        )




        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(size = 40.dp))
                .background(Color.White)



        ){
            Image(
                painter = painterResource(id = R.drawable.generate_qr),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .offset(x = 39.dp, y = 500.dp)
                    .clickable {

                    }

            )
        }
    }
}
