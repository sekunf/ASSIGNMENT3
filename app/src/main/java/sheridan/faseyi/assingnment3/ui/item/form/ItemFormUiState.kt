package sheridan.faseyi.assingnment3.ui.item.form

import sheridan.faseyi.assingnment3.domain.Item
import sheridan.faseyi.assingnment3.ui.model.ItemFormModel
import sheridan.faseyi.assingnment3.ui.model.toItemFormData


data class ItemFormUiState(
    val itemFormModel: ItemFormModel = ItemFormModel(),
    val isEntryValid: Boolean = false
)

fun Item.toItemFormUiState(isEntryValid: Boolean = false): ItemFormUiState =
    ItemFormUiState(
        itemFormModel = this.toItemFormData(),
        isEntryValid = isEntryValid
    )