package sheridan.faseyi.assingnment3.ui.model
import sheridan.faseyi.assingnment3.data.local.Priority
import sheridan.faseyi.assingnment3.domain.Item

data class ItemFormModel(
    val id: Int = 0,
    val name: String = "",
    val brand: String= "",
    val priority: Priority = Priority.HIGH,
    val selected: Boolean = false,
) {
    fun isValid(): Boolean =
        name.isNotBlank()

    fun toItem(): Item = Item(
        id = id,
        name = name,
        brand = brand,
        priority = priority,
        selected = selected,


    )
}

fun Item.toItemFormData(): ItemFormModel = ItemFormModel(
    id = id,
    name = name,
    brand = brand,
    priority = priority,
    selected = selected,

)
