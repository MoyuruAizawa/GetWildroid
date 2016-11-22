package com.lvla.android.getwildroid.note

open class MusicalNote(private val key: Key, private val octave: Int, private val noteLength: NoteLength): Note() {
    override val frequency: Float
        get() = key.freq * Math.pow(2.0, octave.toDouble()).toFloat()

    override val relativeLength: Float
        get() = noteLength.length
}