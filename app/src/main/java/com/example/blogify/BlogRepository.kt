package com.example.blogify

import com.example.blogify.api.BlogPost
import com.example.blogify.api.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BlogRepository {

    suspend fun getBlogPosts(): List<BlogPost> {
        return withContext(Dispatchers.IO) {
            RetrofitInstance.retrofit.getBlogPosts()
        }
    }
}