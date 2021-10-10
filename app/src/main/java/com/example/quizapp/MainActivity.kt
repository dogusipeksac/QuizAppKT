package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN
        next_button.setOnClickListener{
            if(input_name.text.toString().isNullOrEmpty()){
                Toast.makeText(this,"Enter your name",Toast.LENGTH_SHORT).show()
            }
            else{
                var intent= Intent(this,QuestionActivity::class.java)
                intent.putExtra("${setData.name}",input_name.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}