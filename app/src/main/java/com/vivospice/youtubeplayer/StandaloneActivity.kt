package com.vivospice.youtubeplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_standalone.*
import java.lang.IllegalArgumentException

class StandaloneActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standalone)

//        If the activity implements the onClickListener interface, it can be passed whenever the
//        onClickListener's implementation's needed.
        btnPlayVideo.setOnClickListener(this)
        btnPlaylist.setOnClickListener(this)
/*
        **** other ways for setOnclickListener ***
        1. using object
        btnPlayVideo.setOnClickListener( object: View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

        2. Using a lambda expression. Okay for single button.
        btnPlayVideo.setOnClickListener(View.OnClickListener { v -> TODO("not implemented")   })

        3. Created a new onClickListener object and assign it to a variable.
        * with an anonymous inner class and assign an instance of that variable
        val listener = View.OnClickListener { v -> TODO("not implemented")  }
        btnPlayVideo.setOnClickListener(listener)
        btnPlaylist.setOnClickListener(listener)
*/

    }

    override fun onClick(v: View) {
//checks to see which button was tapped to call the onClick function, then sets the data for an intent before calling startActivity.
        val intent = when (v.id) {
            R.id.btnPlayVideo -> YouTubeStandalonePlayer.createVideoIntent(this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_VIDEO_ID, 0, true, true)

            R.id.btnPlaylist -> YouTubeStandalonePlayer.createPlaylistIntent(this, getString(R.string.GOOGLE_API_KEY), YOUTUBE_PLAYLIST, 0, 0, true, true)

            else -> throw IllegalArgumentException("Undefined button clicked")
        }
        startActivity(intent)
    }
}