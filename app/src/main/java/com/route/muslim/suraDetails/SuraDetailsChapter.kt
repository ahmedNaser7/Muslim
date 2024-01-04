package com.route.muslim.suraDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.muslim.Constants
import com.route.muslim.databinding.ActivitySuraDetailsBinding

class SuraDetailsChapter : AppCompatActivity() {
    lateinit var viewBinding: ActivitySuraDetailsBinding
    lateinit var adapter: SuraDetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setSupportActionBar(viewBinding.toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = " "

        val suraNumber = intent.getIntExtra(Constants.EXTRA_CHAPTER_INDEX, 0)
        val suraName = intent.getStringExtra(Constants.EXTRA_CHAPTER_NAME)
        val file = applicationContext.assets.open("${suraNumber}.txt").bufferedReader()
            .use { it.readText() }
        val lines = file.trim().split("\n")

        bindLines(lines)
        viewBinding.content.suraTitle.text = suraName
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        onBackPressed()
        return true
    }


    private fun bindLines(sura: List<String>) {
        adapter = SuraDetailsAdapter(sura)
        viewBinding.content.recycler.adapter = adapter

    }

}

