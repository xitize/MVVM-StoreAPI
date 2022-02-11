package com.telect.rrmvvm.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Response(
    @field:SerializedName("Response")
    val response: List<ResponseItem?>? = null
)

data class Rating(
    @field:SerializedName("rate")
    val rate: Double? = null,

    @field:SerializedName("count")
    val count: Int? = null
)

@Entity(tableName = "item_tbl")
data class ResponseItem(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("price")
    val price: Double? = null,

    @Embedded(prefix = "rating")
    @field:SerializedName("rating")
    val rating: Rating? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    @PrimaryKey
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("category")
    val category: String? = null
)