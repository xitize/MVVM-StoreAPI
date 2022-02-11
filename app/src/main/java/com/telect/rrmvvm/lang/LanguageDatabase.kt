package com.telect.rrmvvm.lang

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.telect.rrmvvm.model.StoreItemDao
import com.telect.rrmvvm.model.ResponseItem

@Database(entities = [Language::class, ResponseItem::class], version = 1)
abstract class LanguageDatabase : RoomDatabase() {
    abstract fun getLanguageDao(): LanguageDao
    abstract fun getStoreItemDao(): StoreItemDao

    companion object {
        @Volatile
        private var instance: LanguageDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) =
            instance ?: synchronized(LOCK) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            LanguageDatabase::class.java,
            "language_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}