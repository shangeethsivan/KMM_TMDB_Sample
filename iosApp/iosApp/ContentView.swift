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
            List{
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
                                        .frame(maxWidth: 100, maxHeight: 200)
                                case .failure:
                                    Image(systemName: "Load failed")
                                default:
                                    Image(systemName: "Load failed")
                                }
                            }
                        )
                        VStack(alignment: .leading){
                            Text("**\(movie.title)**")
                            Text(movie.description_)
                        }
                    }
                    
                }
            }
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
