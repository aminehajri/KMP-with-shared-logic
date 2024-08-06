//
//  NewsDetailsView.swift
//  iosApp
//
//  Created by Amine Hajri on 06.08.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NewsDetailsView: View {
    
    var newsItem: NewsItem
    
    var body: some View {
        VStack {
            VStack(alignment: .leading) {
                AsyncImage(url: URL(string: newsItem.imageUrl)) { content in
                    if let image = content.image {
                        image
                            .resizable()
                            .scaledToFit()
                    }
                }
                
                VStack(alignment: .leading, spacing: 10) {
                    Text(newsItem.title)
                        .bold()
                    
                    
                    HStack {
                        Text(newsItem.publisher)
                        Spacer()
                        Text(newsItem.date)
                    }
                    .font(.subheadline)
                    .foregroundStyle(.secondary)
                    
                    
                    Divider()
                        .padding(.bottom)
                    
                    Text(newsItem.desc)
                }
                .padding()
                
                Spacer()
            }
            .navigationTitle(newsItem.title)
            .navigationBarTitleDisplayMode(.inline)
        }
    }
}
#Preview {
    NewsDetailsView(newsItem: NewsItem(title: "title", desc: "desc", date: "Today", imageUrl: "", publisher: "publisher"))
}
