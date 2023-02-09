package com.divyanshu.newapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.divyanshu.newapp.databinding.FragmentSettingsBinding
import com.divyanshu.newapp.ui.auth.AuthViewModel

class SettingsFragment : Fragment() {

  private var _binding: FragmentSettingsBinding? = null
  private val authViewModel by activityViewModels<AuthViewModel>()

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
    authViewModel.user.observe({ lifecycle }) {
      _binding?.apply {
        bioEditText.setText(it?.bio ?: "")
        usernameEditText.setText(it?.username ?: "")
        emailEditText.setText(it?.email ?: "")
        imageEditText.setText(it?.image ?: "")
      }
    }

    _binding?.apply {
      submitButton.setOnClickListener {
        authViewModel.updateUserProfile(
          username = usernameEditText.text.toString().takeIf { it.isNotBlank() },
          bio = bioEditText.text.toString(),
          email = emailEditText.text.toString().takeIf { it.isNotBlank() },
          image = imageEditText.text.toString(),
          password = passwordEditText.text.toString().takeIf { it.isNotBlank() }
        )
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }
}