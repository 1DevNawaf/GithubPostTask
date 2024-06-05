package com.example.postapptask.domain.github.usecase

import com.example.postapptask.data.model.GithubPostItem
import com.example.postapptask.domain.github.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetGithubReposUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
    operator fun invoke(): Flow<List<GithubPostItem>> = flow{
        val response = githubRepository.getGithubRepos()
        emit(response)
    }
}