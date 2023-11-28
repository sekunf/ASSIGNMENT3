

package sheridan.faseyi.assingnment3.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import sheridan.faseyi.assingnment3.data.repository.ItemsRepository
import sheridan.faseyi.assingnment3.ui.model.ListItemModel
import sheridan.faseyi.assingnment3.ui.model.toListItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val itemsRepository: ItemsRepository
) : ViewModel() {


    val homeUiState: StateFlow<HomeUiState> =
        itemsRepository.getAllItemsStream()
            .map { list -> HomeUiState(list.map { item -> item.toListItemModel() }) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )

    fun toggleSelect(item: ListItemModel) {
        viewModelScope.launch {
                itemsRepository.updateItemSelectedById(item.id, !item.selected)
        }
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

