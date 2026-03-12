package br.com.fiap.imc.ui.telas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.imc.ui.theme.IMCTheme
import kotlinx.serialization.internal.throwMissingFieldException

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.align(
                Alignment.Center
            )
        ) {
            Text(
                text = "IMC",
                fontSize = 120.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF673AB7)
            )
            Text(
                text = "Mantenha a sua saúde",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF999996)
            )
        }
        Button(
            onClick = {
                navController.navigate("lista")
            },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .align(
                    Alignment.BottomCenter
                )
        ) {
            Text(
                text = "Começar"
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    IMCTheme() {
        //HomeScreen(NavHostController())
    }
}