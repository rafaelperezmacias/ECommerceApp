package com.rpm.ecommerceapp.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rpm.ecommerceapp.domain.model.Product
import com.rpm.ecommerceapp.domain.usecase.GetAllProductsUseCase
import com.rpm.ecommerceapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel() {

    private val _productList: MutableLiveData<Resource<List<Product>>> = MutableLiveData()
    val productList: LiveData<Resource<List<Product>>>
        get() = _productList

    init {
        getAllProducts()
    }

    private fun getAllProducts() {
        viewModelScope.launch {
            val products = getAllProductsUseCase()
            _productList.postValue(products)
        }
    }

}