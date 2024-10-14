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


class TriarLlumGarantiaGPSPortabidons : AppCompatActivity() {
    private lateinit var bicicleta: Bicicleta
    private lateinit var portabidonsid: RadioGroup
    private lateinit var garantiesid: RadioGroup
    private lateinit var llumsid: RadioGroup
    private lateinit var gpsid: RadioGroup
    private lateinit var invisibleButton1: RadioButton
    private lateinit var invisibleButton2: RadioButton
    private lateinit var invisibleButton3: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_triar_llum_garantia_gpsportabidons)

        bicicleta = intent.getSerializableExtra("bicicleta") as Bicicleta
        portabidonsid = findViewById(R.id.portabidons)
        garantiesid = findViewById(R.id.garantia)
        llumsid = findViewById(R.id.llum)
        gpsid = findViewById(R.id.gps)
        val tagBiciPortabidons = "${bicicleta.portabidons?.nom}/${bicicleta.portabidons?.preu}/${bicicleta.portabidons?.description}"
        val tagBiciGarantia = "${bicicleta.garantia.nom}/${bicicleta.garantia.preu}/${bicicleta.garantia.description}"
        val tagBiciLlum = "${bicicleta.llum?.nom}/${bicicleta.llum?.preu}/${bicicleta.llum?.description}"
        val tagBiciGps = "${bicicleta.gps?.nom}/${bicicleta.gps?.preu}/${bicicleta.gps?.description}"
        if (bicicleta.portabidons != null) {
            portabidonsid.findViewWithTag<RadioButton>(tagBiciPortabidons).isChecked = true
        }

        garantiesid.findViewWithTag<RadioButton>(tagBiciGarantia).isChecked = true

        if (bicicleta.llum != null) {
            llumsid.findViewWithTag<RadioButton>(tagBiciLlum).isChecked = true
        }
        if (bicicleta.gps != null) {
            gpsid.findViewWithTag<RadioButton>(tagBiciGps).isChecked = true
        }
    }
    fun acceptar(view: View){
        val portabidonsidRB = portabidonsid.checkedRadioButtonId
        val garantiesidRB = garantiesid.checkedRadioButtonId
        val llumsidRB = llumsid.checkedRadioButtonId
        val gpsidRB = gpsid.checkedRadioButtonId

        val portabidonsList = findViewById<RadioButton>(portabidonsidRB).tag.toString().split("/")
        val garantiesList = findViewById<RadioButton>(garantiesidRB).tag.toString().split("/")
        val llumsList = findViewById<RadioButton>(llumsidRB).tag.toString().split("/")
        val gpsList = findViewById<RadioButton>(gpsidRB).tag.toString().split("/")
        if (portabidonsidRB != null) {
            bicicleta.portabidons = Portabidons(portabidonsList[0],portabidonsList[1].toDouble(),portabidonsList[2])
        }
        bicicleta.garantia = Garantia(garantiesList[0],garantiesList[1].toDouble(),garantiesList[2])
        if (llumsidRB != null) {
            bicicleta.llum = Llum(llumsList[0],llumsList[1].toDouble(),llumsList[2])
        }
        if (gpsidRB != null) {
            bicicleta.gps = GPS(gpsList[0],gpsList[1].toDouble(),gpsList[2])
        }

        val resultIntent = Intent()
        resultIntent.putExtra("resultBicicleta", bicicleta)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

}