package com.example.favoritemovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.favoritemovie.SecondFragmentArgs.Companion.fromBundle
import com.example.favoritemovie.databinding.FragmentFirstBinding
import com.example.favoritemovie.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        val args = SecondFragmentArgs.fromBundle(requireArguments())
        val movie = args.movie as Movie
        binding.titleAndDirector.text = "${movie.title} directed by ${movie.director}"
        return binding.root
    }
}