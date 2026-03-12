package br.com.fiap.imc.ui.telas.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.com.fiap.imc.R
import br.com.fiap.imc.ui.theme.IMCTheme

@Composable
fun Titulo(
    texto: String = ""
) {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.coracao_vermelho),
            contentDescription = "Logotipo da aplicação",
        )
        Text(
            text = texto,
            fontSize = 24.sp,
            color = Color.White
        )
    }

}

@Preview
@Composable
private fun TituloPreview() {
    IMCTheme {
        Titulo()
    }
}
