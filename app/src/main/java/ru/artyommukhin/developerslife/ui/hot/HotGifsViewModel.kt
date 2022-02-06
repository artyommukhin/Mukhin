package ru.artyommukhin.developerslife.ui.hot

import ru.artyommukhin.developerslife.data.PagedGifsRepository
import ru.artyommukhin.developerslife.network.Api
import ru.artyommukhin.developerslife.ui.base.BaseViewModel

class HotGifsViewModel : BaseViewModel() {
    override val repository = PagedGifsRepository(Api.service::getHotGifs)
}