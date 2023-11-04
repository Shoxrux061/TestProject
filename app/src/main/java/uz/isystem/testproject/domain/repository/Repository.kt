package uz.isystem.testproject.domain.repository

import kotlinx.coroutines.Dispatchers
import uz.isystem.testproject.data.models.dessert_list.DesertListResponse
import uz.isystem.testproject.data.models.pizza_list.PizzaListResponse
import uz.isystem.testproject.data.network.FoodService
import uz.isystem.testproject.utills.ResultWrapper
import uz.isystem.testproject.utills.parseResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val service: FoodService) {

    suspend fun getPizzaList(): ResultWrapper<PizzaListResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getPizzaList()
        }
    }

    suspend fun getDessertList(): ResultWrapper<DesertListResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getDessertList()
        }
    }
}