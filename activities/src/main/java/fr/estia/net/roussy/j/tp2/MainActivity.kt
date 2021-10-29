package fr.estia.net.roussy.j.tp2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.estia.net.roussy.j.tp2.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnClickMe.setOnClickListener {
                nbClick++
                countingText.text = getString(R.string.you_click, nbClick)
                btnClickMe.isEnabled = nbClick <= 4
            }

            btnCompute.setOnClickListener {
                val intent = Intent(baseContext, ComputeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    /*
    // ********************* Fonction avec implémentation de l'interface ********************* //
    override fun onClick(view: View) {
        when(view.id) {
            R.id.clickButton -> {
                nbClick++
                countingText.text = getString(R.string.you_click, nbClick)
                clickButton.isEnabled = nbClick <= 4
            }

            R.id.computeButton -> {
                val intent = Intent(baseContext, ComputeActivity::class.java)
                startActivity(intent)
            }
        }


    */
}
