package com.example.quizbattle

import android.content.res.ColorStateList
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
    private var mCorrectAnswers: Int = 0

    private lateinit var binding: ActivityQuestionBinding





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_question)
        setContentView(binding.root)

        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        binding.answer1Button.setOnClickListener(this)
        binding.answer2Button.setOnClickListener(this)
        binding.answer3Button.setOnClickListener(this)
        binding.answer4Button.setOnClickListener(this)


    }
    // sets question text, image, and button's text for the next question
    private fun setQuestion(){

        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionView()

        binding.progressBar.progress = mCurrentPosition
        binding.progressText.text = "$mCurrentPosition" + "/" + binding.progressBar.max

        binding.questionText.text = question!!.question
        binding.questionImage.setImageResource(question.image)


        binding.answer1Button.text = question.optionOne
        binding.answer2Button.text = question.optionTwo
        binding.answer3Button.text = question.optionThree
        binding.answer4Button.text = question.optionFour

    }

    // asigning right background to our option ( button )
    private fun answerView(answer: Int, drawableView: Int){
        when (answer){
            1 -> {
                binding.answer1Button.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                binding.answer2Button.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                binding.answer3Button.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                binding.answer4Button.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    //sets apperance of the buttons after setting new question
    private fun defaultOptionView(){

        val options = ArrayList<Button>()
        options.add(0, binding.answer1Button)
        options.add(1, binding.answer2Button)
        options.add(2, binding.answer3Button)
        options.add(3, binding.answer4Button)

        for (option in options){
            option.setBackgroundColor(Color.parseColor("#000000"))
            //option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
            //option.typeface = Typeface.DEFAULT                                  // sets the typeface and style in which the text should be displayed

        }
    }
    override fun onClick(v: View?) {

        when (v?.id){
            // ??? czy to git?
            R.id.answer1Button -> {
                selectedOptionView(binding.answer1Button, 1)
                checkAnswer()
            }

            R.id.answer2Button -> {
                selectedOptionView(binding.answer2Button, 2)
                checkAnswer()
            }

            R.id.answer3Button -> {
                selectedOptionView(binding.answer3Button, 3)
                checkAnswer()
            }

            R.id.answer4Button -> {
                selectedOptionView(binding.answer4Button, 4)
                checkAnswer()
            }
        }

    }

    private fun checkAnswer(){

        if (mSelectedOptionPosition == 0)
        {

            when
            {
                mCurrentPosition <= mQuestionsList!!.size ->
                {
//
//                    setQuestion()
                }
                else -> {
                Toast.makeText(this, "You have successfully completed the Quiz", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else
        {
            val question = mQuestionsList?.get(mCurrentPosition - 1)

            if (question!!.correctAnswer != mSelectedOptionPosition)
            {
                answerView(mSelectedOptionPosition, R.drawable.wrong_option_button_border_bg)
                //answerView(mSelectedOptionPosition, button1.setBackgroundColor(Color.parseColor("#000000")))
            }
            else
            {
                mCorrectAnswers++
            }

            answerView(question.correctAnswer, R.drawable.correct_option_button_border_bg)

            mSelectedOptionPosition = 0
            mCurrentPosition ++
        }
    }

    // TODO: wyrzucic selectionOptionView?
    // czy ja chce wgl te funkcje? chyba nie. Ew. IF WCISKACZ BUTTON 1 -> POROWNAJ ODPOWIEDZI -> ZAKOLORUJ GUZIK
    private fun selectedOptionView(button: Button, selectedOptionNum: Int){

        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
//        val question = mQuestionsList?.get(mCurrentPosition - 1)

        // check if this is the last question
//        if (mCurrentPosition == mQuestionsList!!.size) {
//            button.text = "Finish"
//        }
        Handler().postDelayed({
            // increment mCurrentPosition and set new question
//            mCurrentPosition++
            if (mCurrentPosition <= mQuestionsList!!.size) {
                setQuestion()
            } else {
                // when all questions have been answered
                Toast.makeText(this, "You have successfully completed the Quiz", Toast.LENGTH_SHORT).show()
            }
        }, 2000) // wait for 1 second before setting the new question



    }

}