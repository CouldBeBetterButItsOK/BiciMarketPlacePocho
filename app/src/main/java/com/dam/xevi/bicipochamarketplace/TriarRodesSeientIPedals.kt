package com.dam.xevi.bicipochamarketplace

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam.xevi.bicipochamarketplace.models.Bicicleta
import com.dam.xevi.bicipochamarketplace.models.components.*


class TriarRodesSeientIPedals : AppCompatActivity() {
    private lateinit var bicicleta: Bicicleta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_triar_rodes_seient_ipedals)
        bicicleta = intent.getSerializableExtra("bicicleta") as Bicicleta
        val tagBiciSeient = "${bicicleta.seient?.nom}/${bicicleta.seient.preu}/${bicicleta.seient.description}"
        val tagBiciPedal = "${bicicleta.pedals?.nom}/${bicicleta.pedals.preu}/${bicicleta.pedals.description}"
        val tagBiciRodes = "${bicicleta.llantes?.nom}/${bicicleta.llantes.preu}/${bicicleta.llantes.description}"
        findViewById<RadioGroup>(R.id.seientsRG).findViewWithTag<RadioButton>(tagBiciSeient).isChecked = true
        findViewById<RadioGroup>(R.id.rodesRG).findViewWithTag<RadioButton>(tagBiciRodes).isChecked = true
        findViewById<RadioGroup>(R.id.pedalsRG).findViewWithTag<RadioButton>(tagBiciPedal).isChecked = true
    }
    fun acceptar(view: View){
        val rodesId=  findViewById<RadioGroup>(R.id.rodesRG)
        val pedalsId = findViewById<RadioGroup>(R.id.pedalsRG)
        val seientsId = findViewById<RadioGroup>(R.id.seientsRG)
        val rodaId = rodesId.checkedRadioButtonId
        val pedalId = pedalsId.checkedRadioButtonId
        val seientId = seientsId.checkedRadioButtonId
        val rodesList = findViewById<RadioButton>(rodaId).tag.toString().split("/")
        val pedalsList = findViewById<RadioButton>(pedalId).tag.toString().split("/")
        val seientList = findViewById<RadioButton>(seientId).tag.toString().split("/")
        bicicleta.llantes = Llanta(rodesList[0],rodesList[1].toDouble(),rodesList[2])
        bicicleta.pedals = Pedal(pedalsList[0],pedalsList[1].toDouble(),pedalsList[2])
        bicicleta.seient = Seient(seientList[0],seientList[1].toDouble(),seientList[2])

        val resultIntent = Intent()
        resultIntent.putExtra("resultBicicleta", bicicleta)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}