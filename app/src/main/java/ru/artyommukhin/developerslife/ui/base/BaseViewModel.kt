package ru.artyommukhin.developerslife.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.artyommukhin.developerslife.data.base.BaseGifsRepository
import ru.artyommukhin.developerslife.data.model.Post
import java.lang.Exception

abstract class BaseViewModel : ViewModel() {

    protected abstract val repository: BaseGifsRepository

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> get() = _post

    private val _canReturn = MutableLiveData(false)
    val canReturn: LiveData<Boolean> get() = _canReturn

    private val _isError = MutableLiveData(false)
    val isError: LiveData<Boolean> get() = _isError


    fun loadNext() = viewModelScope.launch {
        _isError.value = false
        try {
            _post.value = repository.loadNext()
        } catch (e: Exception) {
            _isError.value = true
        } finally {
            _canReturn.value = repository.allowPrev
        }
    }

    fun loadPrev() {
        _post.value = repository.loadPrev()
        _canReturn.value = repository.allowPrev
    }
}