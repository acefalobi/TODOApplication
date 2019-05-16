package com.aceinteract.mvvm.todo.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.aceinteract.mvvm.todo.R
import com.aceinteract.mvvm.todo.view.RecyclerSnapDecorator

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun setupUI() {
        // Decorator set-up
        val cardWidthPixels = (activity?.resources?.displayMetrics?.widthPixels ?: 0) * 0.80f
        val cardHintPercent = 0.01f
//        recyclerView.addItemDecoration(RecyclerSnapDecorator(context!!, cardWidthPixels.toInt(), cardHintPercent))
    }

}
