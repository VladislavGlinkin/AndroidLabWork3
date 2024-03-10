package com.example.laba2

// ItemDataSource.kt
interface ItemDataSource {
    fun getItems(): List<ItemData>
    fun addItem(item: ItemData)
    fun removeItem(item: ItemData)
    fun updateItem(oldItem: ItemData, newItem: ItemData)
    fun getItemAt(position: Int): ItemData
    fun getItemCount(): Int
}