package com.rpm.ecommerceapp.di

import android.content.Context
import androidx.room.Room
import com.rpm.ecommerceapp.data.local.EcommerceDatabase
import com.rpm.ecommerceapp.data.local.ProductDao
import com.rpm.ecommerceapp.data.local.RoomConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideEcommerceDatabase(
        @ApplicationContext context: Context
    ): EcommerceDatabase {
        return Room.databaseBuilder(
            context,
            EcommerceDatabase::class.java,
            RoomConstants.ECOMMERCE_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductsDao(db: EcommerceDatabase): ProductDao {
        return db.productDao()
    }

}