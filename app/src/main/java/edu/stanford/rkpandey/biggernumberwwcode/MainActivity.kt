package edu.stanford.rkpandey.biggernumberwwcode

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignRandomNumbersToButtons()
        btnLeft.setOnClickListener {
            compareTwoButtons(true)
            assignRandomNumbersToButtons()
        }

        btnRight.setOnClickListener {
            compareTwoButtons(false)
            assignRandomNumbersToButtons()
        }
    }

    private fun compareTwoButtons(isLeftBtnClicked: Boolean) {
        val leftNum = btnLeft.text.toString().toInt()
        val rightNum = btnRight.text.toString().toInt()

        val isAnswerCorrect = if (isLeftBtnClicked) leftNum > rightNum else rightNum > leftNum
        if (isAnswerCorrect) {
            backgroundView.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show()
        } else {
            backgroundView.setBackgroundColor(Color.RED)
            Toast.makeText(this, "wrong number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun assignRandomNumbersToButtons() {
        val r = Random()
        val num1 = r.nextInt(10)
        var num2 = num1
        while (num2 == num1) {
            num2 = r.nextInt(10)
        }

        btnLeft.text = "$num1"
        btnRight.text = "$num2"
    }


}
