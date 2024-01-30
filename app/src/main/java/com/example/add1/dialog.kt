package com.example.add1


import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DialogExamples() {
    // ...
    val openAlertDialog = remember { mutableStateOf(false) }
    var confirmationText by remember { mutableStateOf("") }

    Button(onClick = { openAlertDialog.value = true }) {
        Text("Show Dialog")
    }
    
    Text(text = confirmationText.toString(),
        modifier = Modifier.offset(y = 30.dp))

    // ...
    when {
        // ...
        openAlertDialog.value -> {
            AlertDialogExample(
                onDismissRequest = { openAlertDialog.value = false
                                   confirmationText = "Dismissed"},
                onConfirmation = {
                    tfv ->
                    confirmationText = tfv
                    openAlertDialog.value = false
                     // Add logic here to handle confirmation.
                },
                dialogTitle = "Add Patient",
//                dialogText = "This is an example of an alert dialog with buttons.",
//                icon = Icons.Default.Info
            )
        }
    }
}
