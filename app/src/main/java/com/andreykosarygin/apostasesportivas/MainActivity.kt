package com.andreykosarygin.apostasesportivas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.andreykosarygin.common.ui.theme.ApostasEsportivasTheme
import com.andreykosarygin.signup_ui.screen_signup.ScreenSignUp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApostasEsportivasTheme {
                ScreenSignUp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//        ApostasEsportivasTheme {
//            Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background).fillMaxSize()) {
//                Box(modifier = Modifier.background(color = Color.Blue).size(100.dp))
//            }
//        }
}