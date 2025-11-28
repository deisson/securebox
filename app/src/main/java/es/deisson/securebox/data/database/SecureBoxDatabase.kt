package es.deisson.securebox.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import es.deisson.securebox.data.model.SecureItem

@Database(
    entities = [SecureItem::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(SecureBoxConverters::class)
abstract class SecureBoxDatabase : RoomDatabase() {

    abstract fun secureItemDao(): SecureItemDao

    companion object {
        const val DATABASE_NAME: String = "securebox.db"
    }
}
