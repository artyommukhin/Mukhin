package ru.artyommukhin.developerslife.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Post(
    val id: Int,
    val description: String,
    @SerializedName("gifURL") val gifUrl: String,
) : Parcelable