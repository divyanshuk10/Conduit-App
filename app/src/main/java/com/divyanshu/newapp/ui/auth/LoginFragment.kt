package com.divyanshu.newapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.divyanshu.newapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
  private var _binding: FragmentLoginBinding? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentLoginBinding.inflate(inflater, container, false)
    return _binding?.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
  }
}