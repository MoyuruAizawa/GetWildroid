package com.lvla.android.getwildroid.note

abstract class Note {
    abstract val frequency: Float
    abstract val relativeLength: Float

    fun toByteArray(sampleRate: Int, barLength: Int): ByteArray {
        val noteLength = (barLength + relativeLength).toDouble()
        val buffer = ByteArray(Math.ceil(noteLength).toInt()) { i ->
            val wave = Math.sin( i / (sampleRate/frequency) * (Math.PI * 2) )
            if (wave > 0.0) Byte.MAX_VALUE else Byte.MIN_VALUE
        }
        return buffer
    }

}