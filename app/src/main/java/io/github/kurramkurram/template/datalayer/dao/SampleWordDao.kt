package io.github.kurramkurram.template.datalayer.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.github.kurramkurram.template.datalayer.data.SampleWord

/**
 * This is sample.
 * A dao interface access database by query.
 */
@Dao
interface SampleWordDao {

    @Insert
    fun insert(sampleWord: SampleWord)

    @Query("SELECT * FROM t_sample WHERE word = :word LIMIT 1")
    fun selectWord(word: String): SampleWord

    @Query("SELECT * FROM t_sample")
    fun selectAll(): List<SampleWord>

    @Delete
    fun delete(sampleWord: SampleWord)

    @Query("DELETE FROM t_sample")
    fun deleteAll()
}