package edu.ktu.guessthenumber

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import edu.ktu.guessthenumber.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGameOverBinding.inflate(inflater)
        val args = GameOverFragmentArgs.fromBundle(requireArguments())
        if (args.win) {
            binding.outcomeText.text =
                resources.getString(R.string.outcome_win)
            binding.summaryText.text =
                resources.getString(
                    R.string.summary_win,
                    args.number,
                    args.attempts
                )
        } else {
            binding.outcomeText.text =
                resources.getString(R.string.outcome_lose)
            binding.summaryText.text =
                resources.getString(
                    R.string.summary_lose,
                    args.number
                )
        }
        binding.playAgainBtn.setOnClickListener {
            val action = GameOverFragmentDirections
                .actionGameOverFragmentToGameFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}