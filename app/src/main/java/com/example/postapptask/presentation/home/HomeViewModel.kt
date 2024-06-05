package com.example.postapptask.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
//        viewModelScope.launch {
//            try {
//                val response = githubPostApiService.getGithubPosts()
//                _postState.value = _postState.value.copy(
//                    list = response,
//                    isLoading = false
//                )
//            } catch (e: HttpException) {
//                Log.e("HomeViewModel", "HttpException: ${e.message}")
//                _postState.value = _postState.value.copy(isLoading = false)
//            } catch (e: Exception) {
//                Log.e("HomeViewModel", "Exception: ${e.message}")
//                _postState.value = _postState.value.copy(isLoading = false)
//            }
//        }

        getGithubReposUseCase().onEach {
            _postState.value = _postState.value.copy(
                    list = it,
                    isLoading = false
            )
        }.launchIn(viewModelScope)
    }
    data class GithubPostState(
        val isLoading : Boolean = true,
        val list: List<GithubPostItem>? = null
    )

}

