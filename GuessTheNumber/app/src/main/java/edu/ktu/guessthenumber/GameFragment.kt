package edu.ktu.guessthenumber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import edu.ktu.guessthenumber.databinding.FragmentGameBinding
import edu.ktu.guessthenumber.viewmodels.GameViewModel
import edu.ktu.guessthenumber.viewmodels.GameViewModelFactory

class GameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstance: Bundle?) : View?{
        val binding = FragmentGameBinding.inflate(inflater)
        val viewModel: GameViewModel by viewModels{
            GameViewModelFactory(
                1, 100, 10, requireActivity().application
            )
        }
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.win.observe(viewLifecycleOwner, {
            if (it == true) {
                val action = GameFragmentDirections.actionGameFragmentToGameOverFragment(
                    true,
                    viewModel.number,
                    viewModel.maxAttempts- viewModel.attemptsRemaining.value!!
                )
                findNavController().navigate(action)
                viewModel.navigatedToWin()
            }
        })
        viewModel.lose.observe(viewLifecycleOwner, {
            if (it == true) {
                val action = GameFragmentDirections.actionGameFragmentToGameOverFragment(
                    number = viewModel.number,
                )
                findNavController().navigate(action)
                viewModel.navigatedToLose()
            }
        })


        return binding.root
    }
}