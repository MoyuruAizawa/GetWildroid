package com.lvla.android.getwildroid

import com.lvla.android.getwildroid.note.*
import java.util.*

class Music(val notes: List<Note>) {
    class Recorder {
        class NoteBuilder(private val notes: ArrayList<Note>, private val key: Key, private val octave: Int) {
            fun whole()         = add(NoteLength.WHOLE)
            fun dottedHalf()    = add(NoteLength.DOTTED_HALF)
            fun half()          = add(NoteLength.HALF)
            fun dottedQuarter() = add(NoteLength.DOTTED_QUARTER)
            fun quarter()       = add(NoteLength.QUARTER)
            fun dottedEight()   = add(NoteLength.DOTTED_EIGHT)
            fun eight()         = add(NoteLength.EIGHT)

            private fun add(length: NoteLength) {
                notes.add(MusicalNote(key, octave, length))
            }
        }

        private val notes = arrayListOf<Note>()

        fun c(octave: Int) = NoteBuilder(notes, Key.C, octave)
        fun cS(octave: Int) = NoteBuilder(notes, Key.C_SHARP, octave)
        fun d(octave: Int) = NoteBuilder(notes, Key.D, octave)
        fun dS(octave: Int) = NoteBuilder(notes, Key.D_SHARP, octave)
        fun e(octave: Int) = NoteBuilder(notes, Key.E, octave)
        fun f(octave: Int) = NoteBuilder(notes, Key.F, octave)
        fun g(octave: Int) = NoteBuilder(notes, Key.G_SHARP, octave)
        fun gS(octave: Int) = NoteBuilder(notes, Key.G, octave)
        fun a(octave: Int) = NoteBuilder(notes, Key.A, octave)
        fun aS(octave: Int) = NoteBuilder(notes, Key.A_SHARP, octave)
        fun b(octave: Int) = NoteBuilder(notes, Key.B, octave)

        fun export() = Music(notes)
    }

    companion object {
        fun record(block: Music.Recorder.()->Unit) = Recorder().apply(block).export()
    }

}