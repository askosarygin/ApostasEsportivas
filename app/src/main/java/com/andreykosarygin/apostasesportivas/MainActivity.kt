package com.andreykosarygin.apostasesportivas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andreykosarygin.common.ui.theme.ApostasEsportivasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApostasEsportivasTheme {

            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ }
    ) {
        Text(text = "Register to choose a bookmaker")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ApostasEsportivasTheme {
        Greeting()
    }
}