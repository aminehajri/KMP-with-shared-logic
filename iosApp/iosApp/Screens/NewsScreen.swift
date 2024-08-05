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
        
        NavigationSplitView {
            content
        } detail: {
            Text("Display News details")
        }
        .onAppear {
            newsViewModel.observe()
        }
    }
    
    @ViewBuilder
    private var content: some View {
        if newsViewModel.newsState.loading {
            ProgressView()
        } else if let error = newsViewModel.newsState.error {
            ErrorView(message: error)
        } else if newsViewModel.newsState.news.isEmpty {
            EmptyView()
        } else {
            newsList
        }
    }
    
    private var newsList: some View {
        List(newsViewModel.newsState.news, id: \.id) { item in
            NewsRowView(newsItem: item)
        }
        .navigationTitle("News")
    }
    
}

#Preview {
    NewsScreen(newsViewModel: NewsViewModelWrapper())
}
