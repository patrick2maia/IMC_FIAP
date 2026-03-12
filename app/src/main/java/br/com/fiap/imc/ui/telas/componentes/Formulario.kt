package br.com.fiap.imc.ui.telas.componentes

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.imc.calcularImc
import br.com.fiap.imc.classificarImc
import br.com.fiap.imc.model.Pesagem
import br.com.fiap.imc.repository.PesagemRepository
import br.com.fiap.imc.ui.theme.IMCTheme
import java.time.LocalDate

@Composable
fun Formulario(aoCalcular: (Double) -> Unit) {

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(
        "dados",
        Context.MODE_PRIVATE
    )

    // Obter instância do repositório
    val pesagemRepository = PesagemRepository(context)


    //val pesoSalvo = sharedPreferences.getString("peso", "")
    val alturaSalvo = sharedPreferences.getString("altura", "")

    var peso by remember {
        mutableStateOf( "") // Elvis Operator
    }

    var altura by remember {
        mutableStateOf(alturaSalvo ?: "")
    }

    Column(
        modifier = Modifier
            .padding(32.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Preencha os dados",
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = peso,
            onValueChange = { novoPeso ->
                peso = novoPeso
            },
            label = {
                Text(
                    text = "Digite o seu peso em Kg"
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = altura,
            onValueChange = { novaAltura ->
                altura = novaAltura
            },
            label = {
                Text(
                    text = "Digite a sua altura em metros"
                )
            },
            modifier = Modifier
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            //horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    peso = ""
                    altura = ""
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .padding(end = 2.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF9800),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "LIMPAR"
                )
            }
            //Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    val edit = sharedPreferences.edit()
                    edit.putString("peso", peso)
                    edit.putString("altura", altura)
                    edit.apply()

                    val imc = calcularImc(
                        peso = peso.toInt(),
                        altura = altura.toDouble()
                    )

                    val pesagem = Pesagem(
                        peso = peso.toDouble(),
                        altura = altura.toDouble(),
                        imc = imc,
                        classificacao = classificarImc(imc),
                        dataPesagem = LocalDate.now().toString()
                    )

                    pesagemRepository.salvar(pesagem)

                    aoCalcular(imc)
                } ,
                shape = RoundedCornerShape(
                    size = 8.dp
                ),
                modifier = Modifier
                    .padding(start = 2.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF009688)
                )
            ) {
                Text(
                    text = "CALCULAR"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FormularioPreview() {
    IMCTheme() {
        Formulario(aoCalcular = {})
    }
}