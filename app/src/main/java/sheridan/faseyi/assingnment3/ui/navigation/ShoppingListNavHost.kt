

package sheridan.faseyi.assingnment3.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import sheridan.faseyi.assingnment3.ui.home.HomeScreen
import sheridan.faseyi.assingnment3.ui.home.HomeViewModel
import sheridan.faseyi.assingnment3.ui.item.details.ItemDetailsScreen
import sheridan.faseyi.assingnment3.ui.item.details.ItemDetailsViewModel
import sheridan.faseyi.assingnment3.ui.item.edit.ItemEditScreen
import sheridan.faseyi.assingnment3.ui.item.edit.ItemEditViewModel
import sheridan.faseyi.assingnment3.ui.item.entry.ItemEntryScreen
import sheridan.faseyi.assingnment3.ui.item.entry.ItemEntryViewModel


@Composable
fun ShoppingListNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                navigateToItemEntry = { navController.navigate(ItemEntryDestination.route) },
                navigateToItemDetails = { id->
                    navController.navigate("${ItemDetailsDestination.route}/${id}")
                },
                viewModel = viewModel
            )
        }
        composable(route = ItemEntryDestination.route) {
            val viewModel: ItemEntryViewModel = hiltViewModel()
            ItemEntryScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() },
                viewModel = viewModel
            )
        }
        composable(
            route = ItemDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            val viewModel: ItemDetailsViewModel = hiltViewModel()
            ItemDetailsScreen(
                navigateToEditItem = { navController.navigate("${ItemEditDestination.route}/$it") },
                navigateBack = { navController.navigateUp() },
                viewModel = viewModel
            )
        }
        composable(
            route = ItemEditDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            val viewModel: ItemEditViewModel = hiltViewModel()
            ItemEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() },
                viewModel = viewModel
            )
        }
    }
}
