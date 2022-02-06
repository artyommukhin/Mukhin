package ru.artyommukhin.developerslife.data.base

import ru.artyommukhin.developerslife.data.model.Post

abstract class BaseGifsRepository {

    protected val gifCache = mutableListOf<Post>()
    private var cachePos = 0

    protected var page = 0
    protected var pageContents = listOf<Post>()
    protected var pagePos = 0

    val allowPrev get() = cachePos > 0

    suspend fun loadNext(): Post? =
        if (cachePos < gifCache.size - 1) {
            cachePos += 1
            gifCache[cachePos]
        } else {
            val newPost = getNext()
            if (newPost != null) {
                gifCache.add(newPost)
                cachePos = gifCache.size - 1
                newPost
            } else null
        }


    fun loadPrev(): Post {
        cachePos -= 1
        return gifCache[cachePos]
    }

    abstract val allowNext: Boolean

    protected abstract suspend fun getNext(): Post?

}