package com.lvla.android.getwildroid

import android.media.AudioTrack
import com.lvla.android.getwildroid.note.Note

class Synthesizer(private val audioTrack: AudioTrack,
                  private val samplingRate: Int,
                  private val bufferSize: Int) {

    fun play(music: Music) {
        music.notes.map { toSineWave(it) }

        Thread {
            audioTrack.play()
            music.notes.map { toSineWave(it) }
                    .forEach { audioTrack.write(it, 0, it.size) }
            audioTrack.stop()
        }.start()
    }

    private fun toSineWave(note: Note): ByteArray {
        with(note) {
            val noteLength = (bufferSize + length).toDouble()
            val buffer = ByteArray(Math.ceil(noteLength).toInt()) { i ->
                val wave = Math.sin( i / (samplingRate/frequency) * (Math.PI * 2) )
                if (wave > 0.0) Byte.MAX_VALUE else Byte.MIN_VALUE
            }
            return buffer
        }
    }

}