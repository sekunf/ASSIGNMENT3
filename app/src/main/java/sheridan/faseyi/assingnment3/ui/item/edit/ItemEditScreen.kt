

package sheridan.faseyi.assingnment3.ui.item.edit

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import sheridan.faseyi.assingnment3.ui.common.ShoppingListTopAppBar
import sheridan.faseyi.assingnment3.ui.item.form.ItemFormBody
import sheridan.faseyi.assingnment3.ui.navigation.ItemEditDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    viewModel: ItemEditViewModel,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            ShoppingListTopAppBar(
                title = stringResource(ItemEditDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        ItemFormBody(
            itemFormUiState = viewModel.uiState,
            onNameChange = viewModel::onNameChange,
            onBrandChange = viewModel::onBrandChange,
            onPriorityChange = viewModel::onPriorityChange,

            onSaveClick = {
                viewModel.updateItem()
                navigateBack()
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

