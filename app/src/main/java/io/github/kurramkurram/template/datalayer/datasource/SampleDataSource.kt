package io.github.kurramkurram.template.datalayer.datasource

/**
 * This datasource is sample.
 * You can create new datasource class or use this datasource class.
 * A datasource class get some data from database, preference, datastore and so on...
 */
abstract class SampleDataSource {

    abstract fun selectAll()
}

class SampleDataSourceImpl() : SampleDataSource() {

    override fun selectAll() {
        TODO("Not yet implemented")
    }
}