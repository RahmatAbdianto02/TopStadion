package com.dicoding.topstadion

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object{
        const val KEY_HERO = "key_hero"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgStadion : ImageView = findViewById(R.id.imageView)
        val tvName : TextView = findViewById(R.id.textView)
        val tvDesription : TextView = findViewById(R.id.textView2)

        val stadion = intent.getParcelableExtra<Stadion>(KEY_HERO)
        stadion?.let {
            Glide.with(this)
                .load(it.photo)
                .into(imgStadion)
            tvName.text = it.name
            tvDesription.text = it.description
        }

    }
}