package io.github.kurramkurram.template.util

import android.util.Log
import io.github.kurramkurram.template.BuildConfig

/**
 * Log class.
 */
class L {
    companion object {
        private val DEBUG = BuildConfig.DEBUG

        /**
         * output logcat debug on debug variant.
         *
         * @param tag tag
         * @param message message
         */
        fun d(tag: String, message: String) {
            if (DEBUG) {
                Log.d(APP_NAME, tag + message)
            }
        }

        /**
         * output logcat error on debug variant.
         *
         * @param tag tag
         * @param message message
         */
        fun e(tag: String, message: String) {
            if (DEBUG) {
                Log.e(APP_NAME, tag + message)
            }
        }

        /**
         * output logcat warning on debug variant.
         *
         * @param tag tag
         * @param message message
         */
        fun w(tag: String, message: String) {
            if (DEBUG) {
                Log.w(APP_NAME, tag + message)
            }
        }

        /**
         * output logcat info on debug variant.
         *
         * @param tag tag
         * @param message message
         */
        fun i(tag: String, message: String) {
            if (DEBUG) {
                Log.i(APP_NAME, tag + message)
            }
        }

        /**
         * output logcat verbose on debug variant.
         *
         * @param tag tag
         * @param message message
         */
        fun v(tag: String, message: String) {
            if (DEBUG) {
                Log.v(APP_NAME, tag + message)
            }
        }
    }
}