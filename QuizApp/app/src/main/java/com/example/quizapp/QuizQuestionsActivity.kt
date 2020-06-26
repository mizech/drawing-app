package com.example.quizapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private var mcurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mQuestionsList = Constants.getQuestions()
        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        submit_button.setOnClickListener(this)

        setColor()
    }

    private fun setQuestion() {
        var firstQuestion = mQuestionsList!!.get(mcurrentPosition - 1)

        if (mcurrentPosition == mQuestionsList!!.size) {
            submit_button.text = "FINISH"
        } else {
            submit_button.text = "SUBMIT"
        }

        progressbar.progress = mcurrentPosition

        tv_question.setText(firstQuestion.question)
        tv_image.setText(firstQuestion.image)
        tv_option_one.setText(firstQuestion.optionOne)
        tv_option_two.setText(firstQuestion.optionTwo)
        tv_option_three.setText(firstQuestion.optionThree)
        tv_option_four.setText(firstQuestion.optionFour)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four, 4)
            }
            R.id.submit_button -> {
                if (mSelectedOptionPosition == 0) {
                    mcurrentPosition++

                    when {
                        mcurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        } else -> {
                            Toast.makeText(this, "You have won the game.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mcurrentPosition - 1)

                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, Color.CYAN)
                    }

                    answerView(question.correctAnswer, Color.YELLOW)

                    if (mcurrentPosition == mQuestionsList!!.size) {
                        submit_button.text == "FINISH"
                    } else {
                        submit_button.text = "GO TO NEXT QUESTION"
                    }
                }
            }
        }
    }

    private fun answerView(answer: Int, color: Int) {
        when (answer) {
            1 -> {
                tv_option_one.setBackgroundColor(color)
            }
            2 -> {
                tv_option_two.setBackgroundColor(color)
            }
            3 -> {
                tv_option_three.setBackgroundColor(color)
            }
            4 -> {
                tv_option_four.setBackgroundColor(color)
            }
        }
    }

    private fun setColor() {
        tv_option_one.setTextColor(Color.BLACK)
        tv_option_one.setBackgroundColor(Color.WHITE)
        tv_option_two.setTextColor(Color.BLACK)
        tv_option_two.setBackgroundColor(Color.WHITE)
        tv_option_three.setTextColor(Color.BLACK)
        tv_option_three.setBackgroundColor(Color.WHITE)
        tv_option_four.setTextColor(Color.BLACK)
        tv_option_four.setBackgroundColor(Color.WHITE)
    }

    private fun selectedOptionView(tv: TextView, selectedOptionsNum: Int) {
        setColor()

        mSelectedOptionPosition = selectedOptionsNum
        tv.setTextColor(Color.WHITE)
        tv.setBackgroundColor(Color.BLACK)
    }
}
