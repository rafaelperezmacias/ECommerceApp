package com.rpm.ecommerceapp.domain.model

data class Product(
    val id: String? = null,
    val name: String = "",
    val brand: String = "",
    val price: Int = INVALID_PRICE,
    val image: String = ""

) {

    companion object {

        const val INVALID_PRICE = -1

    }

}