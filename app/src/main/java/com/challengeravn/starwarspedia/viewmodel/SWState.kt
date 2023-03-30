package com.challengeravn.starwarspedia.viewmodel

sealed class SWState<T> (
    val value: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T):SWState<T>(data)
    class Error<T>(message: String?, data: T? = null):SWState<T>(data, message)
    class Loading<T> : SWState<T>()
}
