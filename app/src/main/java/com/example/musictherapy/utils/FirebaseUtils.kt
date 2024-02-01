package com.example.musictherapy.utils

import com.google.android.gms.tasks.Task
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resumeWithException

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun <T> Task<T>.await() : T {
    return suspendCancellableCoroutine {const ->
        addOnCompleteListener{
            //checking exception
            if (it.exception != null){
                const.resumeWithException(it.exception!!)
            }
            else{
                const.resume(it.result , null)
            }
        }

    }
}