package sheridan.faseyi.assingnment3.ui.item.form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import sheridan.faseyi.assingnment3.R
import sheridan.faseyi.assingnment3.data.local.Priority

@Composable
fun ItemFormBody(
    itemFormUiState: ItemFormUiState,
    onNameChange: (String) -> Unit,
    onBrandChange: (String) -> Unit,
    onPriorityChange: (Priority) -> Unit,

    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large))
    ) {
        ItemForm(
            itemFormModel = itemFormUiState.itemFormModel,
            onNameChange = onNameChange,
            onBrandChange = onBrandChange,
            onPriorityChange = onPriorityChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            enabled = itemFormUiState.isEntryValid,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.save_action))
        }
    }
}