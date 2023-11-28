

package sheridan.faseyi.assingnment3.data.repository

import kotlinx.coroutines.flow.Flow
import sheridan.faseyi.assingnment3.domain.Item

interface ItemsRepository {

    fun getAllItemsStream(): Flow<List<Item>>


    fun getItemByIdStream(id: Int): Flow<Item?>


    suspend fun insertItem(item: Item)


    suspend fun deleteItem(item: Item)

    suspend fun deleteItemById(id: Int)


    suspend fun updateItem(item: Item)


    suspend fun updateItemSelectedById(id: Int, selected: Boolean)


}
