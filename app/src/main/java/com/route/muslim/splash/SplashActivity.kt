package com.route.muslim.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.route.muslim.databinding.ActivitySplashBinding
import com.route.muslim.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        Handler().postDelayed(
            {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            },
            2000,
        )
    }
}