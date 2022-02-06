package com.example.gamesinfo.presentasion.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamesinfo.databinding.FragmentNewGameBinding
import com.example.gamesinfo.databinding.FragmentPopGameBinding
import com.example.gamesinfo.presentasion.activity.DetailActivity
import com.example.gamesinfo.presentasion.adapter.NewGameAdapter
import com.example.gamesinfo.presentasion.adapter.PopGameAdapter
import com.example.gamesinfo.presentasion.model.NewGame
import com.example.gamesinfo.presentasion.model.PopGame
import com.example.gamesinfo.presentasion.util.convertStringToNew
import com.example.gamesinfo.presentasion.util.convertStringToPop
import com.example.gamesinfo.presentasion.util.readJson

class NewGameFragment: Fragment() {

    private lateinit var binding: FragmentNewGameBinding
    private lateinit var newAdapter: NewGameAdapter

    companion object {
        @JvmStatic
        fun newInstance() =
            NewGameFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewGameBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newAdapter = NewGameAdapter(
            items = convertStringToNew(requireContext().readJson("tv_series.json")).toMutableList(),
            onItemClickedCallback = object : NewGameAdapter.OnItemClickedCallback {
                override fun onItemClicked(data: NewGame) {
                    DetailActivity.start(requireContext(), data)
                }
            }
        )
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding) {
            rvNewGame.apply {
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                newAdapter = NewGameAdapter()
                addItemDecoration(
                    DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
                )
            }
        }
    }
}