package com.lvla.android.getwildroid.note

class RestNote(private val noteLength: NoteLength): Note() {
    override val frequency: Float
        get() = 0f
    override val length: Float
        get() = noteLength.length

    override fun toByteArray(sampleRate: Int, barLength: Int): ByteArray {
        val noteLength = (barLength + length).toDouble()
        val buffer = ByteArray(Math.ceil(noteLength).toInt()) { i->
            0
        }
        return buffer
    }
}