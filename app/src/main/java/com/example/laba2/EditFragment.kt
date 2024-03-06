package com.example.laba2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.laba2.databinding.DetailFragmentBinding
import com.example.laba2.databinding.EditFragmentBinding

class EditFragment : Fragment() {

    private var _binding: EditFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = EditFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val undoingButton = binding.button3
        undoingButton.setOnClickListener {
            findNavController().navigate(R.id.action_editFragment_to_detailFragment)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}