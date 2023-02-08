package com.divyanshu.newapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.divyanshu.newapp.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

  private var _binding: FragmentSettingsBinding? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentSettingsBinding.inflate(inflater, container, false)

    return _binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}