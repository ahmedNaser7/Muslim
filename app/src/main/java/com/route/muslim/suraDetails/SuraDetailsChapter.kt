package com.route.muslim.suraDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.muslim.Constants
import com.route.muslim.databinding.ActivitySuraDetailsChapterBinding

class SuraDetailsChapter : AppCompatActivity() {
    lateinit var viewBinding: ActivitySuraDetailsChapterBinding
    lateinit var adapter: SuraDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySuraDetailsChapterBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        val suraNumber = intent.getIntExtra(Constants.EXTRA_CHAPTER_INDEX, 0)
        val suraName = intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME)
        val file = applicationContext.assets.open("${suraNumber}.txt").bufferedReader()
            .use { it.readText() }
        val lines = file.trim().split("\n")

        bindLines(lines)
        viewBinding.suraTitle.text = suraName
    }


    private fun bindLines(sura: List<String>) {
        adapter = SuraDetailsAdapter(sura)
        viewBinding.recycler.adapter = adapter

    }

}

