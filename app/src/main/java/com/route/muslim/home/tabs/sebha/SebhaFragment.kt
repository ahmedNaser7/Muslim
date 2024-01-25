package com.route.muslim.home.tabs.sebha

import android.graphics.Matrix
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView.ScaleType
import androidx.fragment.app.Fragment
import com.route.muslim.R
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


    override fun onStart() {
        super.onStart()
        loadView()
    }

    private fun loadView() {
        val image = binding.sebhaBody
        val btnCounter = binding.counter
        val btn = binding.btn
        var counter = 0
        binding.btn.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_animation)
            image.startAnimation(anim)
            if (counter == 33) {
                counter = 0
                btn.text = "الحمد لله"
            }
            counter++
            btnCounter.text = counter.toString()
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}