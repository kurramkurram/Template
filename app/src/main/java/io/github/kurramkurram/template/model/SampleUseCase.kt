package io.github.kurramkurram.template.model

import android.content.Context
import io.github.kurramkurram.template.datalayer.data.SampleWord
import io.github.kurramkurram.template.datalayer.repository.SampleRepository
import io.github.kurramkurram.template.datalayer.repository.SampleRepositoryImpl
import io.github.kurramkurram.template.util.L
import kotlin.random.Random

/**
 * This usecase is sample.
 * A usecase execute the business logic.
 */
class SampleUseCase(
    context: Context,
    private val sampleDataRepository: SampleRepository = SampleRepositoryImpl(context = context)
) {

    /**
     * Shuffle the word.
     *
     * @param word entered word
     * @return shuffled word
     */
    fun shuffleWord(word: String): String {
        // Shuffle Word
        val wordArray = CharArray(word.length)
        for ((index, v) in word.withIndex()) {
            wordArray[index] = v
        }
        wordArray.shuffle()

        var shuffledWord = ""
        for (v in wordArray) {
            shuffledWord += v
        }

        L.d(TAG, "#shuffleWord shuffledWord = $shuffledWord")

        return shuffledWord
    }

    /**
     * Save word to database.
     *
     * @param word entered word
     * @param shuffledWord shuffled word
     */
    fun saveWord(word: String, shuffledWord: String) {
        sampleDataRepository.save(SampleWord(word = word, shuffled = shuffledWord))
    }

    companion object {
        private const val TAG = "SampleUseCase"
    }
}