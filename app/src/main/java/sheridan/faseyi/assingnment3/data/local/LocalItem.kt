

package sheridan.faseyi.assingnment3.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 */
@Entity(tableName = "items")
data class LocalItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val brand: String,
    val priority: Priority,
    val selected: Boolean
)
