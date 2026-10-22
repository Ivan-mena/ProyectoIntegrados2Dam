
package com.iesejemplo.llaves

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.iesejemplo.llaves.ui.screens.LoansScreen
import com.iesejemplo.llaves.ui.theme.AppLlavesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppLlavesTheme {
                LoansScreen()
            }
        }
    }
}
