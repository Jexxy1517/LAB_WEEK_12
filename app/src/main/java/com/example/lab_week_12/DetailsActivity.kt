package com.example.lab_week_12.model

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.lab_week_12.R

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_RELEASE = "release"
        const val EXTRA_OVERVIEW = "overview"
        const val EXTRA_POSTER = "poster"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val titleText: TextView = findViewById(R.id.title_text)
        val releaseText: TextView = findViewById(R.id.release_text)
        val overviewText: TextView = findViewById(R.id.overview_text)
        val poster: ImageView = findViewById(R.id.movie_poster)

        val extras = intent.extras

        if (extras != null) {
            titleText.text = extras.getString(EXTRA_TITLE, "")
            releaseText.text = extras.getString(EXTRA_RELEASE, "")
            overviewText.text = extras.getString(EXTRA_OVERVIEW, "")

            val posterPath = extras.getString(EXTRA_POSTER)
            if (posterPath != null) {
                Glide.with(this)
                    .load("https://image.tmdb.org/t/p/w500$posterPath")
                    .into(poster)
            }
        }
    }
}