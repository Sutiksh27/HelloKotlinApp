package com.sutikshverma.iambatman

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sutikshverma.iambatman.ui.theme.IamBATMANTheme
import android.media.MediaPlayer
import android.view.View

class MainActivity : ComponentActivity() {
    var mMediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val helloBtn = findViewById<Button>(R.id.helloButton)
        helloBtn.setOnClickListener {
            Log.v("I am Batman!", "Button Pressed!")
            Toast.makeText(this, "I AM BATMAN!", Toast.LENGTH_LONG).show()
            playSound()
        }
    }

    // 1. Plays the water sound
    fun playSound() {
        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.imbatman)
            mMediaPlayer!!.isLooping = false
            mMediaPlayer!!.start()
        } else mMediaPlayer!!.start()
    }


    // 4. Destroys the MediaPlayer instance when the app is closed
    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

}
