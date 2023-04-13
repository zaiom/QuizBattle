package com.example.quizbattle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizbattle.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_question)
        setContentView(binding.root)

        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val questionsList = Constants.getQuestions()
        val currentPosition = 1
        val question: Question? = questionsList[currentPosition - 1]

        binding.progressBar.progress = currentPosition
        binding.progressText.text = "$currentPosition/${binding.progressBar.max}"

        binding.questionText.text = question!!.question
        binding.questionImage.setImageResource(question.image)

        binding.answer1Button.text = question.optionOne
        binding.answer2Button.text = question.optionTwo
        binding.answer3Button.text = question.optionThree
        binding.answer4Button.text = question.optionFour
    }
}
