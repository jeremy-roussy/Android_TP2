package fr.estia.net.roussy.j.tp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private lateinit var computeButton: Button
    private lateinit var countingText: TextView
    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        clickButton = findViewById(R.id.btn_click_me)
        computeButton = findViewById(R.id.btn_compute)
        countingText = findViewById(R.id.counting_text)

        clickButton.setOnClickListener {
            nbClick++
            val newText = "Vous avez cliquez $nbClick fois"
            countingText.text = newText
            if (nbClick == 5) {
                clickButton.isEnabled = false
            }
        }

        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }
}
