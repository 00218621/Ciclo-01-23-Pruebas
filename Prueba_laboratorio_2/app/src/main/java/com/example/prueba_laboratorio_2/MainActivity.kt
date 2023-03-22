package com.example.prueba_laboratorio_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var  weight_edit_text:EditText
    private lateinit var  height_edit_text:EditText
    private lateinit var  action_send_btn:Button
    private lateinit var  bmi_text:TextView
    private lateinit var  result_text:TextView
    private lateinit var  info_text:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bundin()
        set()
    }
    fun bundin(){
        weight_edit_text = findViewById(R.id.edit_text_weight)
        height_edit_text = findViewById(R.id.edit_text_height)
        action_send_btn=findViewById(R.id.action_send_btn)
        bmi_text=findViewById(R.id.bmi_text_view)
        result_text=findViewById(R.id.result_text_view)
        info_text=findViewById(R.id.info_text_view)
    }
    fun set(){
        action_send_btn.setOnClickListener{
            val weight=weight_edit_text.text.toString()
            val height=height_edit_text.text.toString()
            if (!Validator(weight,height)){
                clearResult()
                return@setOnClickListener
            }
            weight_edit_text.setText("")
            height_edit_text.setText("")
            val bmi=calculate(weight.toFloat(),height.toFloat())
            val bmiTwoDigits=String.format("%.2f",bmi).toFloat()
            Result(bmiTwoDigits)
        }
    }
    private fun Validator(weight: String?,height:String?):Boolean{
        return when{
            weight.isNullOrEmpty() -> {
                Toast.makeText(this,"weight is empty",Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this,"height is empty",Toast.LENGTH_SHORT).show()
                return false
            }
            else -> true
        }
    }
    private fun calculate(weight: Float, height: Float): Float = weight/ ( (height / 100) * (height / 100))

    private fun Result(bmi: Float){
        bmi_text.text=bmi.toString()
        info_text.text=getString(R.string.normal_weight_info)
        var infoResult=""
        var color = 0

        when{
            bmi < 18.50 -> {
                infoResult=getString(R.string.under_weight_label)
                color = R.color.under_weight
            }
            bmi in 18.50..24.99 -> {
               infoResult=getString(R.string.normal_weight_info)
                color = R.color.normal_weight
            }
            bmi in 24.99..29.99 -> {
                infoResult=getString(R.string.over_weight_label)
                color = R.color.over_weight
            }
            bmi >29.99 -> {
            infoResult=getString(R.string.obese_label)
            color = R.color.obese
            }
        }
        result_text.setTextColor(ContextCompat.getColor(this,color))
        result_text.text=infoResult
    }

    private fun clearResult() {
        bmi_text.text=""
        result_text.text=""
        info_text.text=""
    }
}