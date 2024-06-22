package com.rpm.ecommerceapp.di

import com.rpm.ecommerceapp.data.repository.ProductRepositoryImpl
import com.rpm.ecommerceapp.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindProductsRepository(productsRepository: ProductRepositoryImpl): ProductRepository

}