package com.telect.rrmvvm.utils

enum class Status {
    LOADING,
    SUCCESS,
    ERROR
}

class ResourceState<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T) =
            ResourceState<T>(status = Status.SUCCESS, data = data, message = null)

        fun <T> error(data: T, message: String) =
            ResourceState(status = Status.ERROR, data = data, message = message)

        fun <T> loading(data: T) =
            ResourceState(status = Status.LOADING, data = data, message = null)
    }


}


