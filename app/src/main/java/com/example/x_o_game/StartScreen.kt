package com.example.x_o_game

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StartScreen:AppCompatActivity() {

     var play_button: Button?=null
     var player1:EditText?=null
     var player2:EditText?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)
        play_button=findViewById(R.id.play)
        player1=findViewById(R.id.first_name)
        player2=findViewById(R.id.second_name)

        play_button?.setOnClickListener{
                openGame()
        }

    }
    fun openGame()
    {
        var intent= Intent(this,MainActivity::class.java)
        intent.putExtra("p1",player1?.text.toString())
        intent.putExtra("p2",player2?.text.toString())
        if(player1!!.text.toString().isEmpty()||player2!!.text.toString().isEmpty())
        {
            Toast.makeText(this,"Please Enter names of players",Toast.LENGTH_SHORT).show()
        }
        else
        {
            startActivity(intent)
        }


    }
}