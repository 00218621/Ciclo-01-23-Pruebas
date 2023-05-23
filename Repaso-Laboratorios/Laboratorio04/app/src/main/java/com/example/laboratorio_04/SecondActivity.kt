package com.example.laboratorio_04

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {
    private lateinit var _name:TextView
    private lateinit var _correo:TextView
    private lateinit var _telefono:TextView
    private lateinit var share_button:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        _name=findViewById(R.id.receive_name_text)
        _correo=findViewById(R.id.receive_correo_text)
        _telefono=findViewById(R.id.receive_telefono_text)
        share_button=findViewById(R.id.share_button)
        var key_name=intent.getStringExtra("name").toString()
        var key_correo=intent.getStringExtra("correo").toString()
        var key_telefono=intent.getStringExtra("telefono").toString()
        _name.setText(key_name)
        _correo.setText(key_correo)
        _telefono.setText(key_telefono)

        OnclickShare()

    }

    private fun shareButton(){
        var key_name=intent.getStringExtra("name").toString()
        var key_correo=intent.getStringExtra("correo").toString()
        var key_telefono=intent.getStringExtra("telefono").toString()

        val intent1=Intent().apply {
            action = Intent.ACTION_SEND_MULTIPLE
            putExtra(Intent.EXTRA_STREAM,"Nombre: "+key_name + "\n" +"Correo: "+ key_correo +"\n"+"Teléfono: "+
                    key_telefono)
            type="text/plain"
        }

        val share=Intent.createChooser(intent1,null)

        startActivity(share)
    }



    private fun OnclickShare(){
        share_button.setOnClickListener{
            shareButton()
        }
    }
}