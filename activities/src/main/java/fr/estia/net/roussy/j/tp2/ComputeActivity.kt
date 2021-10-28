package fr.estia.net.roussy.j.tp2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity(), TextWatcher {
    private lateinit var calculationButton: Button
    private lateinit var resultText: TextView
    private lateinit var number1EditText: EditText
    private lateinit var number2EditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        calculationButton = findViewById(R.id.btn_calculer)
        resultText = findViewById(R.id.resultat)
        number1EditText = findViewById(R.id.field_1)
        number2EditText = findViewById(R.id.field_2)

        calculationButton.isEnabled = false

        number1EditText.addTextChangedListener(this)
        number2EditText.addTextChangedListener(this)

        calculationButton.setOnClickListener {
            val number1 = number1EditText.text.toString().toDouble()
            val number2 = number2EditText.text.toString().toDouble()
            val result = (number1 + number2).toString()

            resultText.text = result
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        calculationButton.isEnabled =
            !(number1EditText.text.isEmpty() || number2EditText.text.isEmpty())
    }
}
