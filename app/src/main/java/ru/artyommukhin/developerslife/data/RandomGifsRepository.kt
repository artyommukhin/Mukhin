package ru.artyommukhin.developerslife.data


import ru.artyommukhin.developerslife.data.base.BaseGifsRepository
import ru.artyommukhin.developerslife.data.model.Post

class RandomGifsRepository(
    val downloadNext: suspend () -> Post
) : BaseGifsRepository() {

    override val allowNext get() = true

    override suspend fun getNext() = downloadNext()
}