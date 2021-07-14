package com.example.lotto

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*


class MainActivity : AppCompatActivity() {
    private val random = Random()
    private val numbers = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<Button>(R.id.buttonNum1)
        val num2 = findViewById<Button>(R.id.buttonNum2)
        val num3 = findViewById<Button>(R.id.buttonNum3)
        val num4 = findViewById<Button>(R.id.buttonNum4)
        val num5 = findViewById<Button>(R.id.buttonNum5)
        val num6 = findViewById<Button>(R.id.buttonNum6)

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener{
            numbers.clear()
            setLottoNum(num1)
            setLottoNum(num2)
            setLottoNum(num3)
            setLottoNum(num4)
            setLottoNum(num5)
            setLottoNum(num6)
        }

    }

    private fun setLottoNum(lottoNum: Button) {
        var n = 0
        while (true) {
            n = random.nextInt(45) + 1
            if ( !numbers.contains(n) ) {
                numbers.add(n)
                break
            }
        }
        lottoNum.text = "${n}"

        if ( n <= 10 ) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,200,0))
        } else if ( n <= 20  ) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,0,80))
        } else if ( n <= 30  ) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,0,0))
        } else if ( n <= 40  ) {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
        } else {
            lottoNum.backgroundTintList = ColorStateList.valueOf(Color.YELLOW)
        }

    }
}
