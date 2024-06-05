package com.example.postapptask.domain.github.usecase

import com.example.postapptask.domain.github.GithubRepository
import javax.inject.Inject

class SaveGithubReposUseCase @Inject constructor(
    private val githubRepository: GithubRepository
) {
//    operator fun invoke(): Flow<List<GithubPostItem>> = flow{
//        val response = githubRepository.getGithubRepos()
//        emit(response)
//    }
}