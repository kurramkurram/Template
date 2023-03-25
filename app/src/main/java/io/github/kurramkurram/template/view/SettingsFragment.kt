package io.github.kurramkurram.template.view

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.EXTRA_TITLE
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import io.github.kurramkurram.template.BuildConfig
import io.github.kurramkurram.template.R
import io.github.kurramkurram.template.databinding.FragmentSettingsBinding
import io.github.kurramkurram.template.util.L
import io.github.kurramkurram.template.viewmodel.SettingsViewModel
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.android.synthetic.main.fragment_settings.view.*

/**
 * Settings Fragment.
 */
class SettingsFragment : Fragment(), View.OnClickListener {

    private val viewModel: SettingsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSettingsBinding.inflate(inflater, container, false).apply {
        viewModel = this@SettingsFragment.viewModel
        lifecycleOwner = viewLifecycleOwner
    }.run {
        root.apply {
            app_version_name_tv.text = BuildConfig.VERSION_NAME
            open_source_software_container.setOnClickListener(this@SettingsFragment)
            application_privacy_policy_container.setOnClickListener(this@SettingsFragment)
            question.setOnClickListener(this@SettingsFragment)
        }
    }

    override fun onClick(v: View?) {
        val intent = when (v!!) {
            open_source_software_container -> {
                Intent(requireContext(), OssLicensesMenuActivity::class.java).apply {
                    putExtra(EXTRA_TITLE, resources.getString(R.string.setting_oss))
                }
            }

            application_privacy_policy_container -> {
                Intent(requireContext(), AppActivity::class.java)
            }

            question -> {
                Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("kurram.dev@gmail.com"))
                }
            }
            else -> return
        }

        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            L.e(TAG, "#onClick $e")
        }
    }

    companion object {
        private const val TAG = "SettingsFragment"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SettingsFragment.
         */
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }
}