package com.telect.rrmvvm

import android.app.Application
import com.telect.rrmvvm.di.AppComponent
import com.telect.rrmvvm.di.AppModule
import com.telect.rrmvvm.di.DaggerAppComponent
import com.telect.rrmvvm.di.DatabaseModule

class MyApplication : Application() {

    val appComponent: AppComponent =
        DaggerAppComponent.builder().appModule(AppModule(this)).databaseModule(
            DatabaseModule(this)
        ).build()

}