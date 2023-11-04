package uz.isystem.testproject.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RoomDao {

    @Query("SELECT * FROM dessert")
    fun getAllSavedDesserts(): List<ArticleRoomModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addDeserts(data: ArticleRoomModel)

    @Query("DELETE FROM dessert")
    fun deleteAllDesserts()

    @Query("DELETE FROM pizza")
    fun deleteAllPizzas()

    @Insert(PizzaRoomModel::class , onConflict = OnConflictStrategy.IGNORE)
    fun addPizza(data:PizzaRoomModel)

    @Query("SELECT * FROM pizza")
    fun getAllSavedPizzas():List<PizzaRoomModel>

}