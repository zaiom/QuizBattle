package com.example.quizbattle

class Question() {
    var question: String? = null
    var optionOne: String? = null
    var optionTwo: String? = null
    var optionThree: String? = null
    var optionFour: String? = null
    var correctAnswer: Int = 0
    var image: Int = 0

    constructor(
        question: String?,
        optionOne: String?,
        optionTwo: String?,
        optionThree: String?,
        optionFour: String?,
        correctAnswer: Int,
        image: Int

    ) : this() {
        this.question = question
        this.optionOne = optionOne
        this.optionTwo = optionTwo
        this.optionThree = optionThree
        this.optionFour = optionFour
        this.correctAnswer = correctAnswer
        this.image = image
    }
}

