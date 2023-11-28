package sheridan.faseyi.assingnment3.ui.navigation

import sheridan.faseyi.assingnment3.R

object ItemDetailsDestination : NavigationDestination {
    override val route = "item_details"
    override val titleRes = R.string.item_detail_title
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}