package com.example.cpu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.cpu.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.navButton.setOnClickListener{
            val cpu = Cpu(
                binding.manufacturerInput.text.toString(),
                binding.modelInput.text.toString(),
                binding.priceInput.text.toString().toDouble())
            val cpuArray = arrayOf<String>(cpu.manufacturer, cpu.model, cpu.price.toString())
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(cpuArray)
            binding.root.findNavController().navigate(action)
        }
        return binding.root
    }
}