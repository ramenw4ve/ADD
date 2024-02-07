package com.example.add1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import android.util.Base64
import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.asImageBitmap
import kotlinx.coroutines.delay


@Composable
fun PatViewQR(toke:String) {

    val ktorClient = KtorClient()


    var patH by remember {
        mutableStateOf<HPatient?>(null)
    }
    var qr by remember {
        mutableStateOf<ViewQR?>(null)
    }
    
    var tex by remember {
        mutableStateOf("")
    }

//    var toke = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWFkMjBjNjMwODJmMWE1MjFiYzRjOWEiLCJpYXQiOjE3MDY5NDUzNjksImV4cCI6MTcwNjk0ODk2OX0.YjVx5aMrL8SzWaim4zD_o5rYADj5aGXJRC2vNmGYc1w"

    LaunchedEffect(key1 = Unit) {
        patH = ktorClient.getHPatient("home", toke.toString())

    }

    if(patH != null) {

        val objid = patH?._id

        LaunchedEffect(key1 = Unit) {
            qr = objid?.let { ktorClient.getQR(it) }

        }
    }


    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )

    val base64String = qr?.qrData?.replace("data:image/png;base64,","")
//    val base64String = "iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAYAAAB1PADUAAAAAklEQVR4AewaftIAAATASURBVO3BQY4jRxAEwfAC//9l1xzzVECjk6PVKszwR6qWnFQtOqladFK16KRq0UnVopOqRSdVi06qFp1ULTqpWnRSteikatFJ1aKTqkUnVYs+eQnIb1LzBJA31ExAJjVPALlRMwH5TWreOKladFK16KRq0SfL1GwC8k1qJiATkBsgk5obNROQJ9RsArLppGrRSdWik6pFn3wZkCfUPAHkRs0baiYgm9S8AeQJNd90UrXopGrRSdWiT/4yat5QMwGZ1ExAJiCTmhsgk5r/spOqRSdVi06qFn3yPwdkUjOpmYDcqJmA/J+cVC06qVp0UrXoky9T8ycB8m9Ss0nNn+SkatFJ1aKTqkWfLAPyJwEyqZmA3ACZ1ExA3gAyqbkB8ic7qVp0UrXopGoR/sh/GJBJzSYgT6i5ATKp+ZucVC06qVp0UrUIf+QFIJOaCcgmNTdAJjUTkEnNG0Bu1LwBZJOabzqpWnRSteikatEnL6n5JjUTkEnNE2omIE+oeQLIjZoJyDcBuVHzxknVopOqRSdVi/BHvgjIjZobIJOaJ4B8k5oJyKTmDSA3am6ATGq+6aRq0UnVopOqRZ/8MjUTkEnNpGYCcqNmUjMBeULNDZBJzQRkUjMBuVEzAbkBMqmZgNyoeeOkatFJ1aKTqkX4I4uATGomIJOaCcgTar4JyBtqJiCTmm8CcqNm00nVopOqRSdVi/BHfhGQSc0TQN5QMwGZ1HwTkEnNBOQNNTdAbtS8cVK16KRq0UnVIvyRRUDeUDMBmdQ8AWRS8waQSc03AZnUTEBu1ExAJjWbTqoWnVQtOqla9MlLQCY1N0CeUDMBmdR8E5BJzQRkUjMBuVHzBJA31ExAJjVvnFQtOqladFK16JNfpmYCMgG5UXMDZFIzAZnU3KiZgNwAmdQ8AWRS8waQ33RSteikatFJ1aJPlgGZ1ExAbtQ8AWRSMwG5AfKEmhsgE5AbNTdANqmZgGw6qVp0UrXopGoR/sgLQCY1TwB5Q80EZFJzA+QNNTdAJjU3QCY1TwCZ1Pymk6pFJ1WLTqoWffIvUzMBmdTcAPkmNTdAJjWTmm8C8gaQSc0bJ1WLTqoWnVQt+uTLgNyomdRMQJ5QMwGZ1NyomYA8AWRScwPkBsgTaiYgv+mkatFJ1aKTqkX4I/9hQJ5Q828CcqPmCSA3an7TSdWik6pFJ1WLPnkJyG9SM6mZgExqJiCTmieATGq+Ccik5k92UrXopGrRSdWiT5ap2QTkBsikZgJyA2RSMwGZ1DwBZFIzAblR84SaGyCTmk0nVYtOqhadVC365MuAPKFmk5oJyBNqboDcqHkCyCYgk5pvOqladFK16KRq0Sd/GSCTmhs1N0AmNZOaCcgNkEnNBGRS84aaCciNmjdOqhadVC06qVr0yV9GzQTkBsgTQCY1k5oJyBNqJiCTmgnIpGYCcqNm00nVopOqRSdVi/BHXgAyqdkEZFJzA+RGzQRkUvNNQG7UfBOQSc2mk6pFJ1WLTqoWfbIMyG8CcqNmAnID5Ak1E5AbNTdAbtTcALlR800nVYtOqhadVC3CH6laclK16KRq0UnVopOqRSdVi06qFp1ULTqpWnRSteikatFJ1aKTqkUnVYtOqhadVC36B7CcKzhWAKQcAAAAAElFTkSuQmCC"



//    val decodedBytes = Base64.decode(base64String, Base64.DEFAULT)
    val decodedBytes = base64String?.let { Base64.decode(it, Base64.DEFAULT) }


    Image(
        painter = painterResource(id = R.drawable.minbg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds
    )

    val bitmap = decodedBytes?.let {
        BitmapFactory.decodeByteArray(decodedBytes, 0, it.size) }
    val imageBitmap = bitmap?.asImageBitmap()


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFF9C9F))
            .offset(y = -25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Text(
            text = "Prescriptions",
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.offset(y = 30.dp)
        )

//        Text(qr?.qrData.toString().substring(0,3))



        Box (modifier = Modifier.offset(y = 0.dp),
            contentAlignment = Alignment.Center){
            Image(
                painter = painterResource(id = R.drawable.drectangle),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
            var re = listOf(1,2,3)
            Text("Doctor name: ${patH?.doctorName}"
                ,modifier = Modifier.offset(y = -280.dp)
            , fontSize = 22.sp,
                fontFamily  =fontFamily,
                fontWeight = FontWeight.SemiBold)
            Column(verticalArrangement = Arrangement.SpaceEvenly) {


                if (imageBitmap != null) {
                    Image(
                        bitmap = imageBitmap,
                        contentDescription = "Image from Base64",
                        modifier = Modifier
                            .size(220.dp)
                            .offset(y = -50.dp)
                    )
                }

//            LazyColumn(modifier  = Modifier.offset(y = 80.dp)) {
//                patH?.let {
//                    items(it.Medicines){ med ->
//                        Text(text = "Medicine Name: ${med.Medicine_name}")
//                        Text(text = "mg: ${med.mg}")
//                        Text(text = "quantity: ${med.quantity}")
//
//                        Spacer(modifier = Modifier.height(20.dp))
//                    }
//                }
//            }
                LazyColumn {
                    patH?.let {
                        items(it.Medicines) { med ->
                            Text(
                                text = "Medicine Name: ${med.Medicine_name}",
                                fontSize = 18.sp,
                                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "mg: ${med.mg}",
                                fontSize = 18.sp,
                                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "quantity: ${med.quantity}",
                                fontSize = 18.sp,
                                fontFamily = fontFamily, fontWeight = FontWeight.SemiBold
                            )

                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }

                }
            }
        }

    }

}