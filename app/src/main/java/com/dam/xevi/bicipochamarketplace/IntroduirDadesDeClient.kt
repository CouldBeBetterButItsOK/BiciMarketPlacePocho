package com.dam.xevi.bicipochamarketplace

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam.xevi.bicipochamarketplace.models.*

class IntroduirDadesDeClient : AppCompatActivity() {

    private lateinit var bicicleta: Bicicleta
    private var client: Client? = null
    private lateinit var nom: EditText
    private lateinit var cognom: EditText
    private lateinit var direccio: EditText
    private lateinit var dni: EditText
    private lateinit var telefon: EditText
    private lateinit var correu: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_introduir_dades_de_client)
        bicicleta = intent.getSerializableExtra("bicicleta") as Bicicleta
        client = intent.getSerializableExtra("client") as? Client

        nom = findViewById<EditText>(R.id.etNom)
        cognom = findViewById<EditText>(R.id.etCognom)
        direccio = findViewById<EditText>(R.id.etDireccioFacturacio)
        dni = findViewById<EditText>(R.id.etDni)
        telefon = findViewById<EditText>(R.id.etTelefon)
        correu = findViewById<EditText>(R.id.etCorreuElectronic)
        client?.let {
            ActualitzarClient()
            client = null
        }
    }
    fun ActualitzarClient(){
        client?.nom?.let { nom.setText(client?.nom) }
        client?.cognom?.let{cognom.setText(client?.cognom)}
        client?.direccioFacturacio?.let {direccio.setText(client?.direccioFacturacio) }
        client?.dni?.let {dni.setText(client?.dni) }
        client?.telefon?.let {telefon.setText(client?.telefon) }
        client?.correuElectronic?.let {correu.setText(client?.correuElectronic) }
    }
    fun acceptar(view: View){
        if(ComprovarCamps())
        {   CrearClient()
            val intent = Intent(this, EntregarFactura::class.java)
            intent.putExtra("client", client)
            intent.putExtra("bicicleta", bicicleta)
            startActivity(intent)
        }
    }
    fun back(view: View){
        CrearClient()
        val intent = Intent(this, MenuConfiguracio::class.java)
        intent.putExtra("bicicleta", bicicleta)
        intent.putExtra("client", client)
        startActivity(intent)
    }
    fun ErrorMessage(error: String){
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
    fun CrearClient(){
        client = Client(
            if (nom.text.isEmpty()) null else nom.text.toString(),
            if (cognom.text.isEmpty()) null else cognom.text.toString(),
            if (direccio.text.isEmpty()) null else direccio.text.toString(),
            if (dni.text.isEmpty()) null else dni.text.toString(),
            if (telefon.text.isEmpty()) null else telefon.text.toString(),
        )
    }
    fun ComprovarCamps(): Boolean{
        if(nom.text.isEmpty()) {
            ErrorMessage("El nom és obligatori")
            return false
        }
        if(cognom.text.isEmpty()) {
            ErrorMessage("El cognom és obligatori")
            return false
        }
        if(direccio.text.isEmpty()) {
            ErrorMessage("La direcció és obligatòria")
            return false
        }
        if(dni.text.isEmpty()) {
            ErrorMessage("El DNI és obligatori")
            return false
        }
        if(telefon.text.length != 9 || telefon.text.toString().toIntOrNull() == null) {
            ErrorMessage("Número de telèfon incorrecte")
            return false
        }
        val emailPattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"
        if (!correu.text.matches(emailPattern.toRegex())) {
            ErrorMessage("El correu electrònic no és válid")
            return false
        }
        else return true
    }
}