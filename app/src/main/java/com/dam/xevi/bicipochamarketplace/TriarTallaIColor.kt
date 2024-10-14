package com.dam.xevi.bicipochamarketplace

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.dam.xevi.bicipochamarketplace.models.Bicicleta

class TriarTallaIColor : AppCompatActivity() {
    private lateinit var bicicleta: Bicicleta

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_triar_talla_icolor)

        bicicleta = intent.getSerializableExtra("bicicleta") as Bicicleta

        var tallesRG = findViewById<RadioGroup>(R.id.talles)
        var colorsRG = findViewById<RadioGroup>(R.id.colors)
        tallesRG.findViewWithTag<RadioButton>(bicicleta.talla).isChecked = true
        colorsRG.findViewWithTag<RadioButton>(bicicleta.color).isChecked = true
    }
    fun acceptar(view: View){
        val colors = findViewById<RadioGroup>(R.id.colors)
        val talles = findViewById<RadioGroup>(R.id.talles)
        val colorbt = colors.checkedRadioButtonId
        val tallabt = talles.checkedRadioButtonId
        bicicleta.color = findViewById<RadioButton>(colorbt).tag.toString()
        Log.d("Bicicleta", "Color actualizado: ${bicicleta.color}")
        bicicleta.talla = findViewById<RadioButton>(tallabt).tag.toString()
        val resultIntent = Intent()
        resultIntent.putExtra("resultBicicleta", bicicleta)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}