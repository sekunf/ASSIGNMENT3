package sheridan.faseyi.assingnment3.data.local

import androidx.room.TypeConverter

class DataConverters {

    @TypeConverter
    fun convertPriorityToInt(priority: Priority): Int{
        return priority.ordinal
    }

    @TypeConverter

    fun convertIntToPriority(index: Int): Priority {
        return Priority.values()[index]
    }
}
