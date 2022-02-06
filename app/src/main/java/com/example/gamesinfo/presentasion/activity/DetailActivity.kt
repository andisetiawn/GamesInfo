package com.example.gamesinfo.presentasion.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gamesinfo.R
import com.example.gamesinfo.databinding.ActiviyDetailBinding
import com.example.gamesinfo.presentasion.model.NewGame
import com.example.gamesinfo.presentasion.model.PopGame

class DetailActivity: AppCompatActivity() {

    companion object{
        private const val POP_EXTRA = "pop_extra"
        private const val NEW_EXTRA = "new_extra"

        @JvmStatic
        fun start(context: Context, data: PopGame) {

            val starter = Intent(context, DetailActivity::class.java)
                .putExtra(POP_EXTRA, data)
            context.startActivity(starter)
        }

        fun start(context: Context, data: NewGame) {

            val starter = Intent(context, DetailActivity::class.java)
                .putExtra(NEW_EXTRA, data)
            context.startActivity(starter)
        }
    }

    private lateinit var binding: ActiviyDetailBinding
    private var pop: PopGame? = null
    private var new: NewGame? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActiviyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initIntent()
        if(pop != null){
            setPop(pop!!)
        }else{
            setNew(new!!)
        }
    }

    private fun setPop(pop: PopGame) {
        with(binding){
            supportActionBar?.title = pop.title
            imgPoster.setImageResource(R.drawable.ic_baseline_image_24)
            gameTitle.text = pop.title
            gameOverview.text = pop.overview
        }
    }

    private fun setNew(new: NewGame) {
        with(binding){
            supportActionBar?.title = new.title
            imgPoster.setImageResource(R.drawable.ic_baseline_image_24)
            gameTitle.text = new.title
            gameOverview.text = new.overview
        }
    }

    private fun initIntent() {
        pop = intent.getParcelableExtra(POP_EXTRA)
        new = intent.getParcelableExtra(NEW_EXTRA)
    }
}