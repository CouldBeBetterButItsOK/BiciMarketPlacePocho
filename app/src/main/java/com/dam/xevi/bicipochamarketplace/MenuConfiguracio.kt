package com.dam.xevi.bicipochamarketplace

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam.xevi.bicipochamarketplace.models.Bicicleta

class MenuConfiguracio : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 100
    }
    private lateinit var bicicleta: Bicicleta

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
                val resultBicicleta = data?.getSerializableExtra("resultBicicleta") as? Bicicleta
            resultBicicleta?.let{
                Log.i("from size color", resultBicicleta.color.toString())
                bicicleta = resultBicicleta
                ActualitzarBicicleta()
                Toast.makeText(this, "Bicicleta rebuda: ${it.model}", Toast.LENGTH_SHORT).show()
            }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_configuracio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bicicleta = intent.getSerializableExtra("bicicleta") as Bicicleta
        ActualitzarBicicleta()




    }
    fun TirarEnrereBT(view: View) {
        val intent = Intent(this, TriarBicicletaInicial::class.java)
        startActivity(intent)
    }
    fun TriarCanviCuadroFreno(view: View){
        val intent = Intent(this, TriarQuadreCanviFrens::class.java)
        intent.putExtra("bicicleta", bicicleta)
        startActivityForResult(intent, REQUEST_CODE)
    }
    fun TriarTallaiColor(view: View) {
        val intent = Intent(this, TriarTallaIColor::class.java)
        intent.putExtra("bicicleta", bicicleta)
        startActivityForResult(intent, REQUEST_CODE)
     }
    fun TriarRodesSeientIPedals(view: View){
        val intent = Intent(this, TriarRodesSeientIPedals::class.java)
        intent.putExtra("bicicleta", bicicleta)
        startActivityForResult(intent, REQUEST_CODE)    }
    fun TriarGarantiaGPSPortabidons(view: View){
        val intent = Intent(this, TriarLlumGarantiaGPSPortabidons::class.java)
        intent.putExtra("bicicleta", bicicleta)
        startActivityForResult(intent, REQUEST_CODE)
    }
    fun ActualitzarBicicleta(){
        val bmarca = findViewById<TextView>(R.id.bmarca)
        val bmodel = findViewById<TextView>(R.id.bmodel)
        val btalla = findViewById<TextView>(R.id.btalla)
        val bcolor = findViewById<TextView>(R.id.bcolor)
        val bquadre = findViewById<TextView>(R.id.bquadre)
        val bcanvi = findViewById<TextView>(R.id.bcanvi)
        val bfrens = findViewById<TextView>(R.id.bfrens)
        val brodes = findViewById<TextView>(R.id.brodes)
        val bseient = findViewById<TextView>(R.id.bseient)
        val bpedals = findViewById<TextView>(R.id.bpedals)
        val bgarantia = findViewById<TextView>(R.id.bgarantia)
        val bgps = findViewById<TextView>(R.id.bgps)
        val bllum = findViewById<TextView>(R.id.bllum)
        val bportabidons = findViewById<TextView>(R.id.bportabidons)
        val preuquadre = findViewById<TextView>(R.id.preuquadre)
        val preucanvi = findViewById<TextView>(R.id.preucanvi)
        val preufrens = findViewById<TextView>(R.id.preufrens)
        val preurodes = findViewById<TextView>(R.id.preurodes)
        val preuseient = findViewById<TextView>(R.id.preuseient)
        val preupedals = findViewById<TextView>(R.id.preupedals)
        val preugarantia = findViewById<TextView>(R.id.preugarantia)
        val preugps = findViewById<TextView>(R.id.preugps)
        val preullum = findViewById<TextView>(R.id.preullum)
        val preuportabidons = findViewById<TextView>(R.id.preuportabidons)
        val preubici = findViewById<TextView>(R.id.preubici)
        val preutotal = findViewById<TextView>(R.id.preutotal)

        preubici.text = bicicleta.preu.toString()
        bmarca.text = bicicleta.marca
        bmodel.text = bicicleta.model
        btalla.text = bicicleta.talla
        bcolor.text = bicicleta.color
        bquadre.text = bicicleta.quadre?.nom
        preuquadre.text = bicicleta.quadre?.preu?.toString()
        bcanvi.text = bicicleta.canvi?.nom
        preucanvi.text = bicicleta.canvi?.preu?.toString()
        bfrens.text = bicicleta.frens?.nom
        preufrens.text = bicicleta.frens?.preu?.toString()
        brodes.text = bicicleta.llantes?.nom
        preurodes.text = bicicleta.llantes?.preu?.toString()
        bseient.text = bicicleta.seient?.nom
        preuseient.text = bicicleta.seient?.preu?.toString()
        bpedals.text = bicicleta.pedals?.nom
        preupedals.text = bicicleta.pedals?.preu?.toString()
        bgarantia.text = bicicleta.garantia?.nom
        preugarantia.text = bicicleta.garantia?.preu?.toString()
        bgps.text = bicicleta.gps?.nom
        preugps.text = bicicleta.gps?.preu?.toString()
        bllum.text = bicicleta.llum?.nom
        preullum.text = bicicleta.llum?.preu?.toString()
        bportabidons.text = bicicleta.portabidons?.nom
        preuportabidons.text = bicicleta.portabidons?.preu?.toString()
        bicicleta.calcularPreu()
        preutotal.text = bicicleta.preuTotal.toString()
    }
}