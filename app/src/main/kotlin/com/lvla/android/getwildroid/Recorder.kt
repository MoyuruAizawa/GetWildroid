package com.lvla.android.getwildroid

import com.lvla.android.getwildroid.note.*
import java.util.*

class Recorder {
    private val notes = arrayListOf<Note>()

    fun c(octave: Int) = MusicalNoteBuilder(Key.C, octave, notes)
    fun cS(octave: Int) = MusicalNoteBuilder(Key.C_SHARP, octave, notes)
    fun d(octave: Int) = MusicalNoteBuilder(Key.D, octave, notes)
    fun dS(octave: Int) = MusicalNoteBuilder(Key.D_SHARP, octave, notes)
    fun e(octave: Int) = MusicalNoteBuilder(Key.E, octave, notes)
    fun f(octave: Int) = MusicalNoteBuilder(Key.F, octave, notes)
    fun fS(octave: Int) = MusicalNoteBuilder(Key.F_SHARP, octave, notes)
    fun g(octave: Int) = MusicalNoteBuilder(Key.G_SHARP, octave, notes)
    fun gS(octave: Int) = MusicalNoteBuilder(Key.G, octave, notes)
    fun a(octave: Int) = MusicalNoteBuilder(Key.A, octave, notes)
    fun aS(octave: Int) = MusicalNoteBuilder(Key.A_SHARP, octave, notes)
    fun b(octave: Int) = MusicalNoteBuilder(Key.B, octave, notes)
    fun rest() = RestNoteBuilder(notes)

    fun record(block: Recorder.()->Unit) = apply(block)
    fun export() = Music(notes)


    abstract class NoteBuilder(protected val notes: ArrayList<Note>) {
        fun whole() = newNote(NoteLength.NOTE_1)
        fun dottedHalf() = newNote(NoteLength.NOTE_2_DOTTED)
        fun half() = newNote(NoteLength.NOTE_2)
        fun dottedQuarter() = newNote(NoteLength.NOTE_4_DOTTED)
        fun quarter() = newNote(NoteLength.NOTE_4)
        fun dottedEight() = newNote(NoteLength.NOTE_8_DOTTED)
        fun eight() = newNote(NoteLength.NOTE_8)
        fun dottedSixteenth() = newNote(NoteLength.NOTE_16_DOTTED)
        fun sixteenth() = newNote(NoteLength.NOTE_16)

        abstract protected fun newNote(length: NoteLength)
    }

    class MusicalNoteBuilder(private val key: Key,
                             private val octave: Int,
                             notes: ArrayList<Note>): NoteBuilder(notes) {

        override fun newNote(length: NoteLength) {
            notes.add(MusicalNote(key, octave, length))
        }
    }

    class RestNoteBuilder(notes: ArrayList<Note>): NoteBuilder(notes) {

        override fun newNote(length: NoteLength) {
            notes.add(RestNote(length))
        }
    }
}