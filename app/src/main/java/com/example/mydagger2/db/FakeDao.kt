package com.example.mydagger2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mydagger2.model.Product

@Dao
interface FakeDao {

    @Insert
    suspend fun addProducts(product: List<Product>)

    @Query("Select * from Product")
    suspend fun getAllProducts(): List<Product>
}