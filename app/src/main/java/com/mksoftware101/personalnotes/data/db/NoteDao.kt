package com.mksoftware101.personalnotes.data.db

import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<Note>

    @Query("SELECT * FROM note_table WHERE id = :id")
    fun getNoteBy(id: Long): Note

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(vararg note: Note)

    @Delete
    fun delete(note: Note)

    @Update
    fun update(vararg note: Note)
}