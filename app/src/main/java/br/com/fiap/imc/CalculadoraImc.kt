package br.com.fiap.imc

import kotlin.math.pow

fun calcularImc(peso: Int, altura: Double): Double{

    val imc = peso / altura.pow(2)

    return imc

}

fun classificarImc(imc: Double): String {

    if (imc < 18.5) {
        return "Abaixo do peso"
    } else if (imc <= 25.0){
        return "Peso Ideal"
    } else {
        return "Acima do peso"
    }

}