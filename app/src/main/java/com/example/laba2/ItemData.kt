package com.example.laba2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class ItemData(
    val title: String,
    val description: String,
    val processor: String,
    val ram: String
)

class ItemDataViewModel : ViewModel() {
    private val _dataList = MutableLiveData<MutableList<ItemData>>()
    val dataList: LiveData<MutableList<ItemData>> get() = _dataList

    init {
        _dataList.value = mutableListOf<ItemData>(
            ItemData("iPhone 13", "test", "A15 Bionic", "4GB"),
            ItemData("iPhone 12", "test", "A15 Bionic", "4GB"),
            ItemData("iPhone 11", "test", "A15 Bionic", "4GB")
        )
    }

    fun addItem(item: ItemData) {
        val currentList = _dataList.value.orEmpty().toMutableList()
        currentList.add(item)
        _dataList.value = currentList
    }

    // Метод для удаления элемента
    fun removeItem(item: ItemData) {
        val currentList = _dataList.value.orEmpty().toMutableList()
        currentList.remove(item)
        _dataList.value = currentList
    }
}