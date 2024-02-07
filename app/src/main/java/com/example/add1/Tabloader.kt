package com.example.add1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Tabloader(modifier: Modifier = Modifier, maxmeds: Int): List<Tablet> {

//    data class Tablet(
//        val name: MutableState<String>,
//        val mg: MutableState<String>,
//        val quantity: MutableState<String>
//    )



    val medicine1 = Tablet(
        name = remember { mutableStateOf("") },
        mg = remember { mutableStateOf("") },
        quantity = remember { mutableStateOf(0) }
    )

    val medicine2 = Tablet(
        name = remember { mutableStateOf("") },
        mg = remember { mutableStateOf("") },
        quantity = remember { mutableStateOf(0) }
    )

    val medicine3 = Tablet(
        name = remember { mutableStateOf("") },
        mg = remember { mutableStateOf("") },
        quantity = remember { mutableStateOf(0) }
    )

    val medicine4 = Tablet(
        name = remember { mutableStateOf("") },
        mg = remember { mutableStateOf("") },
        quantity = remember { mutableStateOf(0) }
    )

    val medicine5 = Tablet(
        name = remember { mutableStateOf("") },
        mg = remember { mutableStateOf("") },
        quantity = remember { mutableStateOf(0) }
    )


    var medicines: List<Tablet> = listOf(medicine1)

    when(maxmeds)
    {
        1 -> {
             medicines = listOf(medicine1)
        }
        2 -> {
            medicines = listOf(medicine1,medicine2)
        }
        3 -> {
            medicines = listOf(medicine1,medicine2,medicine3)
        }
        4 -> {
            medicines = listOf(medicine1,medicine2,medicine3,medicine4)
        }
        5 -> {
            medicines = listOf(medicine1,medicine2,medicine3,medicine4,medicine5)
        }
    }



    val labels = listOf("Name", "MG", "Quantity")


    LazyColumn {
        items(medicines) { medicine ->
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = "Medicine ${medicines.indexOf(medicine)+1}",
                    modifier = Modifier.padding(5.dp)
                )
                TextField(
                    value = medicine.name.value,
                    onValueChange = { medicine.name.value = it },
                    label = { Text("Name") }
                )
                TextField(
                    value = medicine.mg.value,
                    onValueChange = { medicine.mg.value = it },
                    label = { Text("MG") }
                )
                TextField(
                    value = medicine.quantity.value.toString(),
                    onValueChange = { medicine.quantity.value = it.toInt() },
                    label = { Text("Quantity") }
                )
            }
        }
    }


    return medicines

}