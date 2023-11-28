

package sheridan.faseyi.assingnment3.ui.item.edit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import sheridan.faseyi.assingnment3.data.repository.ItemsRepository
import sheridan.faseyi.assingnment3.ui.item.form.FormViewModel
import sheridan.faseyi.assingnment3.ui.model.ItemFormModel
import sheridan.faseyi.assingnment3.ui.item.form.toItemFormUiState
import sheridan.faseyi.assingnment3.ui.navigation.ItemEditDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel to retrieve and update an item from the [ItemsRepository]'s data source.
 */
@HiltViewModel
class ItemEditViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val itemsRepository: ItemsRepository
) : FormViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.itemIdArg])

    init {
        viewModelScope.launch {
            uiState = itemsRepository.getItemByIdStream(itemId)
                .filterNotNull()
                .first()
                .toItemFormUiState(isEntryValid = true)
        }
    }


    fun updateItem() = viewModelScope.launch {
        val formData: ItemFormModel = uiState.itemFormModel
        if (formData.isValid()) {
            itemsRepository.updateItem(formData.toItem())
        }
    }
}
