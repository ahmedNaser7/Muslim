package com.route.muslim.hadethDetails

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.route.muslim.Constants
import com.route.muslim.R
import com.route.muslim.databinding.ActivityHadethDetailsBinding
import com.route.muslim.model.Hadeth

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHadethDetailsBinding
    lateinit var hadeth: Hadeth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            hadeth = intent.getParcelableExtra(Constants.EXTRA_HADETH, Hadeth::class.java)!!
        } else {
            hadeth = (intent.getParcelableExtra(Constants.EXTRA_HADETH) as Hadeth?)!!
        }

        viewBinding.content.text = hadeth.content

    }
}