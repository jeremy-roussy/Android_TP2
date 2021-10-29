package fr.estia.net.roussy.j.tp2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import fr.estia.net.roussy.j.tp2.databinding.ComputeActivityBinding

class ComputeActivity : AppCompatActivity(), TextWatcher {
    private lateinit var binding: ComputeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        binding = ComputeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnCalculer.isEnabled = false
            field1.addTextChangedListener(this@ComputeActivity)
            field2.addTextChangedListener(this@ComputeActivity)
            btnCalculer.setOnClickListener {
                val number1 = field1.text.toString().toDouble()
                val number2 = field2.text.toString().toDouble()
                val result = (number1 + number2).toString()

                resultat.text = result
            }
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        binding.btnCalculer.isEnabled =
            (binding.field1.text.isNotEmpty() && binding.field2.text.isNotEmpty())
    }
}
