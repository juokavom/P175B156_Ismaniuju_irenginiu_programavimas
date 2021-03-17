package com.example.cpu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cpu.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var cpuAdapter: CpuAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        val args = SecondFragmentArgs.fromBundle(requireArguments())
        binding.selectedCPU.text = "${args.cpu[0]} ${args.cpu[1]} added"

        val cpuList = mutableListOf(
            Cpu("AMD", "TEST 220", 885.00),
            Cpu("AMD", "TEST 220", 885.00),
            Cpu("AMD", "TEST 220", 885.00),
            Cpu("AMD", "TEST 220", 885.00),
            Cpu("AMD", "TEST 220", 885.00),
            Cpu("AMD", "TEST 220", 885.00),
            Cpu("AMD", "TEST 220", 885.00),
            Cpu("AMD", "TEST 220", 885.00),
            Cpu("AMD", "TEST 220", 885.00))

        val recycler = binding.cpuList as RecyclerView
        cpuAdapter = CpuAdapter() { cpu ->
            val newCpuList = cpuAdapter.currentList.toMutableList()
            newCpuList.remove(cpu)
            cpuAdapter.submitList(newCpuList)
        }
        cpuAdapter.submitList(cpuList)
        recycler.adapter = cpuAdapter

        return binding.root
    }
}