package com.example.postapptask.domain.github

import com.example.postapptask.data.model.GithubPostItem

interface GithubRepository {
    suspend fun getGithubRepos(): List<GithubPostItem>
    suspend fun saveGithubRepos(list:List<GithubPostItem>)
}