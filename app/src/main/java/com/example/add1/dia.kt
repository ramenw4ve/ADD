package com.example.add1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp


@Composable
fun AlertDialogExample(
    onDismissRequest: () -> Unit,
    onConfirmation: (String) -> Unit,
    dialogTitle: String,
//    dialogText: String,
//    icon: ImageVector,
) {

    var tfv by remember {
        mutableStateOf("")
    }

    AlertDialog(
//        icon = {
//            Icon(icon, contentDescription = "Example Icon")
//        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Column {
                TextField(
                    value = tfv, {
                        tfv = it
                    },
                    shape = RoundedCornerShape(16.dp),
                    label = {
                        Text(text = "Enter Patient ID")
                    }
                )

            }

        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation(tfv)
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}