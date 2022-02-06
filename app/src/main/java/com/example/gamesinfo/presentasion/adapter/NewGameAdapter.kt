package com.example.gamesinfo.presentasion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesinfo.R
import com.example.gamesinfo.databinding.ItemNewGameBinding
import com.example.gamesinfo.presentasion.model.NewGame


class NewGameAdapter (
    private val items: MutableList<NewGame> = mutableListOf(),
    private val onItemClickedCallback: OnItemClickedCallback? = null)
    : RecyclerView.Adapter<NewGameAdapter.NewViewHolder>(){

    private lateinit var binding: ItemNewGameBinding

    inner class NewViewHolder(private val binding: ItemNewGameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: NewGame) {
            this.binding.apply {
                imgPoster.setImageResource(R.drawable.ic_baseline_image_24)
                tvTitle.text = data.title
                root.setOnClickListener {
                    onItemClickedCallback?.onItemClicked(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        binding = ItemNewGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: MutableList<NewGame>) {
        this.items.apply {
            clear()
            addAll(items)
            notifyDataSetChanged()
        }
    }

    interface OnItemClickedCallback{
        fun onItemClicked(data: NewGame)
    }
}