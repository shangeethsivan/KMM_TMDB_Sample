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
            let moviesString = uiState2.movies.map({$0.title}).joined(separator : ",")
            Text(moviesString)
        case is MainScreenViewModelUiStateError: Text("Error");
        default : Text("Unknown");
        }
        Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
