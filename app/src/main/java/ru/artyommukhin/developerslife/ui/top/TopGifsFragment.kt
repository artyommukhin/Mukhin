package ru.artyommukhin.developerslife.ui.top


import ru.artyommukhin.developerslife.ui.base.BaseGifsFragment

class TopGifsFragment: BaseGifsFragment<TopGifsViewModel>() {
    override fun getViewModel() = TopGifsViewModel::class.java
}