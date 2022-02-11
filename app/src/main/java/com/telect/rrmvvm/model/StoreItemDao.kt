package com.telect.rrmvvm.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StoreItemDao {
    @Insert(onConflict = REPLACE)
    suspend fun setResponse(response: ResponseItem)

    @Query("SELECT * from item_tbl")
    fun getAllStoreItems(): Flow<List<ResponseItem>>

}