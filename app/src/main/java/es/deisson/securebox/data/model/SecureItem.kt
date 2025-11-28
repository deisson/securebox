package es.deisson.securebox.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "secure_items")
data class SecureItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0L,

    @ColumnInfo(name = "type")
    val type: SecureItemType,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "subtitle")
    val subtitle: String? = null,

    @ColumnInfo(name = "category")
    val category: String? = null,

    @ColumnInfo(name = "tags")
    val tags: List<String>? = null,

    @ColumnInfo(name = "primary_secret")
    val primarySecret: String,

    @ColumnInfo(name = "secondary_secret")
    val secondarySecret: String? = null,

    @ColumnInfo(name = "extra_data_encrypted_json")
    val extraDataEncryptedJson: String? = null,

    @ColumnInfo(name = "created_at")
    val createdAt: Long,

    @ColumnInfo(name = "updated_at")
    val updatedAt: Long
)
