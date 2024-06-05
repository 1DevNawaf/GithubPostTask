package com.example.postapptask.data.remote

import com.example.postapptask.data.model.GithubPost
import com.example.postapptask.data.model.GithubPostsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubRepository{
    @GET("1DevNawaf/repos?per_page=5&page=1")
    suspend fun getGithubPosts(
    ) : List<GithubPost>
}