package ru.artyommukhin.developerslife.ui.hot


import ru.artyommukhin.developerslife.ui.base.BaseGifsFragment

class HotGifsFragment : BaseGifsFragment<HotGifsViewModel>() {
    override fun getViewModel() = HotGifsViewModel::class.java
}