package com.rpm.ecommerceapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        ProductEntity::class
    ],
    version = 1
)
abstract class EcommerceDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}