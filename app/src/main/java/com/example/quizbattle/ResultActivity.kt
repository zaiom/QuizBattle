package com.example.quizbattle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizbattle.databinding.ActivityResultBinding
//import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(Constants.USER_NAME)
        //tv_name.text = username

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)           // 0 is neceserly to give a defaultValue to this method
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)           // so it could actually work

        binding.score.text = "$correctAnswers" + " / " + "$totalQuestions"

        //binding.finishButton.setOnClickListener()
        binding.root.findViewById<View>(R.id.finishButton).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}