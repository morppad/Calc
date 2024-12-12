package com.example.calc
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editTextResult: EditText
    private var operand1: Double? = null
    private var operator: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextResult = findViewById(R.id.editTextResult)

        // Обработка нажатий кнопок
        findViewById<Button>(R.id.button0).setOnClickListener { appendToResult("0") }
        findViewById<Button>(R.id.button1).setOnClickListener { appendToResult("1") }
        findViewById<Button>(R.id.button2).setOnClickListener { appendToResult("2") }
        findViewById<Button>(R.id.button3).setOnClickListener { appendToResult("3") }
        findViewById<Button>(R.id.button4).setOnClickListener { appendToResult("4") }
        findViewById<Button>(R.id.button5).setOnClickListener { appendToResult("5") }
        findViewById<Button>(R.id.button6).setOnClickListener { appendToResult("6") }
        findViewById<Button>(R.id.button7).setOnClickListener { appendToResult("7") }
        findViewById<Button>(R.id.button8).setOnClickListener { appendToResult("8") }
        findViewById<Button>(R.id.button9).setOnClickListener { appendToResult("9") }

        findViewById<Button>(R.id.buttonPlus).setOnClickListener { setOperator("+") }
        findViewById<Button>(R.id.buttonMinus).setOnClickListener { setOperator("-") }
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { setOperator("*") }
        findViewById<Button>(R.id.buttonDivide).setOnClickListener { setOperator("/") }

        findViewById<Button>(R.id.buttonEqual).setOnClickListener { calculateResult() }
        findViewById<Button>(R.id.buttonClear).setOnClickListener { clearResult() }
    }

    private fun appendToResult(value: String) {
        editTextResult.setText(editTextResult.text.toString() + value)
    }

    private fun setOperator(op: String) {
        operand1 = editTextResult.text.toString().toDoubleOrNull()
        operator = op
        editTextResult.setText("")
    }

    private fun calculateResult() {
        val operand2 = editTextResult.text.toString().toDoubleOrNull()
        if (operand1 != null && operand2 != null && operator != null) {
            val result = when (operator) {
                "+" -> operand1!! + operand2
                "-" -> operand1!! - operand2
                "*" -> operand1!! * operand2
                "/" -> if (operand2 != 0.0) operand1!! / operand2 else "Error"
                else -> 0.0
            }
            editTextResult.setText(result.toString())
            // Сброс операторов для следующих вычислений
            operand1 = null
            operator = null
        }
    }

    private fun clearResult() {
        editTextResult.setText("")
        operand1 = null
        operator = null
    }
}