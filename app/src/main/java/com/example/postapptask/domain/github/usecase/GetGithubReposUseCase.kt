package com.example.postapptask.domain.github.usecase

import com.example.postapptask.common.utils.Response
import com.example.postapptask.data.model.GithubPostItem
import com.example.postapptask.domain.github.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetGithubReposUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    operator fun invoke(pageNumber: Int = 1,itemPerPage: Int = 5): Flow<Response<List<GithubPostItem>>> = flow{
        emit(Response.Loading(status = true))
        val response = githubRepository.getGithubRepos(pageNumber = pageNumber, itemPerPage)
        emit(Response.Loading(status = false))
        emit(response)
    }
}