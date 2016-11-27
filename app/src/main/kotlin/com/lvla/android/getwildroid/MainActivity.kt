package com.lvla.android.getwildroid

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    val samplingRate = 44100
    val bufferSize = 39000

    val audioTrack by lazy {
        AudioTrack(AudioManager.STREAM_MUSIC,samplingRate, AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_DEFAULT, bufferSize, AudioTrack.MODE_STREAM)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById(R.id.play).setOnClickListener { play() }
    }

    private fun play() {
        if (audioTrack.playState == AudioTrack.PLAYSTATE_PLAYING) {
            return
        }

        val melodyMusic = createMelody().notes.map { it.toByteArray(samplingRate, bufferSize) }
        Thread {
            audioTrack.play()
            melodyMusic.forEach { audioTrack.write(it, 0, it.size) }
            audioTrack.stop()

        }.start()
    }

    private fun createMelody() = Music.record {
        dS(4).quarter()
        cS(4).quarter()
        b(3).quarter()
        rest().eight()
        dS(4).eight()

        cS(4).dottedEight()
        b(3).dottedEight()
        b(3).dottedQuarter()
        rest().eight()
        b(3).sixteenth()
        cS(4).sixteenth()

        dS(4).dottedEight()
        dS(4).dottedEight()
        e(4).eight()
        dS(4).dottedEight()
        b(3).dottedEight()
        dS(4).eight()

        dS(4).dottedEight()
        cS(4).dottedEight()
        b(3).quarter()
        rest().quarter()

        dS(4).quarter()
        cS(4).quarter()
        b(3).quarter()
        rest().eight()
        dS(4).eight()

        cS(4).dottedEight()
        b(3).dottedEight()
        b(3).dottedQuarter()
        rest().eight()
        b(3).sixteenth()
        cS(4).sixteenth()

        dS(4).dottedEight()
        dS(4).dottedEight()
        e(4).eight()
        dS(4).dottedEight()
        b(3).dottedEight()
        dS(4).eight()
        dS(4).dottedEight()
        cS(4).dottedEight()
        b(3).eight()
        b(3).quarter()
    }
}
