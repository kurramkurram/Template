package io.github.kurramkurram.template.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.kurramkurram.template.model.SampleUseCase
import io.github.kurramkurram.template.util.showLongToast

/**
 * Main fragment view model.
 */
class MainViewModel(private val application: Application) : AndroidViewModel(application) {
    private val sampleUseCase: SampleUseCase = SampleUseCase(application.applicationContext)

    val word = MutableLiveData("")

    private val _shuffledWord = MutableLiveData("")
    val shuffledWord: LiveData<String>
        get() = _shuffledWord

    fun shuffleWord() {
        word.value?.let {
            _shuffledWord.value = sampleUseCase.shuffleWord(it)
        }
    }

    fun saveWord() {
        word.value?.let { origin ->
            _shuffledWord.value?.let { shuffled ->
                sampleUseCase.saveWord(origin, shuffled)
                application.applicationContext.showLongToast("保存しました")
            }
        }
    }
}