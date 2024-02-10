package com.example.add1

//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import android.app.LauncherActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun ViewCart(medlist: List<Tablet>)
{
    val fontFamily = FontFamily(
        Font(R.font.jost_semibold, FontWeight.SemiBold)
    )


    LazyColumn {
        items(medlist) { medicine ->
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = medicine.name.value,
                    modifier = Modifier.padding(5.dp)
                )

            }
        }
    }

}
