package com.lvla.android.getwildroid

class Note {
    val key: Float
    val relativeLength: Float

    constructor(key: Float, length: Float) {
        this.key = key
        this.relativeLength = length
    }

    constructor(key: Key, length: NoteLength) {
        this.key = key.freq
        this.relativeLength = length.length
    }

    fun toByteArray(sampleRate: Int, barLength: Int): ByteArray {
        val noteLength = (barLength + relativeLength).toDouble()
        val buffer = ByteArray(Math.ceil(noteLength).toInt()) { i ->
            val wave = Math.sin( i / (sampleRate/key) * (Math.PI * 2) )
            if (wave > 0.0) Byte.MAX_VALUE else Byte.MIN_VALUE
        }
        return buffer
    }

    override fun toString(): String{
        return "Note(key=$key, length=$relativeLength)"
    }
}