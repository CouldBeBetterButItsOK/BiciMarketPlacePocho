package com.dam.xevi.bicipochamarketplace
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dam.xevi.bicipochamarketplace.models.Bicicleta
import com.dam.xevi.bicipochamarketplace.models.Client
import com.dam.xevi.bicipochamarketplace.models.Factura
import java.util.Date

class EntregarFactura : AppCompatActivity() {
    private lateinit var factura: Factura
    private lateinit var bicicleta: Bicicleta
    private lateinit var client: Client
    private lateinit var nomClient: TextView
    private lateinit var cognomClient: TextView
    private lateinit var direccioClient: TextView
    private lateinit var dniClient: TextView
    private lateinit var tlfClient: TextView
    private lateinit var correuClient: TextView
    private lateinit var marcaBici: TextView
    private lateinit var modelBici: TextView
    private lateinit var preuBici: TextView
    private lateinit var tallaBici: TextView
    private lateinit var colorBici: TextView
    private lateinit var quadreBici: TextView
    private lateinit var quadreBiciDesc: TextView
    private lateinit var canviBici: TextView
    private lateinit var canviBiciDesc: TextView
    private lateinit var llantesBici: TextView
    private lateinit var llantesBiciDesc: TextView
    private lateinit var frensBici: TextView
    private lateinit var frensBiciDesc: TextView
    private lateinit var preuTotalBici: TextView
    private lateinit var preuIva: TextView
    private lateinit var ivaClient: TextView
    private lateinit var dateFactura: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_entregar_factura)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bicicleta = intent.getSerializableExtra("bicicleta") as Bicicleta
        client = intent.getSerializableExtra("client") as Client
        factura = Factura(client,bicicleta, Date())
        nomClient = findViewById(R.id.etNom)
        cognomClient = findViewById(R.id.etCognom)
        direccioClient = findViewById(R.id.etDireccio)
        dniClient = findViewById(R.id.etDNI)
        tlfClient = findViewById(R.id.etTelefon)
        correuClient = findViewById(R.id.etEmail)
        marcaBici = findViewById(R.id.etMarca)
        modelBici = findViewById(R.id.etModel)
        preuBici = findViewById(R.id.etPreu)
        tallaBici = findViewById(R.id.etTalla)
        colorBici = findViewById(R.id.etColor)
        quadreBici = findViewById(R.id.etQuadre)
        quadreBiciDesc = findViewById(R.id.descQuadre)
        canviBici = findViewById(R.id.etCanvi)
        canviBiciDesc = findViewById(R.id.descCanvi)
        llantesBici = findViewById(R.id.etLlantes)
        llantesBiciDesc = findViewById(R.id.descLlantes)
        frensBici = findViewById(R.id.etFrens)
        frensBiciDesc = findViewById(R.id.descFrens)
        preuTotalBici = findViewById(R.id.etPreuFinal)
        preuIva = findViewById(R.id.etPreuAmbIva)
        ivaClient = findViewById(R.id.etIva)
        dateFactura = findViewById(R.id.etData)
        dateFactura.setText(factura.data.toString())
        nomClient.setText(factura.client.nom)
        cognomClient.setText(factura.client.cognom)
        direccioClient.setText(factura.client.direccioFacturacio)
        dniClient.setText(factura.client.dni)
        tlfClient.setText(factura.client.telefon)
        correuClient.setText(factura.client.correuElectronic)
        marcaBici.setText(factura.bicicleta.marca)
        modelBici.setText(factura.bicicleta.model)
        colorBici.setText(factura.bicicleta.color)
        tallaBici.setText(factura.bicicleta.talla)
        preuBici.setText(factura.bicicleta.preu.toString()+"0€")
        quadreBici.setText(factura.bicicleta.quadre.nom +" "+factura.bicicleta.quadre.preu.toString()+"0€")
        quadreBiciDesc.setText(factura.bicicleta.quadre.description)
        canviBici.setText(factura.bicicleta.canvi.nom +"      "+factura.bicicleta.canvi.preu.toString()+"0€")
        canviBiciDesc.setText(factura.bicicleta.canvi.description)
        frensBici.setText(factura.bicicleta.frens.nom +"      "+factura.bicicleta.frens.preu.toString()+"0€")
        frensBiciDesc.setText(factura.bicicleta.frens.description)
        llantesBici.setText(factura.bicicleta.llantes.nom +"      "+factura.bicicleta.llantes.preu.toString()+"0€")
        llantesBiciDesc.setText(factura.bicicleta.llantes.description)
        preuTotalBici.setText(factura.bicicleta.preuTotal.toString())
        ivaClient.text = factura.client.iva.toString()
        val preuAmbIva = factura.bicicleta.preuTotal?.let {
            it * (1 + factura.client.iva / 100)
        }
        preuIva.text = preuAmbIva.toString()
    }
    fun Enviar(view: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    fun TornarEnrere(view: View){
        val intent = Intent(this,MenuConfiguracio::class.java)
        intent.putExtra("client", client)
        intent.putExtra("bicicleta", bicicleta)
        startActivity(intent)
    }
}