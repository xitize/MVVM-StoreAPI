package com.telect.rrmvvm.di

import android.app.Application
import com.telect.rrmvvm.lang.LanguageDatabase
import com.telect.rrmvvm.model.StoreItemDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule(private val application: Application) {


    @Provides
    @Singleton
    fun provideDatabase(): LanguageDatabase {
        return LanguageDatabase.invoke(application)
    }


    @Provides
    fun provideStoreItemDao(languageDatabase: LanguageDatabase): StoreItemDao {
        return languageDatabase.getStoreItemDao()
    }


//    @Provides
//    @Binds
//    fun provideStoreItemDao(languageDatabase: LanguageDatabase): StoreItemDao {
//        return languageDatabase.getStoreItemDao()
//    }
}