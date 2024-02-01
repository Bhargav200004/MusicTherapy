package com.example.musictherapy.data

import java.lang.Exception

sealed class Resources<out R> {
    data class Success<out R>(val result : R) : Resources<R>()
    data class Failure(val exception: Exception) : Resources<Nothing>()
    data object Loading : Resources<Nothing>()
}