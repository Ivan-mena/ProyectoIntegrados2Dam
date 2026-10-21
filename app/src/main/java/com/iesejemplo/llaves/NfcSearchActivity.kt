package com.iesejemplo.llaves

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.iesejemplo.llaves.ui.theme.AppLlavesTheme

class NfcSearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLlavesTheme {
                BuscarLlaveScreen()
            }
        }
    }
}
