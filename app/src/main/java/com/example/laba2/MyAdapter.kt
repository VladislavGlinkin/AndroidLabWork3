package com.example.laba2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.laba2.databinding.ListItemBinding

class MyAdapter(
    private val dataSet: MutableList<ItemData>,
    private val navController: NavController
) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, dataSet, this, navController)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


    class ViewHolder(
        private val binding: ListItemBinding,
        private val dataSet: MutableList<ItemData>,
        private val adapter: MyAdapter,
        private val navController: NavController
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemData) {
            binding.textView.text = item.title
            binding.textView.setOnClickListener {
                val action = ListFragmentDirections.actionListFragmentToDetailFragment(
                    title = item.title,
                    description = item.description,
                    processor = item.processor,
                    ram = item.ram
                )
                navController.navigate(action)
            }
            val deleteButton = binding.imageButton
            deleteButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    dataSet.removeAt(position)
                    adapter.notifyItemRemoved(position)
                }
            }
        }
    }
}



