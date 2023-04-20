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

    private lateinit var binding: ActivityQuestionBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_question)
        setContentView(binding.root)

        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mQuestionsList = Constants.getQuestions()

        var button1 = binding.answer1Button
        var button2 = binding.answer2Button
        var button3 = binding.answer3Button
        var button4 = binding.answer4Button

        setQuestion()

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)


    }

    // sets question text, image, and button's text for the next question
    private fun setQuestion(){

        mCurrentPosition = 1
        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionView()

        binding.progressBar.progress = mCurrentPosition
        binding.progressText.text = "$mCurrentPosition" + "/" + binding.progressBar.max

        binding.questionText.text = question!!.question
        binding.questionImage.setImageResource(question.image)


        button1.text = question.optionOne
        button2.text = question.optionTwo
        button3.text = question.optionThree
        button4.text = question.optionFour

    }

    //sets apperance of the buttons after setting new question
    private fun defaultOptionView(){

        val options = ArrayList<Button>()
        options.add(0, button1)
        options.add(1, button2)
        options.add(2, button3)
        options.add(3, button4)

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
                selectedOptionView(button1, 1)
            }
            R.id.answer2Button -> {
                selectedOptionView(button2, 2)
            }
        }
    }

    // czy ja chce wgl te funkcje? chyba nie. Ew. IF WCISKACZ BUTTON 1 -> POROWNAJ ODPOWIEDZI -> ZAKOLORUJ GUZIK
    private fun selectedOptionView(button: Button, selectedOptionNum: Int){

        //defaultOptionView()     // chodzi tu o to, ze jak wcisniesz inny guzik to masz zresetowac "zaznaczenie" innych guzikow, wiec out
        mSelectedOptionPosition = selectedOptionNum

        // just for tests
        button.setTextColor(Color.parseColor("#FFBB86FC"))
        button.typeface = Typeface.DEFAULT_BOLD

    }

}
