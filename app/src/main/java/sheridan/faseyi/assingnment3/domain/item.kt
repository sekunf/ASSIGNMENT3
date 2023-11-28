package sheridan.faseyi.assingnment3.domain

import sheridan.faseyi.assingnment3.data.local.Priority


data class Item(
    val id: Int = 0,
    val name: String = "",
    val brand: String = "",
    val priority: Priority = Priority.HIGH,
    val selected: Boolean = true,
)
