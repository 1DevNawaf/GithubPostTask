package com.example.postapptask.data.remote

import com.example.postapptask.common.utils.BASE_URL
import com.example.postapptask.data.model.GithubPostsDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



private val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create()).build()

val githubPostApiService : GitHubRepository = retrofit.create(GitHubRepository :: class.java)

