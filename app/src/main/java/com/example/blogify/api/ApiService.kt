package com.example.blogify.api

import retrofit2.http.GET

interface ApiService {
    @GET("wp/v2/posts?per_page=10&page=1")
    suspend fun getBlogPosts(): List<BlogPost>

}