package com.example.postapptask.presentation.details

import androidx.lifecycle.ViewModel
import com.example.postapptask.data.model.GithubPostItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(): ViewModel() {
    private val _postState = MutableStateFlow(GithubPostItemState())
    val postState : StateFlow<GithubPostItemState> = _postState

    fun setGithubPostItem(githubPostItem: GithubPostItem?){
        _postState.value = _postState.value.copy(githubPostItem = githubPostItem)
    }

    data class GithubPostItemState(
        val githubPostItem: GithubPostItem? = null
    )
}