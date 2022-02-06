package ru.artyommukhin.developerslife.ui.latest

import ru.artyommukhin.developerslife.data.PagedGifsRepository
import ru.artyommukhin.developerslife.network.Api
import ru.artyommukhin.developerslife.ui.base.BaseViewModel

class LatestGifsViewModel : BaseViewModel() {
    override val repository = PagedGifsRepository(Api.service::getLatestGifs)
}