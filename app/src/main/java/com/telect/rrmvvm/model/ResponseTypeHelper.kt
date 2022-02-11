package com.telect.rrmvvm.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ResponseTypeHelper {

    @TypeConverter
    fun typeToString(items: List<ResponseItem>): String {
        val gson = Gson()
        return gson.toJson(items)
    }


    @TypeConverter
    fun stringToType(response: String): List<ResponseItem> {
        val gson = Gson()
        val listType = object : TypeToken<List<ResponseItem>>() {}.type
        return gson.fromJson(response, listType)
    }

}