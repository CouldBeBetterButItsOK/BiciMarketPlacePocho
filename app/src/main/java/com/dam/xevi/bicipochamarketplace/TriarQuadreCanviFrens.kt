package com.dam.xevi.bicipochamarketplace

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.dam.xevi.bicipochamarketplace.models.Bicicleta
import com.dam.xevi.bicipochamarketplace.models.components.*

class TriarQuadreCanviFrens : AppCompatActivity() {
    private lateinit var bicicleta: Bicicleta
    private lateinit var cuadrosid: RadioGroup
    private lateinit var canvisid: RadioGroup
    private lateinit var frensid: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_triar_quadre_canvi_frens)

        bicicleta = intent.getSerializableExtra("bicicleta") as Bicicleta
        cuadrosid = findViewById(R.id.quadres)
        canvisid = findViewById(R.id.canvis)
        frensid = findViewById(R.id.frens)
            val tagBiciQuadre = "${bicicleta.quadre.nom}/${bicicleta.quadre.preu}/${bicicleta.quadre.description}"
            val tagBiciCanvi = "${bicicleta.canvi.nom}/${bicicleta.canvi.preu}/${bicicleta.canvi.description}"
            val tagBiciFrens = "${bicicleta.frens.nom}/${bicicleta.frens.preu}/${bicicleta.frens.description}"

            cuadrosid.findViewWithTag<RadioButton>(tagBiciQuadre).isChecked = true
            canvisid.findViewWithTag<RadioButton>(tagBiciCanvi).isChecked = true
            frensid.findViewWithTag<RadioButton>(tagBiciFrens).isChecked = true

    }
    fun acceptar(view: View){
        val canviid = canvisid.checkedRadioButtonId
        val frenoid = frensid.checkedRadioButtonId
        val cuadroid = cuadrosid.checkedRadioButtonId
        val canviList = findViewById<RadioButton>(canviid).tag.toString().split("/")
        val frenoList = findViewById<RadioButton>(frenoid).tag.toString().split("/")
        val cuadroList = findViewById<RadioButton>(cuadroid).tag.toString().split("/")
        bicicleta.quadre = Quadre(cuadroList[0],cuadroList[1].toDouble(),cuadroList[2])
        bicicleta.frens = Freno(frenoList[0],frenoList[1].toDouble(),frenoList[2])
        bicicleta.canvi = Canvi(canviList[0],canviList[1].toDouble(),canviList[2])

        val resultIntent = Intent()
        resultIntent.putExtra("resultBicicleta", bicicleta)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}