//
//  NewsScreen.swift
//  iosApp
//
//  Created by Amine Hajri on 04.08.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NewsScreen: View {
    
    @ObservedObject private(set) var newsViewModel: NewsViewModelWrapper
    
    var body: some View {
        VStack {
            
            if newsViewModel.newsState.loading {
                ProgressView()
            }
            
            if let error = newsViewModel.newsState.error {
                ErrorView(message: error)
            }
            
            if(!newsViewModel.newsState.news.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(newsViewModel.newsState.news, id: \.self) { newsItem in
                            ArticleItemView(newsItem: newsItem)
                        }
                    }
                }
            }
            
        }.onAppear{
            newsViewModel.observe()
        }
    }
}

struct ArticleItemView: View {
    var newsItem: NewsItem
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: newsItem.imageUrl)) { content in
                Group {
                    if let image = content.image {
                        image
                            .resizable()
                            .aspectRatio(contentMode: .fit)
                    } else if content.error != nil {
                        Text("Image Load Error")
                    } else {
                        ProgressView()
                    }
                }
            }
            Text(newsItem.title)
                .font(.title)
                .fontWeight(.bold)
            Text(newsItem.content)
            Text(newsItem.date)
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundColor(.gray)
        }
        .padding(16)
    }
}

struct ErrorView: View {
    var message: String
    
    var body: some View {
        Text(message)
            .font(.title)
    }
}

#Preview {
    NewsScreen(newsViewModel: NewsViewModelWrapper())
}
