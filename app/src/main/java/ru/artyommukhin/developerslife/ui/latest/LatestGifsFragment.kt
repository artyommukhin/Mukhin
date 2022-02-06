package ru.artyommukhin.developerslife.ui.latest


import ru.artyommukhin.developerslife.ui.base.BaseGifsFragment

class LatestGifsFragment: BaseGifsFragment<LatestGifsViewModel>() {
    override fun getViewModel() = LatestGifsViewModel::class.java
}