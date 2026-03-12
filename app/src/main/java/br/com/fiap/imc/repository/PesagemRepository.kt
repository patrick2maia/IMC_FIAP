package br.com.fiap.imc.repository

import android.content.Context
import br.com.fiap.imc.dao.ImcDatabase
import br.com.fiap.imc.model.Pesagem

class PesagemRepository(context: Context) {

    private val db = ImcDatabase.getDatabase(context).pesagemDao()

    fun salvar(pesagem: Pesagem){
        db.salvar(pesagem)
    }

    fun listar(): List<Pesagem>{
        return db.listar()
    }

}