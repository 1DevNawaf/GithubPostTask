package com.example.postapptask.data.repository

import com.example.postapptask.common.utils.Response
import com.example.postapptask.data.model.GithubPostItem
import com.example.postapptask.data.remote.GitHubApi
import com.example.postapptask.domain.github.GithubRepository
import retrofit2.HttpException
import javax.inject.Inject

class GithubRepositoryImp @Inject constructor(
    private val gitHubApi: GitHubApi
) : GithubRepository {
    override suspend fun getGithubRepos(): Response<List<GithubPostItem>> {
        try {
            val data=gitHubApi.getGithubPosts()
            return Response.Success(data)
        }catch (e: HttpException){
            return Response.Error(e.code(),e.message())
        }catch (e: Exception){
            return Response.Error(e.hashCode(),e.message.toString())
        }
    }
}