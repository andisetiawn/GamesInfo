package com.example.gamesinfo.presentasion.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamesinfo.databinding.FragmentPopGameBinding
import com.example.gamesinfo.presentasion.activity.DetailActivity
import com.example.gamesinfo.presentasion.adapter.PopGameAdapter
import com.example.gamesinfo.presentasion.model.PopGame
import com.example.gamesinfo.presentasion.util.convertStringToPop
import com.example.gamesinfo.presentasion.util.readJson

class PopGameFragment: Fragment() {

    private lateinit var binding: FragmentPopGameBinding
    private lateinit var popAdapter: PopGameAdapter

    companion object {
        @JvmStatic
        fun newInstance() =
            PopGameFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopGameBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popAdapter = PopGameAdapter(
            items = convertStringToPop(requireContext().readJson("movie.json")).toMutableList(),
            onItemClickedCallback = object : PopGameAdapter.OnItemClickedCallback {
                override fun onItemClicked(data: PopGame) {
                    DetailActivity.start(requireContext(), data)
                }
            }
        )

        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding){
            rvPopGame.apply {
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                popAdapter = PopGameAdapter()
                addItemDecoration(
                    DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
                )
            }
        }
    }




}