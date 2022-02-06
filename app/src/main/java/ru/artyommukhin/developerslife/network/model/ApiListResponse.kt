package ru.artyommukhin.developerslife.network.model

import ru.artyommukhin.developerslife.data.model.Post

data class ApiListResponse(
    val result: List<Post>,
    val totalCount: Int
)