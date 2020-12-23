package edu.ucsb.cs.cs184.kstubbschangemaker

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var value = ""

    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var text3: TextView
    private lateinit var text4: TextView
    private lateinit var text5: TextView
    private lateinit var text6: TextView
    private lateinit var text7: TextView
    private lateinit var text8: TextView
    private lateinit var finalText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val box1: Button = findViewById(R.id.button1)
        val box2: Button = findViewById(R.id.button2)
        val box3: Button = findViewById(R.id.button3)
        val box4: Button = findViewById(R.id.button4)
        val box5: Button = findViewById(R.id.button5)
        val box6: Button = findViewById(R.id.button6)
        val box7: Button = findViewById(R.id.button7)
        val box8: Button = findViewById(R.id.button8)
        val box9: Button = findViewById(R.id.button9)
        val box0: Button = findViewById(R.id.button0)
        val boxClear: Button = findViewById(R.id.buttonClear)

        text1 = findViewById(R.id.textView)
        text2 = findViewById(R.id.textView2)
        text3 = findViewById(R.id.textView3)
        text4 =  findViewById(R.id.textView4)
        text5 = findViewById(R.id.textView5)
        text6 = findViewById(R.id.textView6)
        text7 = findViewById(R.id.textView7)
        text8 = findViewById(R.id.textView8)
        finalText = findViewById(R.id.textView9)

        box1.setOnClickListener {
            value += "1"
            printvalues()
        }

        box2.setOnClickListener {
            value += "2"
            printvalues()
        }

        box3.setOnClickListener {
            value += "3"
            printvalues()
        }

        box4.setOnClickListener {
            value += "4"
            printvalues()
        }

        box5.setOnClickListener {
            value += "5"
            printvalues()
        }

        box6.setOnClickListener {
            value += "6"
            printvalues()
        }

        box7.setOnClickListener {
            value += "7"
            printvalues()
        }

        box8.setOnClickListener {
            value += "8"
            printvalues()
        }

        box9.setOnClickListener {
            value += "9"
            printvalues()
        }

        box0.setOnClickListener {
            if (value.equals("0") || value.equals(""))
                return@setOnClickListener
            value += "0"
            printvalues()
        }

        boxClear.setOnClickListener {
            value = "0"
            printvalues()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            if (value.equals(""))
                putInt("value", 0)
            else
                putInt("value", value.toInt())
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.run {
            value = getInt("value").toString()
            printvalues()
        }
    }

    fun printvalues() {
        var text1value = 0
        var text2value = 0
        var text3value = 0
        var text4value = 0
        var text5value = 0
        var text6value = 0
        var text7value = 0
        var text8value = 0

        var valueCopy = value.toInt()

        if (value.length == 1)
            finalText.text = "Price:  .0" + value
        else if (value.length == 2)
            finalText.text = "Price:  ." + value
        else
            finalText.text = "Price:  " + value.substring(0, value.length-2) + "." + value.substring(value.length-2, value.length)

        while (valueCopy > 0) {
            if (valueCopy >= 2000) {
                valueCopy -= 2000
                text1value++
            }
            else if (valueCopy >= 1000) {
                valueCopy -= 1000
                text2value++
            }
            else if (valueCopy >= 500) {
                valueCopy -= 500
                text3value++
            }
            else if (valueCopy >= 100) {
                valueCopy -= 100
                text4value++
            }
            else if (valueCopy >= 25) {
                valueCopy -= 25
                text5value++
            }
            else if (valueCopy >= 10) {
                valueCopy -= 10
                text6value++
            }
            else if (valueCopy >= 5) {
                valueCopy -= 5
                text7value++
            }
            else if (valueCopy >= 1) {
                valueCopy -= 1
                text8value++
            }
        }

        text1.text = "$20: " + text1value
        text2.text = "$10: " + text2value
        text3.text = "$5: " + text3value
        text4.text = "$1: " + text4value
        text5.text = "25¢: " + text5value
        text6.text = "10¢: " + text6value
        text7.text = "5¢: " + text7value
        text8.text = "1¢: " + text8value

        if (value.equals("0"))
            value = ""
    }
}