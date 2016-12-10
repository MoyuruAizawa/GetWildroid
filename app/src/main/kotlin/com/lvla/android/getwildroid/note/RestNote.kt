package com.lvla.android.getwildroid.note

class RestNote(private val noteLength: NoteLength): Note() {
    override val frequency: Float
        get() = 0f
    override val length: Float
        get() = noteLength.length
}