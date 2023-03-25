package io.github.kurramkurram.template.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.github.kurramkurram.template.model.SampleUseCase

/**
 * Main fragment view model.
 */
class MainViewModel(private val application: Application) : AndroidViewModel(application) {
    private val sampleUseCase: SampleUseCase = SampleUseCase()

    fun getWordList() {
        sampleUseCase.shuffleWord()
    }
}