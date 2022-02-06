package ru.artyommukhin.developerslife.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.artyommukhin.developerslife.ui.hot.HotGifsFragment
import ru.artyommukhin.developerslife.ui.latest.LatestGifsFragment
import ru.artyommukhin.developerslife.ui.random.RandomGifsFragment
import ru.artyommukhin.developerslife.ui.top.TopGifsFragment

class PostsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {

        val fragment = when (position) {
            0 -> RandomGifsFragment()
            1 -> LatestGifsFragment()
            2 -> HotGifsFragment()
            3 -> TopGifsFragment()
            else -> null
        }
        return fragment!!
    }
}