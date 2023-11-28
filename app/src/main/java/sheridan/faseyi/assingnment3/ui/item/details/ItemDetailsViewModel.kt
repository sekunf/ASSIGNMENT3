

package sheridan.faseyi.assingnment3.ui.item.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import sheridan.faseyi.assingnment3.data.repository.ItemsRepository
import sheridan.faseyi.assingnment3.ui.navigation.ItemDetailsDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel to retrieve, update and delete an item from the [ItemsRepository]'s data source.
 */
@HiltViewModel
class ItemDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository,
) : ViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle[ItemDetailsDestination.itemIdArg])

    val uiState: StateFlow<ItemDetailsUiState> =
        itemsRepository.getItemByIdStream(itemId)
            .filterNotNull()
            .map { item ->
                ItemDetailsUiState(item)
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ItemDetailsUiState()
            )


    fun deleteItem() = viewModelScope.launch{
        itemsRepository.deleteItemById(uiState.value.item.id)
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

