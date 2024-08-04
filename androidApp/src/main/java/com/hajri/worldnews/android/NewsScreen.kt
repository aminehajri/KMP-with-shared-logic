package com.hajri.worldnews.android

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hajri.worldnews.News.NewsItem
import com.hajri.worldnews.News.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(newsViewModel: NewsViewModel) {
    val newsState = newsViewModel.newsState.collectAsState()

    Column {
        TopAppBar(title = { Text(text = "News") })

        if (newsState.value.error != null)
            ErrorMessage(newsState.value.error!!)
        if (newsState.value.news.isNotEmpty())
            NewsListView(newsList = newsState.value.news)
    }
}

@Composable
fun NewsListView(newsList: List<NewsItem>) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(newsList){ item: NewsItem ->
                NewsItemView(newsItem = item)
            }
        }
}

@Composable
fun NewsItemView(newsItem: NewsItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = newsItem.imageUrl,
            contentDescription = "news image"
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = newsItem.title,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = newsItem.description)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = newsItem.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
fun ErrorMessage(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center)
        )
    }
}