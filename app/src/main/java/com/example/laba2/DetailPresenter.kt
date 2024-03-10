package com.example.laba2

import com.example.laba2.databinding.DetailFragmentBinding

class DetailPresenter(private val view: DetailView) {
    fun getItemDetails(item: ItemData) {
        view.showItemDetails(item)
    }
}
