package br.com.fiap.imc.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.imc.model.Pesagem

@Dao
interface PesagemDao {

    @Insert
    fun salvar(pesagem: Pesagem)

    @Query("SELECT * FROM pesagens ORDER BY id DESC")
    fun listar(): List<Pesagem>

    @Delete
    fun excluir(pesagem: Pesagem)

    @Update
    fun atualizar(pesagem: Pesagem)

}