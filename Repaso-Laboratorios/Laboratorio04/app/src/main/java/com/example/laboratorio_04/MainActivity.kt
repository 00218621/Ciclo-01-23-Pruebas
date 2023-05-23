package com.example.laboratorio_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    private lateinit var send_button:Button
    private lateinit var name_editText:EditText
    private lateinit var correo_editText:EditText
    private lateinit var telefono_editText:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "OnCreate")
        buding()
            SendData()

    }
    fun buding(){
        name_editText=findViewById(R.id.name_editTextView)
        send_button=findViewById(R.id.send_button)
        correo_editText=findViewById(R.id.correo_editText)
        telefono_editText=findViewById(R.id.telefono_editText)

    }
    fun SendData(){
        send_button.setOnClickListener{
            val intent= Intent(this,SecondActivity::class.java)
            intent.putExtra("name",name_editText.text.toString())
            intent.putExtra("correo",correo_editText.text.toString())
            intent.putExtra("telefono",telefono_editText.text.toString())
            startActivity(intent)
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "OnRestart")
    }

    companion object {
        const val TAG = "com.example.MainActivity"
    }
}