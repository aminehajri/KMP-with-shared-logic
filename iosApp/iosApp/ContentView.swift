import SwiftUI
import shared

struct ContentView: View {

	var body: some View {
        NewsScreen(newsViewModel: .init())
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
