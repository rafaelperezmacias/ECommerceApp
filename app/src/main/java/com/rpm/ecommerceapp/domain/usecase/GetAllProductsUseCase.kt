package com.rpm.ecommerceapp.domain.usecase

import com.rpm.ecommerceapp.domain.model.Product
import com.rpm.ecommerceapp.domain.repository.ProductRepository
import com.rpm.ecommerceapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    suspend operator fun invoke(): Resource<List<Product>> {
        return withContext(Dispatchers.IO) {
            val networkCall = repository.fetchAllProducts()

            if ( networkCall is Resource.Error ) {
                Resource.Error(networkCall.error)
            }

            networkCall as Resource.Success
            repository.insertProductsCache(networkCall.data)
            val productList = repository.getAllProductsCache()
            Resource.Success(productList)
        }
    }

}