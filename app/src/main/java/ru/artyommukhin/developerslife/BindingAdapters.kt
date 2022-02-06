package ru.artyommukhin.developerslife

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("gifSource")
fun bindGifSource(imageView: ImageView, value: String?) {
    Glide.with(imageView.context)
        .load(value)
        .placeholder(R.drawable.loading_animation)  // во время загрузки
        .error(R.drawable.ic_error)                 // при ошибке
        .fallback(R.drawable.ic_fallback)           // если грузим null
        .into(imageView)
}

@BindingAdapter("android:visibility")
fun bindVisibility(view: View, value: Boolean){
    view.isVisible = value
}

