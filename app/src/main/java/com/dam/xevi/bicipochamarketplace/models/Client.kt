package com.dam.xevi.bicipochamarketplace.models

import java.io.Serializable

data class Client(
    var nom: String? = null,
    var cognom: String? = null,
    var direccioFacturacio: String? = null,
    var dni: String? = null,
    var telefon: String? = null,
    var correuElectronic: String? = null,
    var iva:Int = 21
) : Serializable