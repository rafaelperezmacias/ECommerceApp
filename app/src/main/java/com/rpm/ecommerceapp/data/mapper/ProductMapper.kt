package com.rpm.ecommerceapp.data.mapper

import com.rpm.ecommerceapp.data.local.ProductEntity
import com.rpm.ecommerceapp.domain.model.Product

class ProductMapper {

    fun fromDomainToDTO(product: Product): ProductEntity {
        return ProductEntity(
            id = product.id ?: "1",
            name = product.name,
            brand = product.brand,
            price = product.price,
            image = product.image
        )
    }

    fun fromDomainListTODTOList(productList: List<Product>): List<ProductEntity> {
        return productList.map { fromDomainToDTO(it) }
    }

    fun fromDTOToDomain(productEntity: ProductEntity): Product {
        return Product(
            id = productEntity.id,
            name = productEntity.name,
            brand = productEntity.brand,
            price = productEntity.price,
            image = productEntity.image
        )
    }

    fun fromDTOListToDomainList(productList: List<ProductEntity>): List<Product> {
        return productList.map { fromDTOToDomain(it) }
    }

}