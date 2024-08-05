//
//  ErrorView.swift
//  iosApp
//
//  Created by Amine Hajri on 05.08.24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ErrorView: View {
    
    var message: String
    
    var body: some View {
        Text(message)
            .font(.title)
    }
}

#Preview {
    ErrorView(message: "Oops Something went wrong")
}
