package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {


    private var name:String?=null
    private var score:Int=0
    private var one:Boolean=true
    private var currentPosition:Int=1
    private var questionList:ArrayList<QuestionData>?=null
    private var selectedOption:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        name=intent.getStringExtra(setData.name)

        questionList=setData.getQuestion()
        setQuestion()

        option_1.setOnClickListener {
            selectedOptionStyle(option_1,1)
        }
        option_2.setOnClickListener {
            selectedOptionStyle(option_2,2)
        }

        option_3.setOnClickListener {
            selectedOptionStyle(option_3,3)
        }

        option_4.setOnClickListener {
            selectedOptionStyle(option_4,4)
        }
        submit_button.setOnClickListener {

            if(selectedOption!=0){
                one=false
                val question=questionList!![currentPosition-1]
                if (selectedOption!=question.correctAnswer){
                    setColorAnswer(selectedOption,R.drawable.wrong_quesiton_option)

                }
                else{
                    score++
                }
                setColorAnswer(question.correctAnswer,R.drawable.correct_quesiton_option)
                if(currentPosition==questionList!!.size) submit_button.text="FINISH"
                else submit_button.text="NEXT"

            }
            else{
                currentPosition++
                one=true
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }
                    else->{
                        var intent=Intent(this,ResultActivity::class.java)
                        intent.putExtra(setData.name,name.toString())
                        intent.putExtra(setData.score,score.toString())
                        intent.putExtra("total_size",questionList!!.size.toString())
                        startActivity(intent)
                        finish()
                    }
                }
            }
            selectedOption=0

        }


    }

    fun setColorAnswer(opt:Int,color: Int){
         when(opt){
             1->{option_1.background=ContextCompat.getDrawable(this,color)}
             2->{option_2.background=ContextCompat.getDrawable(this,color)}
             3->{option_3.background=ContextCompat.getDrawable(this,color)}
             4->{option_4.background=ContextCompat.getDrawable(this,color)}
         }
    }
    fun setQuestion(){
        val question=questionList!![currentPosition-1]
        setOptionStyle()
        progress_bar_for_question.progress=currentPosition
        progress_bar_for_question.max=questionList!!.size
        progress_text_question_number.text="${currentPosition}"+"/"+"${questionList!!.size}"
        question_text.text=question.question
        option_1.text=question.option1
        option_2.text=question.option2
        option_3.text=question.option3
        option_4.text=question.option4

    }
    fun setOptionStyle(){



        var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,option_1)
        optionList.add(1,option_2)
        optionList.add(2,option_3)
        optionList.add(3,option_4)
        for (op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.quesiton_option)
            op.typeface= Typeface.DEFAULT
        }


    }
    fun selectedOptionStyle(view: TextView,opt:Int) {
            if(one){
                setOptionStyle()
                selectedOption = opt
                view.background = ContextCompat.getDrawable(this, R.drawable.selected_quesiton_option)
                view.typeface = Typeface.DEFAULT_BOLD
                view.setTextColor(Color.parseColor("#000000"))
            }



    }
}