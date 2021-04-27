package com.sf10.actors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sf10.actors.databinding.FragmentActorsBinding

class ActorsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentActorsBinding.inflate(inflater)

        val viewModel: ActorViewModel by viewModels { ActorViewModelFactory(requireContext()) }

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = ActorAdapter(ActorAdapter.ActorClickListener {
            viewModel.deleteActor(it)
        })
        binding.actorsRecyclerView.adapter = adapter

        viewModel.actors.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.addBtn.setOnClickListener {
            viewModel.addActor(
                binding.actorNameField.text.toString(),
                binding.actorYearField.text.toString(),
                binding.movieTitleField.text.toString()
            )
        }

        binding.filterBtn.setOnClickListener {
            viewModel.filter(
                binding.birthYearField.text.toString(),
                binding.movieNameField.text.toString()
            )
        }

        return binding.root
    }

}