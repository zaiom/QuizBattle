@file:Suppress("DEPRECATION")

package com.example.quizbattle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlin.math.log
import android.widget.ProgressBar


class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val progressBar = findViewById<View>(R.id.progressBar)
        val progressText = findViewById<View>(R.id.progressText)
        val questionText = findViewById<View>(R.id.questionText)
        val questionImage = findViewById<View>(R.id.questionImage)

        val answerA = findViewById<View>(R.id.answer1Button)
        val answerB = findViewById<View>(R.id.answer2Button)
        val answerC = findViewById<View>(R.id.answer3Button)
        val answerD = findViewById<View>(R.id.answer4Button)



        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val questionsList = Constants.getQuestions()
        Log.i("Questions Size", "${questionsList.size}")

        val currentPosition = 1
        val question: Question? = questionsList[currentPosition - 1]

        progressBar.progress = currentPosition
        progressText.text = "$currentPosition" +  "/" + progressBar.max

        questionText.text = question!!.question

        questionImage.setImageResource(question.image)

        answerA.text = question.optionOne
        answerB.text = question.optionTwo
        answerC.text = question.optionThree
        answerD.text = question.optionFour
    }
}