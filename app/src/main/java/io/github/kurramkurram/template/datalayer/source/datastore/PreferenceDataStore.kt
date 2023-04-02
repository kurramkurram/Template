package io.github.kurramkurram.template.datalayer.source.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preference_datastore")

class PreferenceDataStore {
    companion object {

        /**
         * set value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        suspend fun set(context: Context, key: String, value: Any) {
            context.dataStore.edit {
                when (value) {
                    is String -> it[stringPreferencesKey(key)] = value
                    is Int -> it[intPreferencesKey(key)] = value
                    is Double -> it[doublePreferencesKey(key)] = value
                    is Float -> it[floatPreferencesKey(key)] = value
                    is Long -> it[longPreferencesKey(key)] = value
                    is Boolean -> it[booleanPreferencesKey(key)] = value
                    else -> throw ClassCastException()
                }
            }
        }

        /**
         * get string value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: String): Flow<String> =
            context.dataStore.data.map { it[stringPreferencesKey(key)] ?: value }

        /**
         * get integer value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: Int): Flow<Int> =
            context.dataStore.data.map { it[intPreferencesKey(key)] ?: value }

        /**
         * get long value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: Long): Flow<Long> =
            context.dataStore.data.map { it[longPreferencesKey(key)] ?: value }

        /**
         * get double value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: Double): Flow<Double> =
            context.dataStore.data.map { it[doublePreferencesKey(key)] ?: value }

        /**
         * get float value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: Float): Flow<Float> =
            context.dataStore.data.map { it[floatPreferencesKey(key)] ?: value }

        /**
         * get boolean value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: Boolean): Flow<Boolean> =
            context.dataStore.data.map { it[booleanPreferencesKey(key)] ?: value }
    }
}