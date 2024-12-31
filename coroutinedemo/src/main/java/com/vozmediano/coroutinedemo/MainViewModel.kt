package com.vozmediano.coroutinedemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class MainViewModel : ViewModel() {
    private var _count: MutableLiveData<Int> = MutableLiveData(1)
    val count: LiveData<Int> = _count

    fun setCount(value: Int) {
        _count.value = value
    }

    suspend fun performTaskAsync(taskNumber: Int): Deferred<String> {
        return CoroutineScope(Dispatchers.Default).async {
            Log.i(
                "threads",
                "${Thread.currentThread().name} esta realizando la tarea $taskNumber")
            delay(5_000)
            return@async "Finished Coroutine $taskNumber"
        }

    }
}