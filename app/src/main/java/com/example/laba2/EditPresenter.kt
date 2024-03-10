package com.example.laba2

class EditPresenter(private val view: EditView, private val repository: ItemRepository) {
    fun getEditDetails(item: ItemData) {
        view.showEditDetails(item.title, item.description, item.cpu, item.ram)
    }

    fun updateItem(oldItem: ItemData, newItem: ItemData) {
        repository.updateItem(oldItem, newItem)
    }
}