package com.example.postapptask.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import retrofit2.Call

@Parcelize
data class GithubPost(
    val id : Int,
    val name : String,
    val owner: Owner
) : Parcelable
@Parcelize
data class Owner(
    val login: String,
    val avatar_url: String
):Parcelable


data class GithubPostsDto(var githubPosts : List<GithubPost>)