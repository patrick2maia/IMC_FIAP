package br.com.fiap.imc.ui.telas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.room.util.TableInfo
import br.com.fiap.imc.repository.PesagemRepository
import br.com.fiap.imc.ui.theme.IMCTheme

@Composable
fun TelaListaPesagens(navController: NavHostController) {

    val context = LocalContext.current
    val pesagemRepository = PesagemRepository(context)

    val pesagens = pesagemRepository.listar()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        Text(text = "Lista de pesagens")
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                navController.navigate("telaImc")
            }
        ) {
            Text(text = "+")
        }
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(pesagens){
                Card(
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = it.dataPesagem)
                        Text(text = it.classificacao)
                        Text(text = it.imc.toString())
                        Text(text = it.peso.toString())
                    }
                }
            }
        }


    }
}

@Preview(showSystemUi = true)
@Composable
private fun TelaListaPesagensPreview() {
    IMCTheme() {
        //TelaListaPesagens()
    }
}