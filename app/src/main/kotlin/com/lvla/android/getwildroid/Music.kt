package com.lvla.android.getwildroid

import com.lvla.android.getwildroid.note.*
import java.util.*

class Music(val notes: List<Note>) {
    class Recorder {
        abstract class NoteBuilder(protected val notes: ArrayList<Note>) {
            fun whole() {
                notes.add(newNote(NoteLength.NOTE_1))
            }
            fun dottedHalf() {
                notes.add(newNote(NoteLength.NOTE_2_DOTTED))
            }
            fun half() {
                notes.add(newNote(NoteLength.NOTE_2))
            }
            fun dottedQuarter() {
                notes.add(newNote(NoteLength.NOTE_4_DOTTED))
            }
            fun quarter() {
                notes.add(newNote(NoteLength.NOTE_4))
            }
            fun dottedEight() {
                notes.add(newNote(NoteLength.NOTE_8_DOTTED))
            }
            fun eight() {
                notes.add(newNote(NoteLength.NOTE_8))
            }
            fun dottedSixteenth() {
                notes.add(newNote(NoteLength.NOTE_16_DOTTED))
            }
            fun sixteenth() {
                notes.add(newNote(NoteLength.NOTE_16))
            }

            abstract protected fun newNote(length: NoteLength): Note
        }

        class MusicalNoteBuilder(notes: ArrayList<Note>, private val key: Key, private val octave: Int): NoteBuilder(notes) {
            override fun newNote(length: NoteLength) = MusicalNote(key, octave, length)
        }

        class RestNoteBuilder(notes: ArrayList<Note>): NoteBuilder(notes) {
            override fun newNote(length: NoteLength) = RestNote(length)
        }

        private val notes = arrayListOf<Note>()

        fun c(octave: Int) = MusicalNoteBuilder(notes, Key.C, octave)
        fun cS(octave: Int) = MusicalNoteBuilder(notes, Key.C_SHARP, octave)
        fun d(octave: Int) = MusicalNoteBuilder(notes, Key.D, octave)
        fun dS(octave: Int) = MusicalNoteBuilder(notes, Key.D_SHARP, octave)
        fun e(octave: Int) = MusicalNoteBuilder(notes, Key.E, octave)
        fun f(octave: Int) = MusicalNoteBuilder(notes, Key.F, octave)
        fun fS(octave: Int) = MusicalNoteBuilder(notes, Key.F_SHARP, octave)
        fun g(octave: Int) = MusicalNoteBuilder(notes, Key.G_SHARP, octave)
        fun gS(octave: Int) = MusicalNoteBuilder(notes, Key.G, octave)
        fun a(octave: Int) = MusicalNoteBuilder(notes, Key.A, octave)
        fun aS(octave: Int) = MusicalNoteBuilder(notes, Key.A_SHARP, octave)
        fun b(octave: Int) = MusicalNoteBuilder(notes, Key.B, octave)
        fun rest() = RestNoteBuilder(notes)

        fun export() = Music(notes)
    }

    companion object {
        fun record(block: Music.Recorder.()->Unit) = Recorder().apply(block).export()
    }

}