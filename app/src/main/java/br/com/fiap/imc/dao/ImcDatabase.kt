package br.com.fiap.imc.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.imc.model.Pesagem

@Database(entities = [Pesagem::class], version = 1)
 abstract class ImcDatabase: RoomDatabase() {

    abstract fun pesagemDao(): PesagemDao

    companion object{
        private lateinit var instance: ImcDatabase

        fun getDatabase(context: Context): ImcDatabase{
            if (!::instance.isInitialized){ // singleton
                instance = Room
                    .databaseBuilder(
                        context,
                        ImcDatabase::class.java,
                        "imc_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration(true)
                    .build()
            }
            return instance
        }
    }





}