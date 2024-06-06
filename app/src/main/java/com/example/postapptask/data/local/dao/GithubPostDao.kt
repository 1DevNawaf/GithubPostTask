package com.example.postapptask.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.postapptask.data.local.entity.GithubPostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GithubPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(githubPostEntity: GithubPostEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(githubPostEntity: List<GithubPostEntity>)
    @Query("SELECT * FROM `github_post_table`")
    fun getAllPosts(): Flow<List<GithubPostEntity>>
    @Query("SELECT * FROM `github_post_table` WHERE postId=:id")
    fun getPostById(id: Int): Flow<List<GithubPostEntity>>
    @Update
    suspend fun updatePost(githubPostEntity: GithubPostEntity)
    @Delete
    suspend fun deletePost(githubPostEntity: GithubPostEntity)


}