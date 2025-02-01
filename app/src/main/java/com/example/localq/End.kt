package com.example.localq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.localq.databinding.ActivityMainBinding
import com.example.localq.databinding.EndBinding
import com.example.localq.databinding.StartBinding


class End : Fragment() {
    //private lateinit var binding: EndBinding

    private var _binding: EndBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = EndBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tryAgainbtn.setOnClickListener {

            view.findNavController().navigate(R.id.action_end2_to_start2)
        }

       // val binding = EndBinding.inflate(inflater, container, false)

        val score = arguments?.getInt("SCORE_KEY", 0) ?: 0
        binding.totalPoints.text = "$score"


       // return binding.root
    }
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        binding.tryAgainbtn.setOnClickListener {
//
//            view.findNavController().navigate(R.id.action_end2_to_start2)
//        }
//
//    }
    override fun onDestroyView() {
        super.onDestroyView()

       //binding = null
    }
}
    