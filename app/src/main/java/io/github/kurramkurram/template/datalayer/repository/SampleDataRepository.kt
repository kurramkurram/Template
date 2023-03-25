package io.github.kurramkurram.template.datalayer.repository

import io.github.kurramkurram.template.datalayer.datasource.SampleDataSource
import io.github.kurramkurram.template.datalayer.datasource.SampleDataSourceImpl

/**
 * This repository is sample.
 * You can create new repository class or use this repository class.
 * A repository class get some data from datasource classes.
 */
abstract class SampleRepository {

    abstract fun fetchAllWords()

}

class SampleRepositoryImpl(
    private val sampleDataSource: SampleDataSource = SampleDataSourceImpl()
) : SampleRepository() {

    override fun fetchAllWords() {

    }
}