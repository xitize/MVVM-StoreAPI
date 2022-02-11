package com.telect.rrmvvm.lang

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LanguageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLanguage(language: Language)

    @Query("SELECT * FROM language ORDER BY languageName DESC")
    suspend fun getAllLanguages(): List<Language>

}