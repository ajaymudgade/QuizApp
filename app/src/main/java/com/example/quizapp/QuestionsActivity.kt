package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.res.ColorStateList
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {


    private var Name : String? =null
    private var score: Int = 0

    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        Name = intent.getStringExtra(setData.name)

        questionList = setData.getQuestion()
        setQuestion()

        opt1.setOnClickListener{
            selectedOptionStyle(opt1,1)
        }

        opt2.setOnClickListener{
            selectedOptionStyle(opt2,2)
        }

        opt3.setOnClickListener{
            selectedOptionStyle(opt3,3)
        }

        opt4.setOnClickListener{
            selectedOptionStyle(opt4,4)
        }


        button_submit.setOnClickListener {
            if (selectedOption!=0){
                val question = questionList!![currentPosition - 1]
                if (selectedOption != question.correctAns){
                    setColor(selectedOption, R.drawable.wrong_question_option)
                }
                else{
                    score++
                }
                setColor(question.correctAns, R.drawable.correct_question_option)
                if (currentPosition == questionList!!.size)
                    button_submit.text = "Finished"
                    else
                        button_submit.text = "Go to next"

            }else{
                currentPosition++
                when{
                    currentPosition <= questionList!!.size -> {
                        setQuestion()
                    }
                    else ->{
                        var intent = Intent(this,Result::class.java)
                        intent.putExtra(setData.name, Name.toString())
                        intent.putExtra(setData.score, score.toString())
                        intent.putExtra("total size",questionList!!.size.toString())

                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption = 0
        }

    }
    fun setColor(opt: Int, color: Int){

        when(opt){
            1 ->{
                opt1.background = ContextCompat.getDrawable(this, color)
            }

            2 ->{
                opt2.background = ContextCompat.getDrawable(this, color)
            }
            3 ->{
                opt3.background = ContextCompat.getDrawable(this, color)
            }
            4 ->{
                opt4.background = ContextCompat.getDrawable(this, color)
            }
        }
    }

    private fun setQuestion() {
        val question = questionList!![currentPosition - 1]

        setOptionStyle()

        progress_bar.progress = currentPosition
        progress_bar.max = questionList!!.size
        progress_text.text = "${currentPosition}" + "/" + "${questionList!!.size}"
        question_text.text = question.question

        opt1.text = question.optionOne
        opt2.text = question.optionTwo
        opt3.text = question.optionThree
        opt4.text = question.optionFour
    }

    fun setOptionStyle(){
        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, opt1)
        optionList.add(1, opt2)
        optionList.add(2, opt3)
        optionList.add(3, opt4)

        for (op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this,R.drawable.question_options)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView, opt:Int){
        setOptionStyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this,R.drawable.selected_question_options)
        view.typeface = Typeface.DEFAULT
        view.setTextColor(Color.parseColor("#000000"))
    }
}