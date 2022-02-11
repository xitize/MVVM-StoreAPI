package com.telect.rrmvvm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.telect.rrmvvm.model.ResponseItem
import com.telect.rrmvvm.network.RetrofitRepository
import com.telect.rrmvvm.utils.ResourceState
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class StoreItemViewModel @Inject constructor(private val repository: RetrofitRepository) :
    ViewModel() {
    val storeList = MutableLiveData<List<ResponseItem>>()
    val errorMessage = MutableLiveData<String>()

//    private var dao = LanguageDatabase(context).getStoreItemDao()

    val productLists = MutableLiveData<List<ResponseItem>>()

    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            dao.getAllStoreItems().collect {
//                storeList.postValue(it)
//            }
//        }
        repository.getLatestDataToDB()
    }

    fun getProductFromDB() = repository.getProductsListFromDB()


    fun getProducts() = liveData(Dispatchers.IO) {
        emit(ResourceState.loading(data = null))
        try {
            emit(ResourceState.success(data = repository.getProducts()))
        } catch (e: Exception) {
            Log.d("KTZ", e.localizedMessage)
            emit(ResourceState.error(data = null, message = e.localizedMessage ?: "Error Occurred"))
        }
    }


//    fun addStoreItem(items: List<ResponseItem>) {
//        viewModelScope.launch(Dispatchers.IO) {
//            items.forEach {
//                dao.setResponse(it)
//            }
//        }
//    }


    override fun onCleared() {
        super.onCleared()
        Log.i("KTZ", "onCleared: onViewModel Cleared")
    }
}


class StoreViewModelFactory(

    private val repository: RetrofitRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StoreItemViewModel::class.java)) {
            return StoreItemViewModel(repository) as T
        }
        throw IllegalArgumentException("unable to construct viewModel")

    }

}