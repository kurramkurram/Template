package io.github.kurramkurram.template.datalayer.datasource

import android.content.Context
import io.github.kurramkurram.template.datalayer.data.SampleWord
import io.github.kurramkurram.template.datalayer.source.database.SampleDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This datasource is sample.
 * You can create new datasource class or use this datasource class.
 * A datasource class get some data from database, preference, datastore and so on...
 */
abstract class SampleDataSource {

    /**
     * insert to database.
     *
     * @param sampleWord [SampleWord]
     */
    abstract fun insert(sampleWord: SampleWord)

    /**
     * get all data.
     *
     * @return [SampleWord]'s list.
     */
    abstract fun selectAll(): List<SampleWord>

    /**
     * get a data which matched search word.
     *
     * @param word search word
     * @return search result
     */
    abstract fun selectWord(word: String): SampleWord
}

class SampleDataSourceImpl(
    context: Context,
    private val database: SampleDatabase = SampleDatabase.getDatabases(context)
) : SampleDataSource() {

    override fun insert(sampleWord: SampleWord) {
        CoroutineScope(Dispatchers.IO).launch {
            val dao = database.sampleWordDao()
            dao.insert(sampleWord = sampleWord)
        }
    }

    override fun selectAll(): List<SampleWord> {
        val dao = database.sampleWordDao()
        return dao.selectAll()
    }

    override fun selectWord(word: String): SampleWord {
        val dao = database.sampleWordDao()
        return dao.selectWord(word)
    }
}