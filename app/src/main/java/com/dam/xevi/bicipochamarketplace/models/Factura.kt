package com.dam.xevi.bicipochamarketplace.models

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date

data class Factura (
    var client: Client,
    var bicicleta: Bicicleta,
    var data: Date
): Serializable