import SwiftUI
import shared
import KMMViewModelSwiftUI

struct ContentView: View {
    
    @StateViewModel var viewModel = MainScreenViewModel()
    
    let greet = Greeting().greet()
    
    var body: some View {
        let uistate = viewModel.uiState.value
        switch uistate{
        case is MainScreenViewModelUiStateLoading: Text("Loading");
        case let uiState2 as MainScreenViewModelUiStateData :
            List {
                ForEach(uiState2.movies, id: \.self){ movie in
                    HStack{
                        AsyncImage(
                            url: URL(string: "\(TMDBApi.companion.IMAGE_BASE_URL)\(movie.imagePath)"),
                            content: { phase in
                                switch phase {
                                case .empty:
                                    ProgressView().fixedSize()
                                case .success(let image):
                                    image.resizable()
                                        .aspectRatio(contentMode: .fit)
                                        .frame(width: 100, height: 150)
                                case .failure:
                                    Image(systemName: "Load failed")
                                default:
                                    Image(systemName: "Load failed")
                                }
                            }
                        )
                        .cornerRadius(5) // Inner corner radius
//                        .padding(5) // Width of the border
                        .background(.clear) // Color of the border
                        .cornerRadius(5)
                        VStack(alignment: .leading){
                            Text("**\(movie.title)**")
                            Text(movie.description_)
                        }
                    }
                    .listRowSeparator(.hidden)
                    .frame(maxHeight: 150)
                    .overlay(
                        RoundedRectangle(cornerRadius: 5)
                            .stroke(.gray, lineWidth: 0.5)
                    )

                }
            }
            .listStyle(.plain)
        case is MainScreenViewModelUiStateError: Text("Error");
        default : Text("Unknown");
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
