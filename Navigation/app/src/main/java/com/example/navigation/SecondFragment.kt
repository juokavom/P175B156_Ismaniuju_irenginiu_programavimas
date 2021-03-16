package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = SecondFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "Received message: ${args.message}", Toast.LENGTH_LONG).show()
        return inflater.inflate(R.layout.fragment_second, container, false)
    }
}