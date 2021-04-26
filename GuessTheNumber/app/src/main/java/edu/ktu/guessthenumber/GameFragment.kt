package edu.ktu.guessthenumber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import edu.ktu.guessthenumber.databinding.FragmentGameBinding
import edu.ktu.guessthenumber.viewmodels.GameViewModel

class GameFragment : Fragment() {

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding = FragmentGameBinding.inflate(inflater)
//        return binding.root
//    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?) : View?{
        val binding = FragmentGameBinding.inflate(inflater)
        val viewModel: GameViewModel by viewModels()
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }
}