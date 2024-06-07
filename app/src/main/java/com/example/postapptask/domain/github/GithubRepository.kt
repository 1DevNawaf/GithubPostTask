package com.example.postapptask.domain.github

import com.example.postapptask.common.utils.Response
import com.example.postapptask.data.model.GithubPostItem

interface GithubRepository {
    suspend fun getGithubRepos(): Response<List<GithubPostItem>>
}