package com.example.laba2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.laba2.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Надуваем макет detail_fragment.xml
        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val returnButton = binding.imageButton3

        returnButton.setOnClickListener{
            findNavController().navigate(R.id.action_detailFragment_to_listFragment)
        }

        val args = DetailFragmentArgs.fromBundle(requireArguments())
        val title = args.title
        val description = args.description
        val processor = args.processor
        val ram = args.ram

        binding.textView2.text = "Название: " + title
        binding.textView3.text = "Описание: " + description
        binding.textView4.text = "Процессор: " + processor
        binding.textView5.text = "Объём оперативной памяти: " + ram

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}