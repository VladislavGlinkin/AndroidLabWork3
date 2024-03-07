package com.example.laba2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laba2.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MyAdapter
    private val viewModel: ItemDataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Надуваем макет фрагмента
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        // Находим RecyclerView
        val recyclerView = binding.recyclerView

        val navController = findNavController()
        // Создаем экземпляр адаптера и устанавливаем его для RecyclerView
        adapter = MyAdapter(viewModel, navController)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel.dataList.observe(viewLifecycleOwner) { _ ->
            // Обновление RecyclerView с новыми данными
            adapter.notifyDataSetChanged()
        }

        // Находим кнопку и устанавливаем слушатель нажатия
        val imageButton2 = binding.imageButton2
        imageButton2.setOnClickListener {
            // Добавляем новый элемент в список данных
            val newItem = ItemData("Название", "Описание", "Процессор", "Оперативная память")
            viewModel.addItem(newItem)
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerView.adapter = null
        _binding = null
    }
}

