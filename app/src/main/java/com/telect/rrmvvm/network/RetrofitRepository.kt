package com.telect.rrmvvm.network

import android.util.Log
import com.telect.rrmvvm.model.StoreItemDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RetrofitRepository @Inject constructor(
    private val retrofitService: RetrofitService,
    private val dao: StoreItemDao
) {

    suspend fun getProducts() = retrofitService.getProducts()

    fun getProductsListFromDB() = dao.getAllStoreItems()

    fun getLatestDataToDB() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                retrofitService.getProducts().forEach {
                    dao.setResponse(it)
                }
            } catch (e: Exception) {
                Log.i("KTZ", "failure loading :  " + e.localizedMessage)
            }

        }
    }


}