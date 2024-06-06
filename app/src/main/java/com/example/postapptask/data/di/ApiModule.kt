package com.example.postapptask.data.di

import com.example.postapptask.data.remote.GitHubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    @Singleton
    fun provideGithubPostApi(retrofit: Retrofit): GitHubApi = retrofit.create(GitHubApi :: class.java)

//    @Provides
//    @Singleton
//    fun provideGithubPostDao(retrofit: Retrofit): GithubPostDao = retrofit.create(GitHubApi :: class.java)
}