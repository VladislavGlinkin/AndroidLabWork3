package com.example.laba2

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.laba2.databinding.EditFragmentBinding

class EditFragment : Fragment(), EditView {
    private lateinit var presenter: EditPresenter
    private var _binding: EditFragmentBinding? = null
    private val binding get() = _binding!!

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

        presenter = EditPresenter(this, ItemRepository)

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

            presenter.updateItem(ItemData(title, description, cpu, ram), ItemData(newTitle, newDescription, newCpu, newRam))
            val action = EditFragmentDirections.actionEditFragmentToDetailFragment(
                title = newTitle,
                description = newDescription,
                cpu = newCpu,
                ram = newRam
            )
            findNavController().navigate(action)
        }

        return view
    }

    override fun showEditDetails(title: String, description: String, cpu: String, ram: String) {
        binding.editText1.text = Editable.Factory.getInstance().newEditable("Название: $title")
        binding.editText2.text = Editable.Factory.getInstance().newEditable("Описание: $description")
        binding.editText3.text = Editable.Factory.getInstance().newEditable("Процессор: $cpu")
        binding.editText4.text = Editable.Factory.getInstance().newEditable("Объём оперативной памяти: $ram")
    }
}
