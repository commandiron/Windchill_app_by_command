package com.demirli.a32windchillexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var temprature: Double? = null
    private var speed: Double? = null
    private var wci: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switch1.setOnClickListener {
            setMetricOrImperial()
        }

        calculate_btn.setOnClickListener {
            if(temprature_et.text.toString() != "" && speed_et.text.toString() != ""){
                calculate()
            }
        }
    }

    fun setMetricOrImperial(){

        if(switch1.isChecked){
            temprature_et.setHint("Enter Tempreture F°")
            speed_et.setHint("Enter Speed mph")
        }else{
            temprature_et.setHint("Enter Tempreture C°")
            speed_et.setHint("Enter Speed km/h")
        }
    }

    fun calculate(){

        temprature = temprature_et.text.toString().toDouble()
        speed = speed_et.text.toString().toDouble()

        if(switch1.isChecked){
            wci = 35.74 + 0.6215*temprature!! - 35.75*Math.pow(speed!!,0.16) + 0.4275*temprature!!*Math.pow(speed!!,0.16)
        }else{
            wci = 13.12 + 0.6215*temprature!! - 11.37*Math.pow(speed!!,0.16) + 0.3965*temprature!!*Math.pow(speed!!,0.16)
        }

        wci_tv.setText("WCI: " + Math.round(wci!!).toString())
    }
}
