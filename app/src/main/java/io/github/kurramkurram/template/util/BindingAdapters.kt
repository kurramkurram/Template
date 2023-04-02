package io.github.kurramkurram.template.util

import android.widget.Button
import androidx.databinding.BindingAdapter

/**
 * Binding Adapter.
 * Update UI by data binding.
 */
object BindingAdapters {

    @BindingAdapter(value = ["word"], requireAll = true)
    @JvmStatic
    fun enableButton(button: Button, word: String) {
        button.isEnabled = word.isNotBlank()
    }
}