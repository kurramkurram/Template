package io.github.kurramkurram.template.model

import io.github.kurramkurram.template.datalayer.repository.SampleRepository
import io.github.kurramkurram.template.datalayer.repository.SampleRepositoryImpl

/**
 * This usecase is sample.
 * A usecase execute the business logic.
 */
class SampleUseCase(private val sampleDataRepository: SampleRepository = SampleRepositoryImpl()) {

    fun shuffleWord() {
        sampleDataRepository.fetchAllWords()
    }
}