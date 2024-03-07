package com.example.laba2

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laba2.databinding.EditFragmentBinding

class EditFragment : Fragment() {

    private var _binding: EditFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MyAdapter
    private val viewModel: ItemDataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = EditFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        val undoingButton = binding.button3

        val args = EditFragmentArgs.fromBundle(requireArguments())
        var title = args.title
        var description = args.description
        var cpu = args.cpu
        var ram = args.ram

        adapter = MyAdapter(viewModel, findNavController())

        undoingButton.setOnClickListener {
            val action = EditFragmentDirections.actionEditFragmentToDetailFragment(
                title = title,
                description = description,
                cpu = cpu,
                ram = ram
            )
            findNavController().navigate(action)
        }

        binding.editText1.text = Editable.Factory.getInstance().newEditable(title)
        binding.editText2.text = Editable.Factory.getInstance().newEditable(description)
        binding.editText3.text = Editable.Factory.getInstance().newEditable(cpu)
        binding.editText4.text = Editable.Factory.getInstance().newEditable(ram)

        binding.button.setOnClickListener {
            // Получение значений из EditText
            val newTitle = binding.editText1.text.toString()
            val newDescription = binding.editText2.text.toString()
            val newCpu = binding.editText3.text.toString()
            val newRam = binding.editText4.text.toString()

            val updatedItem = ItemData(newTitle,newDescription,newCpu,newRam)
            val oldItem = ItemData(title, description, cpu, ram)
            viewModel.updateItem(oldItem, updatedItem)

            // Навигация с обновленными значениями аргументов
            val action = EditFragmentDirections.actionEditFragmentToDetailFragment(
                title = newTitle,
                description =  newDescription,
                cpu =  newCpu,
                ram = newRam
            )
            findNavController().navigate(action)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}