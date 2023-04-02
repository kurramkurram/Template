package io.github.kurramkurram.template.datalayer.source.preference

import android.content.Context

private const val PREFERENCE_KEY = "shared_prefs"

/**
 * SharedPreferences.
 */
class Preference {
    companion object {

        /**
         * set value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun set(context: Context, key: String, value: Any) {
            val prefs = context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)
            with(prefs.edit()) {
                when (value) {
                    is String -> putString(key, value)
                    is Int -> putInt(key, value)
                    is Float -> putFloat(key, value)
                    is Long -> putLong(key, value)
                    is Boolean -> putBoolean(key, value)
                    else -> throw ClassCastException()
                }
                apply()
            }
        }

        /**
         * get string value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: String): String =
            context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE).getString(key, value)
                ?: value

        /**
         * get Integer value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: Int): Int =
            context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE).getInt(key, value)

        /**
         * get Float value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: Float): Float =
            context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE).getFloat(key, value)

        /**
         * get Long value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: Long): Long =
            context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE).getLong(key, value)

        /**
         * get Boolean value.
         *
         * @param context [Context]
         * @param key key
         * @param value value
         */
        fun get(context: Context, key: String, value: Boolean): Boolean =
            context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE)
                .getBoolean(key, value)
    }
}
