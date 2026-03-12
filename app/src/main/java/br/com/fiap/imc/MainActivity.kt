package br.com.fiap.imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.imc.ui.telas.HomeScreen
import br.com.fiap.imc.ui.telas.TelaImc
import br.com.fiap.imc.ui.telas.TelaListaPesagens
import br.com.fiap.imc.ui.theme.IMCTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            IMCTheme {

                // Criar o esquema de navegação
                var navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable(route = "home"){ HomeScreen(navController) }
                    composable(route = "telaImc"){ TelaImc(navController) }
                    composable(route = "lista"){ TelaListaPesagens(navController) }
                }

            }
        }
    }
}
