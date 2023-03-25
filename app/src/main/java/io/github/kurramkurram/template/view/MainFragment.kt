package io.github.kurramkurram.template.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import io.github.kurramkurram.template.databinding.FragmentMainBinding
import io.github.kurramkurram.template.viewmodel.MainViewModel
import io.github.kurramkurram.template.viewmodel.SettingsViewModel

/**
 * Main Fragment.
 *
 * TODO: Update your app's first UI
 */
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMainBinding.inflate(inflater, container, false).apply {
        viewModel = this@MainFragment.viewModel
        lifecycleOwner = viewLifecycleOwner
    }.run { root }
}