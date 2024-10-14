package com.dam.xevi.bicipochamarketplace.models.components

import java.io.Serializable

open class Product (
    var nom: String,
    var preu: Double,
    var description: String
) : Serializable
{

}