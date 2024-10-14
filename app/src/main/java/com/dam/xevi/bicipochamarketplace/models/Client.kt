package com.dam.xevi.bicipochamarketplace.models

import java.io.Serializable

data class Client(
    var nom: String,
    var cognom: String,
    var direccioFacturacio: String,
    var dni: String,
    var telefon: String,
    var correuElectronic: String
) : Serializable