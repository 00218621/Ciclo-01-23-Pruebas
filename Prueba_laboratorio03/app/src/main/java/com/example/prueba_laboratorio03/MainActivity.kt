package com.example.prueba_laboratorio03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var Count=0.00
    private lateinit var CountMoney:TextView
    private lateinit var ClickFiveCtv:ImageView

    private lateinit var ClickTenCtv:ImageView
    private lateinit var DisplayFiveCtv:TextView
    private lateinit var DisplayTenCtv:TextView
    private lateinit var DisplayQuarterCtv:TextView
    private lateinit var DisplayDollarCtv:TextView
    private lateinit var ClickQuarterCtv:ImageView
    private lateinit var ClickDollarCtv:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bin()
        onListener()

    }
    fun bin(){
        ClickFiveCtv=findViewById(R.id.five_cts_image)
        DisplayFiveCtv=findViewById(R.id.five_cts_text)
        CountMoney=findViewById(R.id.count_text)
        DisplayTenCtv=findViewById(R.id.ten_cts_text)
        ClickTenCtv=findViewById(R.id.ten_cts_image)
        DisplayQuarterCtv=findViewById(R.id.quarter_cts_text)
        ClickQuarterCtv=findViewById(R.id.quarter_cts_image)
        DisplayDollarCtv=findViewById(R.id.dollar_cts_text)
        ClickDollarCtv=findViewById(R.id.dollar_cts_image)
    }
    fun onListenerFiveCtv(){
        ClickFiveCtv.setOnClickListener{
            Count+= DisplayFiveCtv.text.toString().toFloat()
            CountMoney.setText("$"+String.format("%.2f",Count).toFloat().toString())
        }

    }
    fun onListenerTenCtv(){
        ClickTenCtv.setOnClickListener{
            Count+= DisplayTenCtv.text.toString().toFloat()
            CountMoney.setText("$"+String.format("%.2f",Count).toFloat().toString())
        }
    }
    fun onListenerQuarterCtv(){
        ClickQuarterCtv.setOnClickListener{
            Count+= DisplayQuarterCtv.text.toString().toFloat()
            CountMoney.setText("$"+String.format("%.2f",Count).toFloat().toString())
        }
    }
    fun onListenerDollarCtv(){
        ClickDollarCtv.setOnClickListener{
            Count+= DisplayDollarCtv.text.toString().toFloat()
            CountMoney.setText("$"+String.format("%.2f",Count).toFloat().toString())
        }
    }
    fun onListener(){
        onListenerFiveCtv()
        onListenerTenCtv()
        onListenerQuarterCtv()
        onListenerDollarCtv()
    }


}