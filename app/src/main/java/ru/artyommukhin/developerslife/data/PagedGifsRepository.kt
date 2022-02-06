package ru.artyommukhin.developerslife.data

import ru.artyommukhin.developerslife.data.base.BaseGifsRepository
import ru.artyommukhin.developerslife.network.model.ApiListResponse
import ru.artyommukhin.developerslife.data.model.Post

class PagedGifsRepository(
    val downloadNext: suspend (Int) -> ApiListResponse
) : BaseGifsRepository() {

    private var totalCount: Int = 0

    override val allowNext get() = gifCache.size == totalCount

    override suspend fun getNext(): Post? {

        if (pageContents.isEmpty()) {
            if (page == 0)
                downloadNext(page).also {
                    pageContents = it.result
                    totalCount = it.totalCount
                }
            else return null
        }

        if (pagePos == pageContents.size) {
            page += 1
            pagePos = 0
            pageContents = downloadNext(page).result
        }

        val post = pageContents[pagePos]
        pagePos += 1

        return post
    }

}