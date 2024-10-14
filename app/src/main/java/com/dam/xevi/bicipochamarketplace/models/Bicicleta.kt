package com.dam.xevi.bicipochamarketplace.models


import com.dam.xevi.bicipochamarketplace.models.components.*
import java.io.Serializable

data class Bicicleta(
    var model : String,
    var marca :String,
    var preu : Double,
    var talla: String  = "S",
    var color: String  = "Negre",
    var quadre: Quadre = Quadre("Alumini Shimano",0.0, "Quadre alumini marca Shimano"),
    var canvi: Canvi = Canvi("Shimano Ultegra 10v", 0.0, "Canvi Shimano Ultegra 10 velocitats" ),
    var frens: Freno = Freno("Shimano Ultegra tambor", 0.0, "Freno de llanta Shimano Ultegra"),
    var llantes: Llanta = Llanta("Alumini Specialized", 0.0, "Llantes de alumini Specialized"),
    var seient: Seient = Seient("Specialized Bridge",0.0, "Seient Specialized Bridge"),
    var pedals: Pedal = Pedal("Shimano Ultegra", 0.0, "Pedals Shimano Ultegra"),
    var llum: Llum? = null,
    var garantia: Garantia = Garantia("Estandard", 0.0, "Garantia estandard de 3 anys"),
    var gps: GPS? = null,
    var portabidons: Portabidons? = null,
    var preuTotal: Double? = null
) : Serializable{
     fun calcularPreu(){
        var total = preu
        quadre?.let { total += it.preu }
        canvi?.let { total += it.preu }
        frens?.let { total += it.preu }
        llantes?.let { total += it.preu }
        gps?.let { total += it.preu }
        seient?.let { total += it.preu }
        pedals?.let { total += it.preu }
        llum?.let { total += it.preu }
        garantia?.let { total += it.preu }
        preuTotal = total
    }
}