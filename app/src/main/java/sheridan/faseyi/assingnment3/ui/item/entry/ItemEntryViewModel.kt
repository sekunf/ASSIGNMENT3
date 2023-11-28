

package sheridan.faseyi.assingnment3.ui.item.entry

import androidx.lifecycle.viewModelScope
import sheridan.faseyi.assingnment3.data.local.LocalItem
import sheridan.faseyi.assingnment3.data.repository.ItemsRepository
import sheridan.faseyi.assingnment3.ui.item.form.FormViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemEntryViewModel @Inject constructor(
    private val itemsRepository: ItemsRepository
) : FormViewModel() {


    fun saveItem() = viewModelScope.launch{
        if (uiState.itemFormModel.isValid()) {
            itemsRepository.insertItem(uiState.itemFormModel.toItem())
        }
    }

}

