package com.lvla.android.getwildroid

enum class Key private constructor(val freq: Float) {
    A3(220.0f),
    A_S3(233.081880f),
    B3(246.941650f),
    C3(261.625565f),
    C_S3(277.182630f),
    D3(293.664767f),
    D_S3(311.126983f),
    E3(329.627556f),
    F3(349.228231f),
    F_S3(369.994227f),
    G3(391.994535f),
    G_S3(415.304697f);

    fun changeOctave(octave: Int) = freq * Math.pow(2.0 , octave.toDouble())
}