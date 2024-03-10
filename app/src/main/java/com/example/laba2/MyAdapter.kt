package com.example.laba2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.laba2.databinding.ListItemBinding

// MyAdapter.kt
class MyAdapter(private val presenter: ListPresenter, private var navController: NavController) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding.root, navController)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = presenter.getItemAt(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return presenter.getItemCount()
    }

    inner class ViewHolder(itemView: View, private val navController: NavController) : RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemBinding.bind(itemView)


        init {
            // Set up any listeners here if needed
            binding.textView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    presenter.onItemClick(position)
                }
            }
            binding.imageButton.setOnClickListener {
                val position = adapterPosition
                val item = presenter.getItemAt(position)
                if (position != RecyclerView.NO_POSITION) {
                    presenter.removeItem(item)
                }
            }
        }

        fun bind(item: ItemData) {
            // Bind data to views
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
            // You can bind other data here as needed
        }
    }
}
