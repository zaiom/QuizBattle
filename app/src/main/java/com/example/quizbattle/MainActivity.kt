package com.example.quizbattle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.quizbattle.databinding.ActivityQuestionBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.findViewById<View>(R.id.singlePlayerButton).setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
