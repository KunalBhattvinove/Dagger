package com.example.mydagger2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mydagger2.db.FakeDao
import com.example.mydagger2.model.Product
import com.example.mydagger2.retrofit.Fake_API
import javax.inject.Inject

 class ProductRepository @Inject constructor(private val fakeApi: Fake_API, private val fakeDao: FakeDao) {

    private val _products = MutableLiveData<List<Product>>()
     val products: LiveData<List<Product>>
     get() = _products

    suspend fun getProducts()
    {
        val result = fakeApi.getProduct()
        if(result.isSuccessful && result.body()!= null)
        {   fakeDao.addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }

}