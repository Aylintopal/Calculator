package com.example.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnSayiTik(view: View){
        if (yeniOperator){
            sayiGoster.setText("")
        }
        yeniOperator = false

        var btnSec = view as Button
        var btnTikDeger:String = sayiGoster.text.toString()
        when (btnSec.id){
            btn0.id ->{
                btnTikDeger += "0"
            }
            btn1.id ->{
            btnTikDeger += "1"
        }
            btn2.id ->{
            btnTikDeger += "2"
        }
            btn3.id ->{
            btnTikDeger += "3"
        }
            btn4.id ->{
            btnTikDeger += "4"
        }
            btn5.id ->{
            btnTikDeger += "5"
        }
            btn6.id ->{
            btnTikDeger += "6"
        }
            btn7.id ->{
            btnTikDeger += "7"
        }
            btn8.id ->{
            btnTikDeger += "8"
        }
            btn9.id ->{
            btnTikDeger += "9"
        }
            btnArtiEksi.id ->{
                btnTikDeger = "-" + btnTikDeger
            }
        }
        sayiGoster.setText(btnTikDeger)
    }

    var operator = "*"
    var eskiSayi = ""
    var yeniOperator = true

    fun btnOpTik(view: View){
        var btnSec = view as Button
        when (btnSec.id){
            btnBol.id -> {
                operator = "/"
            }
            btnCarp.id -> {
                operator = "X"
            }
            btnCikar.id -> {
                operator = "-"
            }
            btnTopla.id -> {
                operator = "+"
            }
        }
        eskiSayi = sayiGoster.text.toString()
        yeniOperator = true
    }

    fun btnSonuc(view: View){
        var yeniSayi = sayiGoster.text.toString()
        var sonuc:Double? = null
        when(operator){
            "/" -> {
                sonuc = eskiSayi.toDouble() / yeniSayi.toDouble()
            }
            "X" -> {
                sonuc = eskiSayi.toDouble() * yeniSayi.toDouble()
            }
            "-" -> {
                sonuc = eskiSayi.toDouble() - yeniSayi.toDouble()
            }
            "+" -> {
                sonuc = eskiSayi.toDouble() + yeniSayi.toDouble()
            }
        }
        sayiGoster.setText(sonuc.toString())
        yeniOperator = true
    }

    fun btnAC(view: View){
        sayiGoster.setText("0")
        yeniOperator = true
    }

    fun btnYuzde(view: View){
        var sayi:Double = sayiGoster.text.toString().toDouble() / 100
        sayiGoster.setText(sayi.toString())
        yeniOperator  = true
    }
}