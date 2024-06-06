package com.example.postapptask.common.utils

import androidx.room.TypeConverter
import com.example.postapptask.data.model.GithubPostItem
import com.example.postapptask.data.model.Owner
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromOwner(owner: Owner?): String? {
        return Gson().toJson(owner)
    }

    @TypeConverter
    fun toOwner(ownerString: String?): Owner? {
        return Gson().fromJson(ownerString, Owner::class.java)
    }

    @TypeConverter
    fun fromGithubPostItem(githubPostItem: GithubPostItem?): String? {
        return Gson().toJson(githubPostItem)
    }

    @TypeConverter
    fun toGithubPostItem(githubPostItemString: String?): GithubPostItem? {
        val type = object : TypeToken<GithubPostItem>() {}.type
        return Gson().fromJson(githubPostItemString, type)
    }
}