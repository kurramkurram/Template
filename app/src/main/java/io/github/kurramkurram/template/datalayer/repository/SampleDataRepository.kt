package io.github.kurramkurram.template.datalayer.repository

import android.content.Context
import io.github.kurramkurram.template.datalayer.data.SampleWord
import io.github.kurramkurram.template.datalayer.datasource.SampleDataSource
import io.github.kurramkurram.template.datalayer.datasource.SampleDataSourceImpl

/**
 * TODO This repository is sample.
 * You can create new repository class or use this repository class.
 * A repository class get some data from datasource classes.
 */
abstract class SampleRepository {

    /**
     * save to datasource.
     *
     * @param data [SampleWord]
     */
    abstract fun save(data: SampleWord)

    /**
     * get all data.
     *
     * @return [SampleWord]'s list.
     */
    abstract fun fetchAllWords(): List<SampleWord>

    /**
     * get a data which matched search word.
     *
     * @param word search word
     * @return search result
     */
    abstract fun fetchWord(word: String): SampleWord
}

class SampleRepositoryImpl(
    context: Context,
    private val sampleDataSource: SampleDataSource = SampleDataSourceImpl(context)
) : SampleRepository() {
    override fun save(data: SampleWord) = sampleDataSource.insert(data)
    override fun fetchAllWords(): List<SampleWord> = sampleDataSource.selectAll()
    override fun fetchWord(word: String): SampleWord = sampleDataSource.selectWord(word)
}