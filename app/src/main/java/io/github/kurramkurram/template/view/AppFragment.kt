package io.github.kurramkurram.template.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.kurramkurram.template.R
import kotlinx.android.synthetic.main.fragment_app.*

/**
 * Application Privacy Policy Fragment.
 */
class AppFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_app, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webview.loadUrl("file:///android_asset/app.html")
    }
}