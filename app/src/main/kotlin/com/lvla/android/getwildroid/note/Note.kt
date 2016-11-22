package com.lvla.android.getwildroid.note

abstract class Note {
    abstract val frequency: Float
    abstract val length: Float

    abstract fun toByteArray(sampleRate: Int, barLength: Int): ByteArray
}