package com.example.laba2

class ListPresenter(private val view: ListView, private val repository: ItemRepository) {
    fun loadItems() {
        // Получение списка элементов из репозитория и передача его в представление для обновления списка
        val items = repository.getItems()
        view.showItems(items)
    }

    fun addItem(item: ItemData) {
        // Добавление нового элемента в репозиторий
        repository.addItem(item)
        // Передача уведомления в представление об обновлении списка
        view.updateList()
    }

    fun removeItem(item: ItemData) {
        // Удаление элемента из репозитория
        repository.removeItem(item)
        // Передача уведомления в представление об обновлении списка
        view.updateList()
    }

    fun getItemAt(position: Int): ItemData {
        // Получение элемента из репозитория по позиции
        return repository.getItemAt(position)
    }

    fun getItemCount(): Int {
        // Получение количества элементов в списке из репозитория
        return repository.getItemCount()
    }

    fun onItemClick(position: Int) {
        // Обработка нажатия на элемент списка (необходимая логика)
    }

    fun onDeleteItemClick(position: Int) {
        // Обработка нажатия на кнопку удаления элемента списка (необходимая логика)
    }
}
