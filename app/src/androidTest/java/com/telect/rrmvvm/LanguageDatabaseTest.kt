package com.telect.rrmvvm

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.runner.AndroidJUnit4
import com.telect.rrmvvm.lang.LanguageDao
import com.telect.rrmvvm.lang.LanguageDatabase
import com.telect.rrmvvm.lang.Language
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LanguageDatabaseTest : TestCase() {
    lateinit var db: LanguageDatabase
    lateinit var dao: LanguageDao

    @Before
    public override fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, LanguageDatabase::class.java).build()
        dao = db.getLanguageDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun writeAndReadLanguage() = runBlocking {
        val language = Language("Java", "2 Years")
        dao.insertLanguage(language)
        val languageList = dao.getAllLanguages()
        Log.d("KTZ", "data : $languageList")
        assertTrue(languageList.contains(language))
    }
}