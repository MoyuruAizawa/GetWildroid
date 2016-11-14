package com.lvla.android.getwildroid

enum class Note(val relativeLength: Float) {
    WHOLE(1f),
    HALF(0.5f),
    QUARTER(0.25f),
    EIGHT(0.125f);

    fun dotted() = relativeLength * 1.5
}