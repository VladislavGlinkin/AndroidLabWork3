package com.example.laba2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laba2.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MyAdapter
    private lateinit var dataSet: MutableList<ItemData>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Надуваем макет фрагмента
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        // Находим RecyclerView
        val recyclerView = binding.recyclerView


        // Создаем список данных
        dataSet = mutableListOf<ItemData>(
            ItemData("iPhone 13", "test", "A15 Bionic", "4GB"),
            ItemData("iPhone 12", "test", "A15 Bionic", "4GB"),
            ItemData("iPhone 11", "test", "A15 Bionic", "4GB")
        )

        val navController = findNavController()
        // Создаем экземпляр адаптера и устанавливаем его для RecyclerView
        adapter = MyAdapter(dataSet, navController)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // Находим кнопку и устанавливаем слушатель нажатия
        val imageButton2 = binding.imageButton2
        imageButton2.setOnClickListener {
            // Добавляем новый элемент в список данных
            val newItem = ItemData("Название", "Описание", "Процессор", "Оперативная память")
            dataSet.add(newItem)

            // Уведомляем адаптер о том, что данные были изменены
            adapter.notifyDataSetChanged()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
