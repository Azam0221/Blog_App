package com.example.blogify.api

data class BlogPost(
    val id : Int ,
    val title : Rendered,
    val content : Rendered
)

data class Rendered(
    val rendered: String
)