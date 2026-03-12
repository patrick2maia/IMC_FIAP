package br.com.fiap.imc.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pesagens")
data class Pesagem(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "data_pesagem")
    val dataPesagem: String = "",

    val peso: Double = 0.0,
    val altura: Double = 0.0,
    val imc: Double = 0.0,
    val classificacao: String = ""

)
