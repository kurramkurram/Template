package io.github.kurramkurram.template.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.github.kurramkurram.template.model.SampleUseCase
import io.github.kurramkurram.template.util.showLongToast

/**
 * Main fragment view model.
 */
class MainViewModel(private val application: Application) : AndroidViewModel(application) {
    private val sampleUseCase: SampleUseCase = SampleUseCase(application.applicationContext)

    val word = MutableLiveData("")
    val shuffledWord = MutableLiveData("")

    fun shuffleWord() {
        word.value?.let {
            shuffledWord.value = sampleUseCase.shuffleWord(it)
        }
    }

    fun saveWord() {
        word.value?.let { origin ->
            shuffledWord.value?.let { shuffled ->
                sampleUseCase.saveWord(origin, shuffled)
                application.applicationContext.showLongToast("保存しました")
            }
        }
    }
}