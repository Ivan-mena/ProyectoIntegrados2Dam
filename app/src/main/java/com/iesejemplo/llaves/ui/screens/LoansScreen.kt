package com.iesejemplo.llaves.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Prestamo(
    val llave: String,
    val persona: String,
    val iniciales: String,
    val hora: String,
    val retrasado: Boolean = false
)

@Composable
fun LoansScreen() {

    val prestamos = remember {
        mutableStateListOf(
            Prestamo("Llave Aula 102", "Marta Gómez", "MG", "Desde las 08:15"),
            Prestamo("Llave Gimnasio", "Luis Fernández", "LF", "Desde las 09:00"),
            Prestamo("Llave Aula 201", "Carmen Ruiz", "CR", "Desde ayer, 17:30", true)
        )
    }

    val azul = Color(0xFF193F73)
    val fondo = Color(0xFFF2F5FA)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    azul,
                    RoundedCornerShape(
                        bottomStart = 24.dp,
                        bottomEnd = 24.dp
                    )
                )
                .padding(20.dp)
        ) {
            Text(
                text = "Préstamos activos",
                color = Color.White,
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${prestamos.size} llaves fuera de su sitio",
                color = Color.White,
                fontSize = 17.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        prestamos.forEach { prestamo ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 6.dp),
                shape = RoundedCornerShape(18.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(55.dp)
                            .background(
                                Color(0xFFFF9025),
                                CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = prestamo.iniciales,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {

                        Text(
                            text = prestamo.llave,
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            color = Color(0xFF172439)
                        )

                        Text(
                            text = prestamo.persona,
                            fontSize = 15.sp
                        )

                        Text(
                            text = prestamo.hora,
                            fontSize = 13.sp,
                            color = Color.Gray
                        )

                        if (prestamo.retrasado) {
                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "Sin devolver",
                                color = Color(0xFFA83425),
                                modifier = Modifier
                                    .background(
                                        Color(0xFFF9E1DC),
                                        RoundedCornerShape(20.dp)
                                    )
                                    .padding(8.dp),
                                fontSize = 12.sp
                            )
                        }
                    }

                    OutlinedButton(
                        onClick = {
                            prestamos.remove(prestamo)
                        },
                        modifier = Modifier.height(44.dp),
                        contentPadding = PaddingValues(horizontal = 10.dp),
                        border = androidx.compose.foundation.BorderStroke(
                            1.dp, azul
                        )
                    ) {
                        Text(
                            text = "Devolver",
                            color = azul,
                            fontSize = 13.sp
                        )
                    }
                }
            }
        }
    }
}
