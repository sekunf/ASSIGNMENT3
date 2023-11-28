package sheridan.faseyi.assingnment3.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import sheridan.faseyi.assingnment3.data.local.DataConverters
import sheridan.faseyi.assingnment3.data.local.ItemDao
import sheridan.faseyi.assingnment3.data.local.LocalItem

/**
 * Database class with a singleton Instance object.
 */
@Database(entities = [LocalItem::class], version = 2, exportSchema = false)
@TypeConverters(DataConverters::class)
abstract class ShoppingListDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemDao
}
