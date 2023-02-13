package com.divyanshu.newapp.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.divyanshu.newapp.R
import com.divyanshu.newapp.databinding.FragmentArticleBinding
import com.divyanshu.newapp.extensions.loadImage
import com.divyanshu.newapp.extensions.timestamp

class ArticleFragment : Fragment() {

  private var _binding: FragmentArticleBinding? = null
  lateinit var articleViewModel: ArticleViewModel
  private var articleId: String? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentArticleBinding.inflate(inflater, container, false)
    articleViewModel = ViewModelProvider(this)[ArticleViewModel::class.java]
    articleId = arguments?.getString(resources.getString(R.string.arg_article_id))

    articleId?.let { articleViewModel.fetchArticle(it) }
    Toast.makeText(requireContext(), "opening article $articleId", Toast.LENGTH_SHORT).show()

    return _binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    articleViewModel.article.observe({ lifecycle }) {
      _binding?.apply {
        titleTextView.text = it.title
        bodyTextView.text = it.body
        dateTextView.timestamp = (it.createdAt)
        usernameTextView.text = it.author.username
        dpImageView.loadImage(it.author.image, true)
      }
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    _binding = null
  }

}