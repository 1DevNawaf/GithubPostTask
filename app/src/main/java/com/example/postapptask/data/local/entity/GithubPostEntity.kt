package com.example.postapptask.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.postapptask.data.model.GithubPostItem

@Entity(tableName = "github_post_table")
data class GithubPostEntity(
    @PrimaryKey val postId: Int?,
    @ColumnInfo(name = "github_post_item") val githubPostItem: GithubPostItem?,
)
