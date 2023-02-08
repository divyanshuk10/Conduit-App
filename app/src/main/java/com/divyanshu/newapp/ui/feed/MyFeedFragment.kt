package com.divyanshu.newapp.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.divyanshu.newapp.databinding.FragmentFeedBinding

class MyFeedFragment : Fragment() {

  private var _binding: FragmentFeedBinding? = null
  private lateinit var viewModel: FeedViewModel
  private lateinit var feedAdapter: ArticleFeedAdapter


  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = FragmentFeedBinding.inflate(inflater, container, false)
    feedAdapter = ArticleFeedAdapter()
    _binding?.feedRecyclerView?.layoutManager = LinearLayoutManager(context)
    _binding?.feedRecyclerView?.adapter = feedAdapter
    viewModel = ViewModelProvider(this)[FeedViewModel::class.java]

    return _binding?.root
  }


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    viewModel.fetchMyFeed()
    viewModel.feeds.observe({ lifecycle }) {
      feedAdapter.submitList(it)
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}