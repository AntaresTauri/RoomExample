package com.antares.roomexample.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: String)

    @Query("SELECT * FROM notes")
    fun loadAllNotes(): List<String>

}