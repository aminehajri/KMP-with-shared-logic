//
//  NewsRowView.swift
//  iosApp
//
//  Created by Amine Hajri on 05.08.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NewsRowView: View {
    var newsItem: NewsItem
    
    var body: some View {
        VStack(alignment: .leading, spacing: 10) {
            AsyncImage(url: URL(string: newsItem.imageUrl)) { content in
                Group {
                    if let image = content.image {
                        image
                            .resizable()
                            .scaledToFit()
                    }
                }
            }
            Text(newsItem.title)
            Text(newsItem.date)
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundStyle(.gray)
        }
        
    }
}

extension NewsItem: Identifiable {}

#Preview {
    NewsRowView(newsItem: .init(title: "title", desc: "desc", date: "Today", imageUrl: "", publisher: "publisher name"))
}
