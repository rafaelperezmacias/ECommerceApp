package com.rpm.ecommerceapp.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.rpm.ecommerceapp.data.local.ProductDao
import com.rpm.ecommerceapp.data.mapper.ProductMapper
import com.rpm.ecommerceapp.data.remote.FirestoreConstants
import com.rpm.ecommerceapp.domain.model.Product
import com.rpm.ecommerceapp.domain.repository.ProductRepository
import com.rpm.ecommerceapp.utils.Resource
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao,
    private val firestoreInstance: FirebaseFirestore
) : ProductRepository {

    override suspend fun fetchAllProducts(): Resource<List<Product>> {
        return try {
            val productList = firestoreInstance.collection(FirestoreConstants.PRODUCTS_COLLECTION)
                .get()
                .await()
                .toObjects(Product::class.java)
            Resource.Success(productList)
        } catch ( ex: Exception ) {
            Resource.Error(ex)
        }
    }

    override suspend fun getAllProductsCache(): List<Product> {
        val mapper = ProductMapper()
        return mapper.fromDTOListToDomainList(productDao.getAllProducts())
    }

    override suspend fun insertProductsCache(products: List<Product>) {
        val mapper = ProductMapper()
        productDao.insertAllProducts(mapper.fromDomainListTODTOList(products))
    }

}