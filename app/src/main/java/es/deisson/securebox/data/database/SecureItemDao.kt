package es.deisson.securebox.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import es.deisson.securebox.data.model.SecureItem
import es.deisson.securebox.data.model.SecureItemType
import kotlinx.coroutines.flow.Flow

@Dao
interface SecureItemDao {

    @Query("SELECT * FROM secure_items ORDER BY title COLLATE NOCASE ASC")
    fun getAllItems(): Flow<List<SecureItem>>

    @Query("SELECT * FROM secure_items WHERE type = :type ORDER BY title COLLATE NOCASE ASC")
    fun getItemsByType(type: SecureItemType): Flow<List<SecureItem>>

    @Query("SELECT * FROM secure_items WHERE id = :id LIMIT 1")
    suspend fun getItemById(id: Long): SecureItem?

    @Query(
        """
        SELECT * FROM secure_items
        WHERE 
            title LIKE '%' || :query || '%' OR
            subtitle LIKE '%' || :query || '%' OR
            category LIKE '%' || :query || '%'
        ORDER BY title COLLATE NOCASE ASC
        """
    )
    fun searchItems(query: String): Flow<List<SecureItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: SecureItem): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<SecureItem>): List<Long>

    @Update
    suspend fun update(item: SecureItem)

    @Delete
    suspend fun delete(item: SecureItem)

    @Query("DELETE FROM secure_items WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM secure_items")
    suspend fun deleteAll()
}
