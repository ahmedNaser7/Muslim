package com.route.muslim.home.tabs.hadeth

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.route.muslim.Constants
import com.route.muslim.databinding.FragmentHadethBinding
import com.route.muslim.hadethDetails.HadethDetailsActivity
import com.route.muslim.model.Hadeth


class HadethFragment : Fragment() {
    private var _binding: FragmentHadethBinding? = null
    private val binding get() = _binding!!
    lateinit var adapter: HadethAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHadethBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onStart() {
        super.onStart()
        loadFile()
        bindFile()
    }

    private fun bindFile() {
        adapter.bindHadeth(hadethList)
        binding.recycler.adapter = adapter
    }

    val hadethList = mutableListOf<Hadeth>()
    private fun loadFile() {
        val fileContent: String =
            requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val singleHadethList = fileContent.trim().split("#")
        singleHadethList.forEach {
            val lines = it.trim().split("\n")
            val title = lines[0]
            val content = lines.joinToString("\n")
            val hadeth = Hadeth(title, content)
            hadethList.add(hadeth)
        }
    }

    private fun initView() {
        adapter = HadethAdapter(null)
        adapter.onItemClickListener = HadethAdapter.OnItemClickListener { position, name ->
            ShowHadethDetails(name)
        }
    }

    private fun ShowHadethDetails(hadeth: Hadeth) {
        val intent = Intent(context, HadethDetailsActivity::class.java)
        intent.putExtra(Constants.EXTRA_HADETH, hadeth)
        startActivity(intent)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


