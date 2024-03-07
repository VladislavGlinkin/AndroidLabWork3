package com.example.laba2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laba2.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ItemDataViewModel by activityViewModels()
    private lateinit var adapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Надуваем макет detail_fragment.xml
        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val returnButton = binding.imageButton3
        val editButton = binding.button2

        val args = DetailFragmentArgs.fromBundle(requireArguments())
        val title = args.title
        val description = args.description
        val cpu = args.cpu
        val ram = args.ram

        adapter = MyAdapter(viewModel, findNavController())

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
            adapter.notifyDataSetChanged()
        }


        binding.textView2.text = "Название: " + title
        binding.textView3.text = "Описание: " + description
        binding.textView4.text = "Процессор: " + cpu
        binding.textView5.text = "Объём оперативной памяти: " + ram

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}