package es.deisson.securebox.data.database

import androidx.room.TypeConverter
import es.deisson.securebox.data.model.SecureItemType

class SecureBoxConverters {

    @TypeConverter
    fun fromSecureItemType(value: SecureItemType): String =
        value.name

    @TypeConverter
    fun toSecureItemType(value: String): SecureItemType =
        SecureItemType.valueOf(value)

    @TypeConverter
    fun fromTagsList(list: List<String>?): String? =
        list?.joinToString(separator = "|")

    @TypeConverter
    fun toTagsList(data: String?): List<String>? =
        data
            ?.takeIf { it.isNotBlank() }
            ?.split("|")
}
