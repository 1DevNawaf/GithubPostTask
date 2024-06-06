package com.example.postapptask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.postapptask.common.utils.Converters
import com.example.postapptask.data.local.dao.GithubPostDao
import com.example.postapptask.data.local.entity.GithubPostEntity

@Database(
    entities = [GithubPostEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class GithubPostDataBase: RoomDatabase() {
    abstract fun githubPostDao(): GithubPostDao
}