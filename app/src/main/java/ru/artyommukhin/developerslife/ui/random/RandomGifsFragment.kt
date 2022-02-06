package ru.artyommukhin.developerslife.ui.random

import ru.artyommukhin.developerslife.ui.base.BaseGifsFragment

class RandomGifsFragment: BaseGifsFragment<RandomGifsViewModel>() {

    override fun getViewModel() = RandomGifsViewModel::class.java

}