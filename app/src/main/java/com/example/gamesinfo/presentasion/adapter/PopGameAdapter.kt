package com.example.gamesinfo.presentasion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamesinfo.R
import com.example.gamesinfo.databinding.ItemPopGameBinding
import com.example.gamesinfo.presentasion.model.PopGame

class PopGameAdapter (
    private val items: MutableList<PopGame> = mutableListOf(),
    private val onItemClickedCallback: OnItemClickedCallback? = null)
    : RecyclerView.Adapter<PopGameAdapter.PopViewHolder>(){

    private lateinit var binding: ItemPopGameBinding

    inner class PopViewHolder(private val binding: ItemPopGameBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PopGame) {
            this.binding.apply {
                imgPoster.setImageResource(R.drawable.ic_baseline_image_24)
                tvTitle.text = data.title
                root.setOnClickListener {
                    onItemClickedCallback?.onItemClicked(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopViewHolder {
        binding = ItemPopGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(items: MutableList<PopGame>) {
        this.items.apply {
            clear()
            addAll(items)
            notifyDataSetChanged()
        }
    }

    interface OnItemClickedCallback{
        fun onItemClicked(data: PopGame)
    }
}