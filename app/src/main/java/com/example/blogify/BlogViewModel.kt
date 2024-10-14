package com.example.blogify

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blogify.api.BlogPost
import kotlinx.coroutines.launch

class BlogViewModel : ViewModel(){
    private val repository = BlogRepository()

    private val _blogPosts  = mutableStateOf<List<BlogPost>>(emptyList())
    val blogPosts : State<List<BlogPost>> = _blogPosts


    fun fetchBlogPost(){
        viewModelScope.launch {
            try {

                val posts = repository.getBlogPosts()
                _blogPosts.value = posts
            } catch (e: Exception){
                e.printStackTrace()

            }
        }
    }


}