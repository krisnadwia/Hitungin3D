package com.krisnadwia.hitungin3d

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // set title
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.title = "Tentang Aplikasi"
        }

        val imgPhotoBackgroundView = findViewById<ImageView>(R.id.img_background_photo)
        val photoBackground: Int = R.drawable.logo_and_splash

        Glide.with(this)
            .load(photoBackground)
            .apply(RequestOptions().override(145, 145))
            .into(imgPhotoBackgroundView)
    }
}