package com.example.postapptask.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapptask.common.utils.Response
import com.example.postapptask.data.model.GithubPostItem
import com.example.postapptask.domain.github.usecase.GetGithubReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase
) : ViewModel() {
    private val _postState = mutableStateOf(GithubPostState())
    val postState : State<GithubPostState> = _postState

    init {
        fetchGithubPosts()
    }

    private fun fetchGithubPosts(){
        getGithubReposUseCase().onEach {response ->
            when (response){
                is Response.Loading -> {
                    _postState.value = _postState.value.copy(
                        isLoading = response.status
                    )
                }
                is Response.Success -> {
                    _postState.value = _postState.value.copy(
                        list = response.data
                    )
                }
                is Response.Error -> {

                }
            }
        }.launchIn(viewModelScope)
    }
    data class GithubPostState(
        val isLoading : Boolean = true,
        val list: List<GithubPostItem>? = null
    )

}

