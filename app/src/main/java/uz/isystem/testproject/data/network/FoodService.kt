package uz.isystem.testproject.data.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.isystem.testproject.data.models.dessert_list.DesertListResponse
import uz.isystem.testproject.data.models.pizza_list.PizzaListResponse

interface FoodService {
    @GET("/pizzas")
    suspend fun getPizzaList():Response<PizzaListResponse?>
    @GET("/desserts")
    suspend fun getDessertList():Response<DesertListResponse?>
}