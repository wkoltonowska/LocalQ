package com.example.localq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.localq.databinding.StartBinding


class Start : Fragment() {

    private var _binding: StartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = StartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.startbtn.setOnClickListener {

            view.findNavController().navigate(R.id.action_start2_to_questionsPzn)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}


