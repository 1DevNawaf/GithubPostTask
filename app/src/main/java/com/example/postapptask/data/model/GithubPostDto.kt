package com.example.postapptask.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(

    @field:SerializedName("login")
    val login: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("avatar_url")
    val avatarUrl: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

):Parcelable


@Parcelize
data class GithubPostItem(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("full_name")
    val fullName: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("owner")
    val owner: Owner? = null,

    @field:SerializedName("html_url")
    val htmlUrl: String? = null,

):Parcelable
