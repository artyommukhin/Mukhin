package ru.artyommukhin.developerslife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import ru.artyommukhin.developerslife.databinding.ActivityMainBinding
import ru.artyommukhin.developerslife.ui.PostsAdapter

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.vpGifs.adapter = PostsAdapter(this)

        TabLayoutMediator(binding.tabs, binding.vpGifs) { tab, position ->
            tab.text = when (position) {
                0 -> "Случайно"
                1 -> "Последние"
                2 -> "Горячие"
                3 -> "Лучшие"
                else -> ""
            }
        }.attach()

    }
}