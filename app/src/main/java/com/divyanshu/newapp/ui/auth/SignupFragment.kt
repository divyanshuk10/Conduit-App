package com.divyanshu.newapp.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.divyanshu.newapp.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {
  private var _binding: FragmentSignupBinding? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentSignupBinding.inflate(inflater, container, false)
    return _binding?.root
  }

  override fun onDestroyView() {
    super.onDestroyView()
  }
}