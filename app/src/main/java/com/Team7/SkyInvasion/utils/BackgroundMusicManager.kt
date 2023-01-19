package com.Team7.Skyinvasion.utils

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.Team7.Skyinvasion.R

class BackgroundMusicManager(val context: Context) : LifecycleObserver {

    private var mediaPlayer: MediaPlayer? = null


    private fun startMusic() {
        mediaPlayer = MediaPlayer.create(context, R.raw.metal)
        mediaPlayer?.setOnPreparedListener {
            it.start()
        }
        mediaPlayer?.setOnCompletionListener {
            it.start()
        }
    }

    fun startPlaying() {
        if (mediaPlayer?.isPlaying != true)
            startMusic()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopPlaying() {
        mediaPlayer?.stop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun releaseComponents() {
        mediaPlayer?.release()
    }
}