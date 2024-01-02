package com.route.muslim.home.tabs.sebha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.muslim.R
import com.route.muslim.databinding.FragmentHadethBinding
import com.route.muslim.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    private var _binding: FragmentSebhaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSebhaBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}