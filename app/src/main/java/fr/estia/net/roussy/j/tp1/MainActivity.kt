package fr.estia.net.roussy.j.tp1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.my_button)
        button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val linkList = listOf(
            "https://picsum.photos/300/300?random=1",
            "https://picsum.photos/300/300?random=2",
            "https://picsum.photos/300/300?random=3",
            "https://picsum.photos/300/300?random=4",
            "https://picsum.photos/300/300?random=6",
            "https://picsum.photos/300/300?random=7",
            "https://picsum.photos/300/300?random=8",
            "https://picsum.photos/300/300?random=9",
            "https://picsum.photos/300/300?random=10",
        )
        val link = linkList.random()
        Toast.makeText(this, "You clicked me", Toast.LENGTH_SHORT).show()
        loadImage(link)
    }

    private fun loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .fallback(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}
