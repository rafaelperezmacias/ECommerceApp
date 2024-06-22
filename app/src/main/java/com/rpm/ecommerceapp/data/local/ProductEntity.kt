package com.rpm.ecommerceapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rpm.ecommerceapp.domain.model.Product.Companion.INVALID_PRICE

@Entity(
    tableName = "product"
)
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "brand") val brand: String = "",
    @ColumnInfo(name = "price") val price: Int = INVALID_PRICE,
    @ColumnInfo(name = "image") val image: String = ""
)