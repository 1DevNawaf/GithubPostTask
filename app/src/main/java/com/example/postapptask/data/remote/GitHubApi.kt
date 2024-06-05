package com.example.postapptask.data.remote

import com.example.postapptask.data.model.GithubPostItem
import retrofit2.http.GET

interface GitHubApi{
    @GET("1DevNawaf/repos?per_page=5&page=1")
    suspend fun getGithubPosts(
    ) : List<GithubPostItem>
}