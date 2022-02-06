package ru.artyommukhin.developerslife.ui.top

import ru.artyommukhin.developerslife.data.PagedGifsRepository
import ru.artyommukhin.developerslife.network.Api
import ru.artyommukhin.developerslife.ui.base.BaseViewModel

class TopGifsViewModel : BaseViewModel() {
    override val repository = PagedGifsRepository(Api.service::getTopGifs)
}