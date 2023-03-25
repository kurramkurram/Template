package io.github.kurramkurram.template.util

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.google.android.material.snackbar.Snackbar

// Preference dataStore
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preference_datastore")

// Toast
fun Context.showShortToast(text: CharSequence) =
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

fun Context.showLongToast(text: CharSequence) =
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()

// Snackbar
fun Context.showShortSnackbar(view: View, text: CharSequence) =
    Snackbar.make(this, view, text, Snackbar.LENGTH_SHORT).show()

fun Context.showLongSnackbar(view: View, text: CharSequence) =
    Snackbar.make(this, view, text, Snackbar.LENGTH_LONG).show()