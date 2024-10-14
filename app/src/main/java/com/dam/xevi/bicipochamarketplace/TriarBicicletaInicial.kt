package com.dam.xevi.bicipochamarketplace

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam.xevi.bicipochamarketplace.models.Bicicleta
import com.dam.xevi.bicipochamarketplace.models.components.*

class TriarBicicletaInicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_triar_bicicleta_inicial)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun biciMontanya(view: View){
        val bicicleta = Bicicleta("Model1Muntanya", "Marca1Muntanya", 700.00,)
        val intent = Intent(this,MenuConfiguracio::class.java)
        intent.putExtra("bicicleta", bicicleta)
        startActivity(intent)
    }
    fun biciCarretera(view: View){
        val bicicleta = Bicicleta("Model2Carretera", "Marca2Carretera", 1200.00)
        val intent = Intent(this,MenuConfiguracio::class.java)
        intent.putExtra("bicicleta", bicicleta)
        startActivity(intent)
    }
}