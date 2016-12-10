package com.lvla.android.getwildroid

import android.media.AudioFormat
import android.media.AudioManager
import android.media.AudioTrack
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.jetbrains.anko.button
import org.jetbrains.anko.onClick
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {
    val samplingRate = 44100
    val bufferSize = 39000

    val audioTrack by lazy {
        AudioTrack(AudioManager.STREAM_MUSIC,samplingRate, AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_DEFAULT, bufferSize, AudioTrack.MODE_STREAM)
    }
    val synth by lazy { Synthesizer(audioTrack, samplingRate, bufferSize) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            button("PLAY") {
                onClick { play() }
            }
        }
    }

    private fun play() {
        if (audioTrack.playState == AudioTrack.PLAYSTATE_PLAYING) {
            return
        }

        Toast.makeText(this, "PLAY", Toast.LENGTH_SHORT).show()
        val music = createMelody()
        synth.play(music)
    }

    private fun createMelody() = Recorder().record {
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
    }.export()
}
