package com.dzikyu.idnsolo.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.viewmodel.CreationExtras
import org.w3c.dom.Text
import java.util.EmptyStackException
import java.util.IllegalFormatWidthException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_calculate) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()
            var isEmpetyFields = false
            if (inputLength.isEmpty()){
                isEmpetyFields = true
                edtLength.error = "Field ini tidak boleh Kosong"
            }
            if (inputHeight.isEmpty()){
                isEmpetyFields = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }
            if (inputWidth.isEmpty()){
                isEmpetyFields = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }
            if (!isEmpetyFields){
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }
}
