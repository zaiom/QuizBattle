package com.example.quizbattle

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizbattle.databinding.ActivityQuestionBinding
import android.os.Handler


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

        binding.root.findViewById<View>(R.id.answer1Button).setOnClickListener(this)
        binding.root.findViewById<View>(R.id.answer2Button).setOnClickListener(this)
        binding.root.findViewById<View>(R.id.answer3Button).setOnClickListener(this)
        binding.root.findViewById<View>(R.id.answer4Button).setOnClickListener(this)

    }

    private fun setQuestion(){

        val question = mQuestionsList!![mCurrentPosition - 1]                   // !! means if mQuestions > null: do

        defaultOptionsView()

        binding.progressBar.progress = mCurrentPosition
        binding.progressText.text = "$mCurrentPosition/${binding.progressBar.max}"

        binding.questionText.text = question!!.question
        binding.questionImage.setImageResource(question.image)

        binding.answer1Button.text = question.optionOne
        binding.answer2Button.text = question.optionTwo
        binding.answer3Button.text = question.optionThree
        binding.answer4Button.text = question.optionFour
    }

    // function changes look of buttons/TextViews
    private fun defaultOptionsView(){

        val options = ArrayList<Button>()
        options.add(binding.answer1Button)
        options.add(binding.answer2Button)
        options.add(binding.answer3Button)
        options.add(binding.answer4Button)

        for (option in options) {
            option.setTextColor(Color.parseColor("#FFFFFF"))
            option.setTypeface(Typeface.DEFAULT)
            option.setBackgroundColor(Color.parseColor("#000000"))
        }
    }

    //TODO: Check if it works well
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.answer1Button ->{
                selectedOptionView(binding.answer1Button, 1)
                //submitAnswer()
            }
            R.id.answer2Button ->{
                selectedOptionView(binding.answer2Button, 2)
                //submitAnswer()
            }
            R.id.answer3Button ->{
                selectedOptionView(binding.answer3Button, 3)
                //submitAnswer()
            }
            R.id.answer4Button ->{
                selectedOptionView(binding.answer4Button, 4)
                //submitAnswer()
                //delay(5000)

                // opóźnienie wyświetlenia kolejnego pytania
                Handler().postDelayed({
                    submitAnswer()
                }, 5000)

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
            if (question?.correctAnswer != mSelectedOptionPosition) {
                answerView(mSelectedOptionPosition, R.drawable.wrong_option_button_border_bg)
            }
            answerView(question?.correctAnswer ?: 0, R.drawable.correct_option_button_border_bg)
            mSelectedOptionPosition = 0
            Handler().postDelayed({
                setQuestion()
            }, 5000)
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

    private fun selectedOptionView(button: Button, selectedOptionNumber: Int) {

        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber
        button.setTypeface(button.typeface, Typeface.BOLD)

        val question = mQuestionsList?.get(mCurrentPosition - 1)
        if (selectedOptionNumber == question?.correctAnswer) {
            answerView(selectedOptionNumber, R.drawable.correct_option_button_border_bg)
        } else {
            answerView(selectedOptionNumber, R.drawable.wrong_option_button_border_bg)
            answerView(question?.correctAnswer ?: 0, R.drawable.correct_option_button_border_bg)
        }
    }
}
