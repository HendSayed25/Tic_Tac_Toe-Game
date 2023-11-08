package com.example.x_o_game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private var scorePlayer1Textview: TextView?=null
    private var scorePlayer2Textview: TextView?=null
    private lateinit var player1:TextView
    private lateinit var player2:TextView
    private lateinit var status:TextView
    private  var rootLayout: ConstraintLayout?=null

    private var counter:Int=0
    private var scorePlayer1:Int=0
    private var scorePlayer2:Int=0
    private var symolPlayer:String?=null
    private  var boardState=ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scorePlayer1Textview=findViewById(R.id.player1_score)
        scorePlayer2Textview=findViewById(R.id.player2_score)
        player1=findViewById(R.id.player1)
        player2=findViewById(R.id.player2)
        status=findViewById(R.id.status)
        rootLayout=findViewById(R.id.root_element)
        player1.setText(intent.getStringExtra("p1"))
        player2.setText(intent.getStringExtra("p2"))
        initiliazBoardState()
    }

    private  fun initiliazBoardState()
    {
        boardState=ArrayList()
        for(i:Int in  0 ..8)
        {
            boardState.add("")
        }
        for(i:Int in 0 until rootLayout!!.childCount)
        {
            var vv: View =rootLayout!!.getChildAt(i)
            if(vv is Button)
            {
                vv .setText(null)
            }
        }

    }
     fun onPlayerClick(v: View)
    {
        var vv=v as Button
        if(!(vv.text.toString().isEmpty()))
        {
            return
        }
        if(counter%2==0)//player 1 x turn
        {
            (vv).setText("X")
            symolPlayer="X"
        }
        else // player 2 y turn
        {
            (vv).setText("O")
            symolPlayer="O"
        }
        writePlayerSympol(vv.id,symolPlayer!!)
        counter++

        if(checkWinner("X")) //player 1 win // reinitalize
        {
            scorePlayer1+=1
            counter=0
            initiliazBoardState()
            symolPlayer=null
        }
        else if(checkWinner("O")) //player 2 win // reinitalize
        {
            scorePlayer2+=1
            counter=0
            initiliazBoardState()
            symolPlayer=null

        }
        else if(counter==9) // draw
        {
            counter=0
            initiliazBoardState()
            symolPlayer=null
        }
        scorePlayer1Textview!!.setText(scorePlayer1.toString())
        scorePlayer2Textview!!.setText(scorePlayer2.toString())

        if(scorePlayer1>scorePlayer2) status.setText(player1.text.toString()+" Wins")
        else if(scorePlayer2>scorePlayer1)status.setText(player2.text.toString()+" Wins")
        else status.setText("Draw")

    }
    private fun writePlayerSympol(id:Int,sympoll: String)
    {
        if(id==R.id.btn1)
        {
            boardState.set(0,sympoll)

        }
        else if(id==R.id.btn2)
        {
            boardState.set(1,sympoll)
        }
        else if(id==R.id.btn3)
        {
            boardState.set(2,sympoll)
        }
        else if(id==R.id.btn4)
        {
            boardState.set(3,sympoll)
        }
        else if(id==R.id.btn5)
        {
            boardState.set(4,sympoll)
        }
        else if(id==R.id.btn6)
        {
            boardState.set(5,sympoll)
        }
        else if(id==R.id.btn7)
        {
            boardState.set(6,sympoll)
        }
        else if(id==R.id.btn8)
        {
            boardState.set(7,sympoll)
        }
        else if(id==R.id.btn9)
        {
            boardState.set(8,sympoll)
        }
    }

    fun checkWinner(sympol:String):Boolean
    {

        for(i:Int in 0..8 step 3)
        {
            if(boardState.get(i).equals(sympol)&&boardState.get(i+1).equals(sympol)&&boardState.get(i+2).equals(sympol))
            {
                return true
            }
        }
        for(i :Int in 0..2)
        {
            if(boardState.get(i).equals(sympol)&&boardState.get(i+3).equals(sympol)&&boardState.get(i+6).equals(sympol))
            {
                return true
            }
        }
        if(boardState.get(0).equals(sympol)&&boardState.get(4).equals(sympol)&&boardState.get(8).equals(sympol))return true
        if(boardState.get(2).equals(sympol)&&boardState.get(4).equals(sympol)&&boardState.get(6).equals(sympol))return true

        return false

    }
}