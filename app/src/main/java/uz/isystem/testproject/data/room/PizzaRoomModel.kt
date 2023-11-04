package uz.isystem.testproject.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Pizza")
data class PizzaRoomModel(
    @PrimaryKey
    @ColumnInfo("id") val id: Int,
    @ColumnInfo("img") val img: String,
    @ColumnInfo("price") val price: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("quantity") val quantity: Int,
    @ColumnInfo("description") val description: String
)