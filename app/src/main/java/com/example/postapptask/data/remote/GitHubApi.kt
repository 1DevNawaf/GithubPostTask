package com.example.postapptask.data.remote

import com.example.postapptask.data.model.GithubPostItem
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi{
    @GET("1DevNawaf/repos")
    suspend fun getGithubPosts(
        @Query("per_page") itemsPerPage: Int,
        @Query("page") pageNumber: Int
    ): List<GithubPostItem>
}