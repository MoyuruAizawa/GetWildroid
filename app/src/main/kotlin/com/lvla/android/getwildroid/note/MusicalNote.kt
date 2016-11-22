package com.lvla.android.getwildroid.note

open class MusicalNote(private val key: Key, private val octave: Int, private val noteLength: NoteLength): Note() {
    override val frequency: Float
        get() = key.freq * Math.pow(2.0, octave.toDouble()).toFloat()

    override val length: Float
        get() = noteLength.length

    override fun toByteArray(sampleRate: Int, barLength: Int): ByteArray {
        val noteLength = (barLength + length).toDouble()
        val buffer = ByteArray(Math.ceil(noteLength).toInt()) { i ->
            val wave = Math.sin( i / (sampleRate/frequency) * (Math.PI * 2) )
            if (wave > 0.0) Byte.MAX_VALUE else Byte.MIN_VALUE
        }
        return buffer
    }
}