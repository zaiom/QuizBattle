package com.example.quizbattle

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizbattle.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity(), OnClickListener{

    private var mCurrentPosition: Int = 1                           // number of a question
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0                    // selected answer button

    private lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_question)
        setContentView(binding.root)

        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        //TODO: it is made for the textviews, wonder if it works for buttons also? answer: prob yes
        binding.root.findViewById<View>(R.id.answer1Button).setOnClickListener(this)
        binding.root.findViewById<View>(R.id.answer2Button).setOnClickListener(this)
        binding.root.findViewById<View>(R.id.answer3Button).setOnClickListener(this)
        binding.root.findViewById<View>(R.id.answer4Button).setOnClickListener(this)

    }

    private fun setQuestion(){

        val question = mQuestionsList!![mCurrentPosition - 1]                   // !! means if mQuestions > null: do

        //defaultOptionsView()

        binding.progressBar.progress = mCurrentPosition
        binding.progressText.text = "$mCurrentPosition/${binding.progressBar.max}"

        binding.questionText.text = question!!.question
        binding.questionImage.setImageResource(question.image)

        binding.answer1Button.text = question.optionOne
        binding.answer2Button.text = question.optionTwo
        binding.answer3Button.text = question.optionThree
        binding.answer4Button.text = question.optionFour
    }

    //TODO: check if it could format the buttons also

    // function changes look of buttons/TextViews
    private fun defaultOptionsView(){

        val options = ArrayList<TextView>()
        options.add(0, binding.progressText)

        for (option in options){
            option.setTextColor((Color.parseColor("#D50909")))
            option.typeface = Typeface.DEFAULT                                               //sets the typeface and the style in which text should be displayed


            //option.background = ContextCompat.getDrawable(R.drawable.ic_launcher_background)
        }
    }

    //TODO: Check if it works well
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.answer1Button ->{
                selectedOptionView(binding.answer1Button, 1)
                submitAnswer()
            }
            R.id.answer2Button ->{
                selectedOptionView(binding.answer2Button, 2)
                submitAnswer()
            }
            R.id.answer3Button ->{
                selectedOptionView(binding.answer3Button, 3)
                submitAnswer()
            }
            R.id.answer4Button ->{
                selectedOptionView(binding.answer4Button, 4)
                submitAnswer()

            }
        }
    }

    private fun submitAnswer(){
        if (mSelectedOptionPosition == 0){
            mCurrentPosition ++

            when{
                mCurrentPosition <= mQuestionsList!!.size -> {
                    setQuestion()
                }
                else -> {
                    Toast.makeText(this, "You have successfully completed the Quiz", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            val question = mQuestionsList?.get(mCurrentPosition - 1)
            if (question!!.correctAnswer != mSelectedOptionPosition) {
                answerView(mSelectedOptionPosition, R.drawable.wrong_option_button_border_bg)
            }

            answerView(question.correctAnswer, R.drawable.correct_option_button_border_bg)

            mSelectedOptionPosition = 0
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                binding.answer1Button.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 ->{
                binding.answer2Button.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 ->{
                binding.answer3Button.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 ->{
                binding.answer4Button.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    //TODO: change TextView to the button so it format well?
    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int) {

        //defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor((Color.parseColor("#D50909")))
        tv.typeface = Typeface.DEFAULT
        //tv.setTypeface(tv.typeface, Typeface.BOLD)
        //tv.background = ContextCompat.getDrawable(R.drawable.ic_launcher_background)
    }
}
