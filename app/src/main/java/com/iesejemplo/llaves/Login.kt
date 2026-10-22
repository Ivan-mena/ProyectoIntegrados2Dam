package com.iesejemplo.llaves

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iesejemplo.llaves.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLlavesTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var userText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Navy,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logotipo U-TAD
            Image(
                painter = painterResource(id = R.drawable.ic_utad_logo),
                contentDescription = stringResource(R.string.login_logo_content_description),
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(22.dp))
            )

            Spacer(Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.login_institution_name),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.login_subtitle),
                color = Color(0xFFD6E0F0),
                fontSize = 15.sp
            )

            Spacer(Modifier.height(32.dp))

            // Formulario
            Card(
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(20.dp)) {
                    Text(
                        text = stringResource(R.string.login_user_label),
                        color = InkDark,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(Modifier.height(6.dp))
                    OutlinedTextField(
                        value = userText,
                        onValueChange = { userText = it },
                        placeholder = { Text(stringResource(R.string.login_user_placeholder), color = Color.Gray) },
                        leadingIcon = { Icon(Icons.Outlined.Person, null, tint = Navy) },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(16.dp))

                    Text(
                        text = stringResource(R.string.login_password_label),
                        color = InkDark,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(Modifier.height(6.dp))
                    OutlinedTextField(
                        value = passwordText,
                        onValueChange = { passwordText = it },
                        placeholder = { Text(stringResource(R.string.login_password_placeholder), color = Color.Gray) },
                        leadingIcon = { Icon(Icons.Outlined.Lock, null, tint = Navy) },
                        visualTransformation = PasswordVisualTransformation(),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        shape = RoundedCornerShape(14.dp),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(24.dp))

                    Button(
                        onClick = { showDialog = true },
                        modifier = Modifier.fillMaxWidth().height(50.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Orange, contentColor = InkDark)
                    ) {
                        Text(stringResource(R.string.login_button), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.login_forgot_password),
                color = Color(0xFFD6E0F0),
                fontSize = 14.sp,
                modifier = Modifier.clickable { showDialog = true }.padding(8.dp)
            )
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text(stringResource(R.string.login_simulated_alert_button), color = Navy, fontWeight = FontWeight.Bold)
                }
            },
            title = { Text(stringResource(R.string.login_simulated_alert_title), fontWeight = FontWeight.Bold) },
            text = { Text(stringResource(R.string.login_simulated_alert_message)) },
            shape = RoundedCornerShape(20.dp),
            containerColor = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AppLlavesTheme {
        LoginScreen()
    }
}
