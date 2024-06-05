package com.example.postapptask.data.repository

import com.example.postapptask.data.model.GithubPostItem
import com.example.postapptask.data.remote.GitHubApi
import com.example.postapptask.domain.github.GithubRepository
import javax.inject.Inject

class GithubRepositoryImp @Inject constructor(
    private val gitHubApi: GitHubApi
) : GithubRepository {
    override suspend fun getGithubRepos(): List<GithubPostItem> {
        val response=gitHubApi.getGithubPosts()
        return response
    }

    override suspend fun saveGithubRepos(list: List<GithubPostItem>) {
        TODO("Not yet implemented")
    }
}