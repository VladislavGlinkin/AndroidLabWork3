package com.example.laba2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.laba2.databinding.DetailFragmentBinding

class DetailFragment : Fragment(), DetailView {
    private lateinit var presenter: DetailPresenter
    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        val view = binding.root

        val returnButton = binding.imageButton3
        val editButton = binding.button2

        val args = DetailFragmentArgs.fromBundle(requireArguments())
        val title = args.title
        val description = args.description
        val cpu = args.cpu
        val ram = args.ram

        presenter = DetailPresenter(this)

        editButton.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToEditFragment(
                title = title,
                description = description,
                cpu = cpu,
                ram = ram
            )
            findNavController().navigate(action)
        }

        returnButton.setOnClickListener{
            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }

        presenter.getItemDetails(ItemData(title, description, cpu, ram))

        return view
    }

    override fun showItemDetails(item: ItemData) {
        binding.textView2.text = "Название: ${item.title}"
        binding.textView3.text = "Описание: ${item.description}"
        binding.textView4.text = "Процессор: ${item.cpu}"
        binding.textView5.text = "Объём оперативной памяти: ${item.ram}"
    }
}

