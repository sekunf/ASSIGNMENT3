package sheridan.faseyi.assingnment3.ui.item.details

import sheridan.faseyi.assingnment3.data.local.Priority
import sheridan.faseyi.assingnment3.domain.Item
import sheridan.faseyi.assingnment3.ui.model.ItemDetailsModel
import sheridan.faseyi.assingnment3.ui.model.toItemDetailsModel



data class ItemDetailsUiState(
    val priority: Priority,
    val item: ItemDetailsModel
){
    constructor(item: Item): this (
        priority  = Priority.LOW,
        item = item.toItemDetailsModel()
    )

    constructor(): this(Item())
}