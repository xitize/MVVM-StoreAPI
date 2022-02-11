package com.telect.rrmvvm.di

import com.telect.rrmvvm.MainActivity
import com.telect.rrmvvm.StoreItemViewModel
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)


    fun getStoreItemVM(): StoreItemViewModel
}