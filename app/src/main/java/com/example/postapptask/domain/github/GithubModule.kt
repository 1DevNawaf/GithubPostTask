package com.example.postapptask.domain.github

import com.example.postapptask.data.remote.GitHubApi
import com.example.postapptask.data.repository.GithubRepositoryImp
import com.example.postapptask.domain.github.usecase.GetGithubReposUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GithubModule {
    @Provides
    @Singleton
    fun provideGithubRepository(gitHubApi: GitHubApi) : GithubRepository = GithubRepositoryImp(gitHubApi)

    @Provides
    @Singleton
    fun provideGetGithubReposUseCase(githubRepository: GithubRepository) = GetGithubReposUseCase(githubRepository)
}