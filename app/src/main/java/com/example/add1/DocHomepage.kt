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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
fun DocHomepage(toke:String,
    navController: NavController,modifier:Modifier=Modifier
) {
    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )

    val ktorClient = KtorClient()

    var patid by remember {
        mutableStateOf("")
    }

    var docH by remember {
        mutableStateOf<HDoctor_?>(null)
    }

    LaunchedEffect(key1 = Unit) {

        docH = ktorClient.getHDoctor_("home_", toke.toString())

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
    Column(modifier = Modifier.fillMaxWidth())
    {


        Text(
            text = "Latest Prescription",
            modifier = Modifier.offset(x=85.dp,y=250.dp),

            fontSize = 24.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (200).dp),
            contentAlignment = Alignment.Center
        )
        {
            Image(
                painter = painterResource(id = R.drawable.greenthing),
                contentDescription = null,
                contentScale = ContentScale.Crop,

                )

            Column(
                modifier = Modifier
                    .padding(end = 0.dp, bottom = 0.dp)
                    .offset(x = -30.dp)
            ) {

                Text(
                    text = "Patient Name: ${docH?.patientName}",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .offset(x = 34.dp, y = -39.dp)
                )
                Column(modifier = Modifier.offset(y = -15.dp)) {

                    Text(
                        text = "Patient ID: ${docH?.patientId}",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.SemiBold

                    )


                    Text(
                        text = "Number of Medicines: ${docH?.numberOfMedicines}",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.SemiBold

                    )
                }


            }
        }
    }

}