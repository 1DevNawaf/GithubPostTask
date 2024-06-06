package com.example.postapptask.domain.github.usecase

import com.example.postapptask.data.local.dao.GithubPostDao
import com.example.postapptask.data.local.entity.GithubPostEntity
import javax.inject.Inject

class SaveGithubReposUseCase @Inject constructor(
    private val githubPostDao: GithubPostDao
) {
    suspend operator fun invoke(list: List<GithubPostEntity>){
        githubPostDao.addPost(list)
    }
}