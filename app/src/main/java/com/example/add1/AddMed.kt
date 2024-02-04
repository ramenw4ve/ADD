package com.example.add1

import android.annotation.SuppressLint
import android.app.ActionBar.Tab
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
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
import com.example.add1.graphs.Graph


@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMedicine(
    modifier: Modifier = Modifier,
                patid:Int
) {
//    var patid = 248480
    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )

    val ktorClient = KtorClient()

    var patS by remember {
        mutableStateOf<SPatient?>(null)
    }

    var snackbarHostState = remember {
        SnackbarHostState()
    }
//
//    data class Tablet(
//        val name: MutableState<String>,
//        val mg: MutableState<String>,
//        val quantity: MutableState<String>
//    )
//
//
//    val medicine1 = Tablet(
//        name = remember { mutableStateOf("") },
//        mg = remember { mutableStateOf("") },
//        quantity = remember { mutableStateOf("") }
//    )
//
//    val medicine2 = Tablet(
//        name = remember { mutableStateOf("") },
//        mg = remember { mutableStateOf("") },
//        quantity = remember { mutableStateOf("") }
//    )
//
//    val medicine3 = Tablet(
//        name = remember { mutableStateOf("") },
//        mg = remember { mutableStateOf("") },
//        quantity = remember { mutableStateOf("") }
//    )
//
//    val medicine4 = Tablet(
//        name = remember { mutableStateOf("") },
//        mg = remember { mutableStateOf("") },
//        quantity = remember { mutableStateOf("") }
//    )
//
    val medicine5 = Tablet(
        name = remember { mutableStateOf("") },
        mg = remember { mutableStateOf("") },
        quantity = remember { mutableStateOf("") }
    )
//
//
//    val medicines = listOf(medicine1, medicine2,medicine3,medicine4,medicine5)

    val labels = listOf("Name", "MG", "Quantity")

    var medicines:List<Tablet> = listOf(medicine5)


    var shouldaddMedicine by remember {
        mutableStateOf(false)
    }
    var shouldshowtabs by remember {
        mutableStateOf(false)
    }

    var toke by remember {
        mutableStateOf<String>("")
    }
    var resp by remember {
        mutableStateOf<String>("")
    }
    var tabno by remember {
        mutableStateOf<String>("")
    }
    var maxMedicinesToDisplay by remember {
        mutableStateOf(2)
    }

    LaunchedEffect(key1 = Unit) {

        patS = ktorClient.getSPatient(patid.toString())

    }


    Box(
        modifier = modifier.fillMaxSize()


    ) {
        Image(
            painter = painterResource(id = R.drawable.addmedpage), contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column {


            Row(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(20.dp)
                    .offset(y = 20.dp)
            )
            {
                Text(
                    text = "PATIENT NAME: ${patS?.name} \nPhone  Number: ${patS?.phoneNumber} \nPatient Id: ${patS?.uniqueId} ",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontFamily = fontFamily, fontWeight = FontWeight.SemiBold
                )
                Image(
                    painter = painterResource(id = R.drawable.logo2), contentDescription = null,
                    modifier = Modifier

                        .padding(5.dp)
                        .offset(y = 0.dp),
                    contentScale = ContentScale.Fit

                )
            }



            Box(modifier = Modifier.offset(y = 90.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.rectaddmed),
                    contentDescription = null,
                    modifier = Modifier


                        .offset(y = 0.dp),
                    contentScale = ContentScale.FillBounds

                )

                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

//                    Column {
//                        for ((index, medicine) in medicines.withIndex()) {
//                            // Create a column for each medicine
//                            Column(modifier = Modifier.padding(8.dp)) {
//                                Text(
//                                    text = "Medicine $index",
//                                    modifier = Modifier.padding(5.dp)
//                                )
//                                TextField(
//                                    value = medicine.name.value, // Access state value
//                                    onValueChange = {
//                                        medicine.name.value = it
//                                    }, // Update state value
//                                    label = { Text("Name") }
//                                )
//                                TextField(
//                                    value = medicine.mg.value,
//                                    onValueChange = { medicine.mg.value = it },
//                                    label = { Text("MG") }
//                                )
//                                TextField(
//                                    value = medicine.quantity.value,
//                                    onValueChange = { medicine.quantity.value = it },
//                                    label = { Text("Quantity") }
//                                )
//                            }
//                        }
//                    }
//
                    Button(onClick = {


                        shouldaddMedicine = true

                    }, modifier = Modifier.offset(y = 0.dp)) {
                        Text(text = "Add Medicines")
                    }
                    SnackbarHost(hostState = snackbarHostState, modifier = Modifier.offset(y = -150.dp))


//                    TextField(value = tabno,
//                        {
//                            tabno = it
//                        })
//                    Button(onClick = {
//                        val maxMedicinesToDisplay = tabno.toInt()
//                                     tabno = ""
//
//                    }, modifier = Modifier.offset(y = 0.dp)) {
//                        Text(text = "Generate")
//                    }

                    TextField(value = tabno,
                        {
                            tabno = it
                        })
                    Button(onClick = {
                        maxMedicinesToDisplay = tabno.toInt()
                        tabno = ""
                        shouldshowtabs = true

                    }, modifier = Modifier.offset(y = 0.dp)) {
                        Text(text = "Generate")
                    }
                    if (shouldshowtabs){
                        medicines = Tabloader(Modifier, maxMedicinesToDisplay)
                        Text(text = maxMedicinesToDisplay.toString())
//                        shouldshowtabs = false
                    }


//                    LazyColumn {
//                        items(medicines) { medicine ->
//                            Column(modifier = Modifier.padding(8.dp)) {
//                                Text(
//                                    text = "Medicine ${medicines.indexOf(medicine)}",
//                                    modifier = Modifier.padding(5.dp)
//                                )
//                                TextField(
//                                    value = medicine.name.value,
//                                    onValueChange = { medicine.name.value = it },
//                                    label = { Text("Name") }
//                                )
//                                TextField(
//                                    value = medicine.mg.value,
//                                    onValueChange = { medicine.mg.value = it },
//                                    label = { Text("MG") }
//                                )
//                                TextField(
//                                    value = medicine.quantity.value,
//                                    onValueChange = { medicine.quantity.value = it },
//                                    label = { Text("Quantity") }
//                                )
//                            }
//                        }
//                    }


                    val medicineList = medicines.map {
                        Medicine(
                            name = it.name.value,
                            mg = it.mg.value,
                            quantity = it.quantity.value
                        )
                    }

                    val am = AMedicines(medicineList)



//                    Scaffold(

//                        modifier = Modifier.offset(y = -70.dp).align(Alignment.CenterHorizontally)
//                    ) {
//                        Box(
//                            contentAlignment = Alignment.Center,
//                            modifier = Modifier.offset(y = -20.dp)
//                        ) {

                            LaunchedEffect(key1 = shouldaddMedicine) {
                                if (shouldaddMedicine) {
                                    toke =
                                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI2NWIxZTY0YWU2OWYwZGUyNWM1MmExYjAiLCJpYXQiOjE3MDY5NDAwODgsImV4cCI6MTcwNjk0MzY4OH0.U95LMr6zgNxl50XqhbZWFgMeCvplYL18kYCKuB4C2tM"
                                    resp = ktorClient.postMeds("248480", am, toke)

                                    snackbarHostState.showSnackbar(
                                        resp.toString()
                                    )

                                }
                                shouldaddMedicine = false
                            }
                        }
                    }

                }
            }
        }

//}


