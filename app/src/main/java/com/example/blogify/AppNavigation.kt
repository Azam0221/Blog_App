package com.example.blogify

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blogify.screens.BlogDetailScreen
import com.example.blogify.screens.HomeScreen

@Composable
fun AppNavigation( viewModel: BlogViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "blog_list",
        builder = {
            composable("blog_list"){
                HomeScreen(navController,viewModel)

            }
            composable("blog_detail/{postId}"){ backStackEntry ->
                val postId = backStackEntry.arguments?.getString("postId")?.toInt() ?: 0
                BlogDetailScreen(navController,postId)

            }



        }
    )
}