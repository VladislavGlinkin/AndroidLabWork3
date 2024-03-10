package com.example.laba2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laba2.databinding.ListFragmentBinding

class ListFragment : Fragment(), ListView {
    private lateinit var presenter: ListPresenter
    private lateinit var adapter: MyAdapter
    private var _binding: ListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        val recyclerView = binding.recyclerView

        val navController = findNavController()

        presenter = ListPresenter(this, ItemRepository)
        adapter = MyAdapter(presenter, navController)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val imageButton2 = binding.imageButton2
        imageButton2.setOnClickListener {
            presenter.addItem(ItemData("Название", "Описание", "Процессор", "Оперативная память"))
            Log.d("OK", "${adapter.itemCount - 1}")
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        updateList()
    }

    override fun updateList() {
        adapter.notifyDataSetChanged()
    }

    override fun showItems(items: List<ItemData>) {
        // Update your adapter with the new items
        adapter.notifyDataSetChanged()
    }
}
