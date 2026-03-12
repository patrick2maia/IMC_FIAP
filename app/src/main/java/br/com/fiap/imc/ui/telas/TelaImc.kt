package br.com.fiap.imc.ui.telas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import br.com.fiap.imc.calcularImc
import br.com.fiap.imc.ui.telas.componentes.Formulario
import br.com.fiap.imc.ui.telas.componentes.PainelResultado
import br.com.fiap.imc.ui.telas.componentes.Titulo
import br.com.fiap.imc.ui.theme.IMCTheme

@Composable
fun TelaImc(navController: NavHostController) {

    var imcUsuario by remember {
        mutableStateOf(0.0)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFD4D99B))
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        navController.navigate("home")
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Voltar"
                    )
                }
                Text(
                    text = "Dados do usuário"
                )
            }
            Titulo(texto = "Calculadora de IMC")
            Formulario(
                aoCalcular = {
                    imcUsuario = it
                }
            )
            PainelResultado(imcUsuario)
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun TelaImcPreview() {
    IMCTheme {
        TelaImc(NavHostController(LocalContext.current))
    }
}