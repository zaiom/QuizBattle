package com.example.quizbattle

import com.google.firebase.database.DatabaseReference

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    public val questionsList = ArrayList<Question>()


//    fun getQuestions(): ArrayList<Question>{
//        val questionsList = ArrayList<Question>()
//
//        // Question 1
//        val q1 = Question(
//            1,
//            "Najmniejszy element obrazu wyświetlanego na monitorze komputera nazywany jest",
//            0,
//            "Grafika",
//            "GIF",
//            "Piksel",
//            "Kropka",
//            3
//        )
//
//        questionsList.add(q1)
//
//        // Question 2
//        val q2 = Question(
//            2,
//            "Brama sieciowa pozwala na",
//            0,
//            "Komunikowanie się komputera w sieci z innymi sieciami",
//            "Przejście komputera przez brame",
//            "Podłączenie się do routera",
//            "Komunikacje routera z komputerem",
//            1
//        )
//
//        questionsList.add(q2)
//
//        // Question 3
//        val q3 = Question(
//            1,
//            "Co to za marka?",
//            R.drawable.android_robot,
//            "Microsoft",
//            "IBM",
//            "Apple",
//            "Android",
//            4
//        )
//
//        questionsList.add(q3)
//
//        // Question 4
//        val q4 = Question(
//            1,
//            "Jakiego kraju jest to flaga?",
//            R.drawable.flag_of_korea,
//            "Chiny",
//            "Korea",
//            "USA",
//            "Polska",
//            2
//        )
//
//        questionsList.add(q4)
//
//
//        return questionsList
//    }
}