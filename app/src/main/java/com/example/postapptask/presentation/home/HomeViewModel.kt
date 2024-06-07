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
        getGithubReposUseCase(pageNumber = _postState.value.currentPageNumber).onEach {response ->
            when (response){
                is Response.Loading -> {
                    _postState.value = _postState.value.copy(
                        firstCallErrorText = null,
                        paginationOnProgress = true
                    )
                }
                is Response.Success -> {
                    if(response.data.isEmpty()) onError(Response.Error(1000, "No more data"))
                    else onSuccess(response.data)
                }
                is Response.Error -> {
                    onError(response)
                }
            }
        }.launchIn(viewModelScope)
    }

    private suspend fun onSuccess(data: List<GithubPostItem>){
        val githubPostEntityList : MutableList<GithubPostEntity> = mutableListOf()
        for (entity in data){
            if (entity.id != null) githubPostEntityList.add(GithubPostEntity(postId = entity.id, githubPostItem = entity))
        }
        saveGithubReposUseCase(githubPostEntityList)

        _postState.value = _postState.value.copy(
            list = _postState.value.list + data,
            paginationOnProgress = false
        )
    }

    private suspend fun onError(response: Response.Error<List<GithubPostItem>>){
        val errorMsg = response.errorMsg.ifEmpty { "Unknown Error" }
        Log.d("Response","Error message: $errorMsg Error code: ${response.errorCode}")
        val localList = getLocalGithubReposUseCase()
        _postState.value = _postState.value.copy(
            list = localList,
            paginationErrorText = errorMsg,
            firstCallErrorText = errorMsg
        )
    }


    fun goNextPage(){
        if (_postState.value.paginationOnProgress) return
        _postState.value = _postState.value.copy(currentPageNumber = _postState.value.currentPageNumber+1)
        fetchGithubPosts()
    }


    data class GithubPostState(
        val firstCallErrorText : String? = null,
        val list: List<GithubPostItem> = emptyList(),
        val paginationOnProgress: Boolean = false,
        val paginationErrorText: String? = null,
        val currentPageNumber: Int = 1
    )
}

