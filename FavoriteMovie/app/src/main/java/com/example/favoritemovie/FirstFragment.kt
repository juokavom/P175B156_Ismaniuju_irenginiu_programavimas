package com.example.favoritemovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.findNavController
import com.example.favoritemovie.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.navButton.setOnClickListener{
            val movie: Movie = Movie(binding.movieInput.text.toString(),
                binding.directorInput.text.toString())
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(movie)
            binding.root.findNavController().navigate(action)
        }
        return binding.root
    }
}