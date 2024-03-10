package com.example.laba2

// ItemRepository.kt
object ItemRepository : ItemDataSource {
    private val dataList = mutableListOf<ItemData>(
        ItemData("iPhone 13", "test", "A15 Bionic", "4GB"),
        ItemData("iPhone 12", "test", "A15 Bionic", "4GB"),
        ItemData("iPhone 11", "test", "A15 Bionic", "4GB")
    )

    override fun getItems(): List<ItemData> {
        return dataList.toList()
    }

    override fun addItem(item: ItemData) {
        dataList.add(item)
    }

    override fun removeItem(item: ItemData) {
        dataList.remove(item)
    }

    override fun updateItem(oldItem: ItemData, newItem: ItemData) {
        val index = dataList.indexOf(oldItem)
        if (index != -1) {
            dataList[index] = newItem
        }
    }

    override fun getItemAt(position: Int): ItemData {
        return dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

