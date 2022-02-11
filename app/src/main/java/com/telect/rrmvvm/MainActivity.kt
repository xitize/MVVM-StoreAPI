package com.telect.rrmvvm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.telect.rrmvvm.databinding.ActivityMainBinding
import com.telect.rrmvvm.lang.LanguageDatabase
import com.telect.rrmvvm.network.RetrofitRepository
import com.telect.rrmvvm.network.RetrofitService
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var vm: StoreItemViewModel
    lateinit var rv: MainRVAdapter

    @Inject
    lateinit var retrofitService: RetrofitService

    @Inject
    lateinit var languageDatabase: LanguageDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (applicationContext as MyApplication).appComponent
        appComponent.inject(this)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rv = MainRVAdapter()
        binding.rvMain.adapter = rv

//        vm = ViewModelProvider(
//            this,
//            StoreViewModelFactory(
//                RetrofitRepository(
//                    retrofitService,
//                    languageDatabase.getStoreItemDao()
//                )
//            )
//        )[StoreItemViewModel::class.java]

//        binding.btnAdd.setOnClickListener {
//            val random = (12..1545).random()
//            val lst = listOf(ResponseItem("", 45.5, Rating(4.5, 3), "", random))
//            vm.addStoreItem(lst)
//        }


        lifecycleScope.launch {
            vm.getProductFromDB().collect {
                Log.i("KTZ", "onCreate: $it")
                rv.setData(it)
            }
        }


//        vm.storeList.observe(this) {
//            Log.d("KTZ", "size : $it")
//        }


//        vm.getProducts().observe(this) {
//            Log.i("KTZ", "onCreate Data: $it")
//        }


//        vm.getProducts().observe(this) {
//            it.let { res ->
//                when (res.status) {
//                    Status.SUCCESS -> {
//                        Log.i("KTZ", "onCreate: rv_visible")
//                        res.data.let { data ->
//                            Log.d("KTZ", "$data")
//                        }
//
//                    }
//
//                    Status.ERROR -> {
//                        Log.i("KTZ", "Error ${res.message}")
//                        Toast.makeText(this, "Error ${res.message}", Toast.LENGTH_SHORT).show()
//                    }
//
//
//                    Status.LOADING -> {
//                        Log.i("KTZ", "onCreate: loading")
//                    }
//                }
//            }
//        }

//        vm.productLists.observe(this) {
//            Log.d("KTZ", "response : $it")
//        }
//        vm.errorMessage.observe(this) {
//            Log.i("KTZ", "onCreate: $it")
//        }

    }
}