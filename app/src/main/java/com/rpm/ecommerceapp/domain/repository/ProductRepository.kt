package com.rpm.ecommerceapp.domain.repository

import com.rpm.ecommerceapp.domain.model.Product
import com.rpm.ecommerceapp.utils.Resource

interface ProductRepository {

    suspend fun fetchAllProducts(): Resource<List<Product>>

    suspend fun getAllProductsCache(): List<Product>

    suspend fun insertProductsCache(products: List<Product>)

}