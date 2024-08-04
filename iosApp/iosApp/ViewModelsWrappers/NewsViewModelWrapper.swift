//
//  NewsViewModelWrapper.swift
//  iosApp
//
//  Created by Amine Hajri on 04.08.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor
class NewsViewModelWrapper: ObservableObject{
        
    let newsViewModel: NewsViewModel
    
    @Published var newsState: NewsState
    
    init() {
        newsViewModel = NewsViewModel()
        newsState = newsViewModel.newsState.value
    }
    
    func observe() {
        Task {
            for await state in newsViewModel.newsState {
                self.newsState = state
            }
        }
    }
}
