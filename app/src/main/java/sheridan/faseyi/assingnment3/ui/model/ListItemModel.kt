package sheridan.faseyi.assingnment3.ui.model

import sheridan.faseyi.assingnment3.data.local.Priority
import sheridan.faseyi.assingnment3.domain.Item

data class ListItemModel(
    val id: Int,
    val name: String,
    val brand : String,
    val priority: Priority,
    val selected: Boolean
){
    constructor(item: Item): this(
        id = item.id,
        name = item.name,
       brand = item.brand,
        priority = item.priority,
        selected = item.selected

    )

    constructor(): this(Item())
}

fun Item.toListItemModel() = ListItemModel(this)


