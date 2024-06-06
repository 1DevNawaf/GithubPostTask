package com.example.postapptask.domain.github.usecase

import com.example.postapptask.data.local.dao.GithubPostDao
import com.example.postapptask.data.model.GithubPostItem
import javax.inject.Inject

class GetLocalGithubReposUseCase @Inject constructor(
    private val githubPostDao: GithubPostDao
) {
    suspend operator fun invoke():List<GithubPostItem>{
        val githubEntityList = githubPostDao.getAllPosts().toList()
        val githubPostItemList = mutableListOf<GithubPostItem>()
        for (item in githubEntityList) {
            if (item.githubPostItem != null)
                githubPostItemList.add(item.githubPostItem)
        }
        return githubPostItemList
    }
}