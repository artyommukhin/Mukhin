package ru.artyommukhin.developerslife.ui.random

import ru.artyommukhin.developerslife.data.RandomGifsRepository
import ru.artyommukhin.developerslife.data.base.BaseGifsRepository
import ru.artyommukhin.developerslife.network.Api
import ru.artyommukhin.developerslife.ui.base.BaseViewModel

class RandomGifsViewModel : BaseViewModel() {
    override val repository = RandomGifsRepository(Api.service::getRandomGif)
}