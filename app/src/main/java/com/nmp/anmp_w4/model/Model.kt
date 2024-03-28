package com.nmp.anmp_w4.model

import com.google.gson.annotations.SerializedName

data class Student(
    val id:String?,
    @SerializedName("student_name")
    val name:String?,
    @SerializedName("birth_of_date")
    val dob:String?,
    val phone:String?,
    @SerializedName("photo_url")
    val photoUrl:String
)

data class Game(
    val id: Int,
    val title: String,
    val genre: String,
    val platforms: List<String>,
    val developer: Developer,
    val images: String
)

data class Developer(
    val name: String,
    val country: String
)