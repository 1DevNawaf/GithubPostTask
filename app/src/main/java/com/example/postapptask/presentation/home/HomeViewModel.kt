package com.example.postapptask.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapptask.common.utils.Response
import com.example.postapptask.data.local.entity.GithubPostEntity
import com.example.postapptask.data.model.GithubPostItem
import com.example.postapptask.domain.github.usecase.GetGithubReposUseCase
import com.example.postapptask.domain.github.usecase.GetLocalGithubReposUseCase
import com.example.postapptask.domain.github.usecase.SaveGithubReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGithubReposUseCase: GetGithubReposUseCase,
    private val saveGithubReposUseCase: SaveGithubReposUseCase,
    private val getLocalGithubReposUseCase: GetLocalGithubReposUseCase
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
                    val githubPostEntityList : MutableList<GithubPostEntity> = mutableListOf()
                    for (entity in response.data){
                        if (entity.id != null) githubPostEntityList.add(GithubPostEntity(postId = entity.id, githubPostItem = entity))
                    }

                    _postState.value = _postState.value.copy(
                        list = response.data
                    )
                    Log.d("Me",githubPostEntityList.toString())
                    saveGithubReposUseCase(githubPostEntityList)
                }
                is Response.Error -> {
                    Log.d("Response","Error message: ${response.errorMsg} Error code: ${response.errorCode}")
                    val localList = getLocalGithubReposUseCase()
                    _postState.value = _postState.value.copy(
                        list = localList
                    )
                }
            }
        }.launchIn(viewModelScope)
    }


    data class GithubPostState(
        val isLoading : Boolean = true,
        val list: List<GithubPostItem>? = null,
        val paginationStatus: Boolean = false,
        val currentPageNumber: Int = 1
    )

}

