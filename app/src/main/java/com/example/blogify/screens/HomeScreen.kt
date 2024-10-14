package com.example.blogify.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.blogify.BlogViewModel
import com.example.blogify.R
import com.example.blogify.api.BlogPost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController,viewModel: BlogViewModel) {

    Scaffold(

        topBar = {
            Box(modifier = Modifier.
            clip(RoundedCornerShape(bottomStart = 20.dp , bottomEnd = 20.dp))){
            TopAppBar(
                title =   {
                    Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {

                        Text("Blogify", fontSize = 30.sp, fontWeight = FontWeight.Bold,
                            color = Color.Black)

                        Spacer(modifier = Modifier.padding(10.dp))

                    Icon(
                        painter = painterResource(R.drawable.blogs),
                        contentDescription = "Blog",
                        modifier = Modifier.size(50.dp),
                        tint = Color.Black
                    )

                }
            },
                colors = TopAppBarDefaults.topAppBarColors(Color(0xFF66C5F6))
            )}

        }
    ) { innerPadding ->
        Spacer(modifier = Modifier.height(12.dp))

        LaunchedEffect(Unit) {
            viewModel.fetchBlogPost()

        }

        val blogPosts = viewModel.blogPosts.value
        Column(modifier = Modifier.padding(innerPadding)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                       // Start color
                        Color(0xFFB8DF9D),
                        Color(0xFF66C5F6)
                    )
                )
            )){

        LazyColumn {
            items(blogPosts.size) { index ->
                val post = blogPosts[index]
                BlogPostCard(post = post, navController = navController)


                }
            }
            }
        }


}
@Composable
fun BlogPostCard(post: BlogPost, navController: NavController) {
    Card(
        modifier = Modifier
            .height(170.dp)
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { navController.navigate("blog_detail/${post.id}") },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp),

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            //Change
            Text(
                text = "● "+ post.title.rendered,
                fontSize = 20.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}

