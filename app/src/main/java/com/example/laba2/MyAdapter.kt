package com.example.laba2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.laba2.databinding.ListItemBinding

class MyAdapter(
    private val viewModel: ItemDataViewModel,
    private val navController: NavController
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, navController, viewModel)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = viewModel.dataList.value?.get(position)
        item?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return viewModel.dataList.value?.size ?: 0
    }

    class ViewHolder(
        private val binding: ListItemBinding,
        private val navController: NavController,
        private val viewModel: ItemDataViewModel
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemData) {
            binding.textView.text = item.title
            binding.textView.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToDetailFragment(
                    title = item.title,
                    description = item.description,
                    cpu = item.cpu,
                    ram = item.ram
                )
                navController.navigate(action)
            }
            val deleteButton = binding.imageButton
            deleteButton.setOnClickListener {
                // Удаление элемента из списка через ViewModel
                // Передавайте объект ItemData, а не позицию, чтобы правильно определить, какой элемент удалить
                viewModel.removeItem(item)
            }
        }
    }
}




