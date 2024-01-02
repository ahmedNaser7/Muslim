package com.route.muslim.home.tabs.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.muslim.Constants
import com.route.muslim.databinding.FragmentQuranBinding
import com.route.muslim.suraDetails.SuraDetailsChapter


class QuranFragment : Fragment() {
    private var _binding: FragmentQuranBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: QuranSuraAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuranBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = QuranSuraAdapter(Suras.SurasList)
        adapter.onItemClickListener =
            QuranSuraAdapter.OnItemClickListener { position, name ->
                startSuraDetails(position, name)
            }
        binding.recycler.adapter = adapter
    }

    private fun startSuraDetails(position: Int, name: String) {
        val intent = Intent(context, SuraDetailsChapter::class.java)
        intent.putExtra(Constants.EXTRA_CHAPTER_INDEX, position + 1)
        intent.putExtra(Constants.EXTRA_CHAPTER_NAME, name)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}