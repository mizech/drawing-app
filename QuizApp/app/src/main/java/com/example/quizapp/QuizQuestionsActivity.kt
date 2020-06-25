package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionsList = Constants.getQuestions()
        Log.i("###", "${questionsList.size.toString()}")

        var index = 0
        var firstQuestion = questionsList.get(index)

        progressbar.progress = index
        tv_question.setText(firstQuestion.question)
        tv_image.setText(firstQuestion.image)
        tv_option_one.setText(firstQuestion.optionOne)
        tv_option_two.setText(firstQuestion.optionTwo)
        tv_option_three.setText(firstQuestion.optionThree)
        tv_option_four.setText(firstQuestion.optionFour)
    }
}
