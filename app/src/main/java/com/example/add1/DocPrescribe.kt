package com.example.add1

import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMed(patid: String?,toke:String) {



    val ktorClient = KtorClient()


    var quantity by remember {
        mutableStateOf("")
    }
    var days by remember {
        mutableStateOf("")
    }
    var time by remember {
        mutableStateOf("")
    }

    var shouldaddtolist by remember {
        mutableStateOf(false)
    }

    var shouldPrescribe by remember {
        mutableStateOf(false)
    }

    var mutablemedicinelist by remember {
        mutableStateOf( mutableStateListOf<MutableCoffee>())
    }
    var medicineList:List<Coffee>

    if(shouldaddtolist)
    {
        mutablemedicinelist.add(createNewCoffee())
        shouldaddtolist = false
    }



    Surface(
        color = Color(0xFF509B92),
        modifier = Modifier.fillMaxSize()
    )
    {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(contentAlignment = Alignment.Center) {// Box for upperdesign and button to add meds
                Image(
                    painterResource(id = R.drawable.upper_design_pthomepg),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Button(onClick = {

                    shouldaddtolist = true

                }) {
                    Text(text ="Add Medicine")
                }

                Button(onClick = {

                    shouldPrescribe = true

                },modifier = Modifier
                    .offset(y = -70.dp)
                    .width(175.dp)
                    .height(50.dp)) {
                    Text(text ="Prescribe")
                }
            }



            Box(// Box for the white rounded rectangle
                modifier = Modifier
                    .offset(y = -60.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp)
                    )
                    .fillMaxWidth()
//                    .height(500.dp)
                    .clip(shape = RoundedCornerShape(topStart = 26.dp, topEnd = 26.dp)),
                contentAlignment = Alignment.TopCenter
            )
            {

                LazyColumn {
                    items(mutablemedicinelist)
                    {
                        Box(//      Box for each frame
                            modifier = Modifier
                                .padding(10.dp)
                                .background(
                                    color = Color(0xFF69A9A1),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .width(350.dp)
//                    .height(50.dp)
                                .clip(shape = RoundedCornerShape(16.dp))
                                ,
                            contentAlignment = Alignment.Center
                        )
                        {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.SpaceEvenly
                            )
                            {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                )
                                {
                                    it.name.value = DropDown(
                                        modi = Modifier
                                            .width(140.dp)
                                            .padding(3.dp)
                                    )
                                    it.mg.value = MgDropDown(
                                        modi = Modifier
                                            .width(96.dp)
                                            .padding(3.dp),it.name.value

                                    )
                                    OutlinedTextField(
                                        value = it.quantity.value, onValueChange = {newval ->
                                            it.quantity.value = newval
                                        },
                                        label = {
                                            Text(
                                                text = "Quantity",
                                                fontSize = 13.sp,
                                                modifier = Modifier.offset(y = -7.dp)
                                            )
                                        },
                                        modifier = Modifier
                                            .padding(3.dp)
                                            .width(90.dp)
                                            .height(50.dp)
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .offset(y = -5.dp)
                                        .fillMaxWidth()
                                        .padding(2.dp),
                                    horizontalArrangement = Arrangement.SpaceEvenly,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    OutlinedTextField(
                                        value = it.days.value, onValueChange = {newval ->
                                            it.days.value = newval
                                        },
                                        label = {
                                            Text(
                                                text = "Days",
                                                fontSize = 14.sp,
                                                modifier = Modifier.offset(y = -7.dp)
                                            )
                                        },
                                        modifier = Modifier
                                            .padding(3.dp)
                                            .width(70.dp)
                                            .height(50.dp)
                                    )
                                    OutlinedTextField(
                                        value = it.time.value, onValueChange = {newval ->
                                            it.time.value = newval
                                        },
                                        label = {
                                            Text(
                                                text = "Time",
                                                fontSize = 14.sp,
                                                modifier = Modifier.offset(y = -7.dp)
                                            )
                                        },
                                        modifier = Modifier
                                            .padding(3.dp)
                                            .width(200.dp)
                                            .height(50.dp)
                                    )
                                }
                            }


                        }
                    }
                }

                LaunchedEffect(key1 = shouldPrescribe)
                {
                    medicineList = mutablemedicinelist.map {
                        Coffee(it.name.value,
                            it.mg.value,
                            it.quantity.value,
                            it.days.value,
                            it.time.value
                        )
                    }

                    val am = Postdocmeds(medicineList)
                    if(shouldPrescribe)
                    {
                        var resp = ktorClient.postMeds("312471",am,toke)
                    }
                    shouldPrescribe = false


                }






            }


        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(modi: Modifier = Modifier): String {
    val ktorClient = KtorClient()
    var allMedicines by remember {
        mutableStateOf<AllMed?>(null)
    }
    val context = LocalContext.current
    val coffeeDrinks = listOf("Dolo", "Augmentin 625", "Azithral 500", "Okacet", "Gelusil MPS","Survector","Dolo 500","Saridon","Zincovit")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }

    LaunchedEffect(key1 = Unit)
    {
        allMedicines = ktorClient.getAllMeds()
    }

    Box(
        modifier = modi

    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
            modifier = Modifier.height(50.dp)
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor(),
                textStyle = LocalTextStyle.current.copy(fontSize = 13.5.sp)

            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                allMedicines?.listOfMed?.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item.medName, fontSize = 13.sp) },
                        onClick = {
                            selectedText = item.medName
                            expanded = false
//                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
    return selectedText
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MgDropDown(modi: Modifier = Modifier, value: String): String {

    val ktorClient = KtorClient()

    var allMedicines by remember {
        mutableStateOf<AllMed?>(null)
    }
    LaunchedEffect(key1 = Unit)
    {
        allMedicines = ktorClient.getAllMeds()
    }

    val context = LocalContext.current
    val coffeeDrinks = listOf("650", "625", "500", "10","600","100","550","50")
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("-") }

    val medicineMap: HashMap<String, MutableList<String>> = HashMap()

    allMedicines?.listOfMed?.forEach{ medicine ->
        val medName = medicine.medName
        val medMg = medicine.medMg

        if(medicineMap.containsKey(medName))
        {
            medicineMap[medName]?.add(medMg.toString())
        }
        else
        {
            medicineMap[medName] = mutableListOf(medMg.toString())
        }
    }

    Box(
        modifier = modi
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            },
            modifier = Modifier.height(50.dp)
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor(),
                textStyle = LocalTextStyle.current.copy(fontSize = 13.sp)
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                medicineMap[value]?.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
            //                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }

    return selectedText
}


@Composable
fun createNewCoffee(): MutableCoffee {
    return MutableCoffee(
        remember { mutableStateOf("") },
        remember { mutableStateOf("") },
        remember { mutableStateOf("") },
        remember { mutableStateOf("") },
        remember { mutableStateOf("") }
    )
}

