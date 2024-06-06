package com.example.postapptask.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.postapptask.data.local.entity.GithubPostEntity

@Dao
interface GithubPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(githubPostEntity: GithubPostEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(githubPostEntity: List<GithubPostEntity>)
    @Query("SELECT * FROM `github_post_table`")
    suspend fun getAllPosts(): List<GithubPostEntity>
    @Query("SELECT * FROM `github_post_table` WHERE postId=:id")
    suspend fun getPostById(id: Int): List<GithubPostEntity>
    @Update
    suspend fun updatePost(githubPostEntity: GithubPostEntity)
    @Delete
    suspend fun deletePost(githubPostEntity: GithubPostEntity)


}