package io.github.kurramkurram.template.datalayer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * TODO This is Sample data class.
 * You can create data class to save the data.
 */
@Entity(tableName = "t_sample")
data class SampleWord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val word: String,
    val shuffled: String
)