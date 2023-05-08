package com.example.quizbattle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.quizbattle.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.findViewById<View>(R.id.singlePlayerButton).setOnClickListener {

            val intent = Intent(this, AddQuizActivity::class.java)
            //intent.putExtra(Constants.USER_NAME, )
            startActivity(intent)
            finish()
        }

//        binding.root.findViewById<View>(R.id.addQuizButton).setOnClickListener {
//
//            val intent = Intent(this, AddQuizActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

    }
}