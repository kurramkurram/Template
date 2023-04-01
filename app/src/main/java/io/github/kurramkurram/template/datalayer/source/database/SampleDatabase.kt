package io.github.kurramkurram.template.datalayer.source.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.github.kurramkurram.template.datalayer.dao.SampleWordDao
import io.github.kurramkurram.template.datalayer.data.SampleWord

/**
 * This database is sample.
 */
@Database(entities = [SampleWord::class], version = 1, exportSchema = false)
abstract class SampleDatabase : RoomDatabase() {

    abstract fun sampleWordDao(): SampleWordDao

    companion object {
        @Volatile
        private var INSTANCE: SampleDatabase? = null

        private const val dbName = "Sample.db"

        fun getDatabases(context: Context): SampleDatabase {
            val tmpInstance = INSTANCE

            if (tmpInstance != null) return tmpInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SampleDatabase::class.java,
                    dbName
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}