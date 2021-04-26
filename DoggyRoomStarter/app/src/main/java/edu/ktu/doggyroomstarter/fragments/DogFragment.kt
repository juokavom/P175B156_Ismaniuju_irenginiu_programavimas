package edu.ktu.doggyroomstarter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import edu.ktu.doggyroomstarter.R
import edu.ktu.doggyroomstarter.adapters.DogAdapter
import edu.ktu.doggyroomstarter.databinding.FragmentDogBinding
import edu.ktu.doggyroomstarter.viewmodels.DogViewModel

class DogFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDogBinding.inflate(inflater)

        val adapter = DogAdapter()
        binding.dogRecyclerView.adapter = adapter

        val viewModel : DogViewModel by viewModels()
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}