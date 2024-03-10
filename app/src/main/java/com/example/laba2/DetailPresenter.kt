package com.example.laba2

class DetailPresenter(private val view: DetailView) {
    fun getItemDetails(item: ItemData) {
        view.showItemDetails(item)
    }
}
