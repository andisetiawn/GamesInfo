package com.example.gamesinfo.presentasion.activity

import android.content.ActivityNotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import com.example.gamesinfo.R
import com.example.gamesinfo.databinding.ActivityMainBinding
import com.example.gamesinfo.presentasion.fragment.NewGameFragment
import com.example.gamesinfo.presentasion.fragment.PopGameFragment
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            bnvMain.apply {
                setOnItemSelectedListener {
                    val fragment: Fragment = when (it.itemId) {
                        R.id.menu_pop -> {
                            PopGameFragment.newInstance()
                        }
                        R.id.menu_new -> {
                            NewGameFragment.newInstance()
                        }
                        else -> throw IllegalStateException("Menu id unknown")
                    }
                    supportFragmentManager.beginTransaction().replace(R.id.mainContainer, fragment).commit()
                    true
                }
                selectedItemId = R.id.menu_pop
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun onShare() {
        val shareIntent = ShareCompat.IntentBuilder.from(this)
            .setText(getString(R.string.share_text))
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_share -> onShare()
            R.id.menu_about -> AboutActivity.start(this)
            R.id.menu_settings -> SettingActivity.start(this)
            else -> throw IllegalStateException("Menu id unknown")
        }
        return super.onOptionsItemSelected(item)
    }

}