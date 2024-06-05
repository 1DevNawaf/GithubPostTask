package com.example.postapptask.presentation.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapptask.data.model.GithubPost
import com.example.postapptask.data.remote.githubPostApiService
import kotlinx.coroutines.launch
import retrofit2.HttpException

class HomeViewModel : ViewModel() {
    private val _postState = mutableStateOf(GithubPostState())
    val postState : State<GithubPostState> = _postState

    init {
        fetchGithubPosts()
    }

    private fun fetchGithubPosts(){
        viewModelScope.launch {
            try {
                val response = githubPostApiService.getGithubPosts()
                _postState.value = _postState.value.copy(
                    list = response,
                    isLoading = false
                )
            } catch (e: HttpException) {
                Log.e("HomeViewModel", "HttpException: ${e.message}")
                // Handle the error
                _postState.value = _postState.value.copy(isLoading = false)
            } catch (e: Exception) {
                Log.e("HomeViewModel", "Exception: ${e.message}")
                // Handle the error
                _postState.value = _postState.value.copy(isLoading = false)
            }
        }
    }
    data class GithubPostState(
        val isLoading : Boolean = true,
        val list: List<GithubPost> = emptyList()
    )

}

