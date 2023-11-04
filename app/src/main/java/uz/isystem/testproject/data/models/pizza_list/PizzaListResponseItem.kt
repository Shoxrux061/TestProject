package uz.isystem.testproject.data.models.pizza_list


import com.google.gson.annotations.SerializedName

data class PizzaListResponseItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("quantity")
    val quantity: Int
)