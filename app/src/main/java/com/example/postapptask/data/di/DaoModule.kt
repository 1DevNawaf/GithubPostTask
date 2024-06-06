package com.example.postapptask.data.di

import android.content.Context
import androidx.room.Room
import com.example.postapptask.data.local.GithubPostDataBase
import com.example.postapptask.data.local.dao.GithubPostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    @Singleton
    fun provideGithubPostDao(database: GithubPostDataBase): GithubPostDao = database.githubPostDao()

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): GithubPostDataBase {
        return Room.databaseBuilder(
            context,
            GithubPostDataBase::class.java,
            "GithubPostDatabase"
        ).build()
    }

}