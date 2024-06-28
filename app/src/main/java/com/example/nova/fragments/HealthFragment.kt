package com.example.nova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.nova.Helper
import com.example.nova.R

class HealthFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_health, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewHealth)
        swipeRefreshLayout = view.findViewById(R.id.swiperefresh)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        swipeRefreshLayout.setOnRefreshListener {
            Helper().fetchNews("health", requireContext(), swipeRefreshLayout, recyclerView)
        }
        Helper().fetchNews("health", requireContext(), swipeRefreshLayout, recyclerView)
    }
}