package sheridan.faseyi.assingnment3.ui.navigation

import sheridan.faseyi.assingnment3.R

object ItemEditDestination : NavigationDestination {
    override val route = "item_edit"
    override val titleRes = R.string.edit_item_title
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}