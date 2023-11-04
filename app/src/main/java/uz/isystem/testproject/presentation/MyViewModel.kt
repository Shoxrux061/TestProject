package uz.isystem.testproject.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.isystem.testproject.data.models.dessert_list.DesertListResponse
import uz.isystem.testproject.data.models.pizza_list.PizzaListResponse
import uz.isystem.testproject.domain.repository.Repository
import uz.isystem.testproject.utills.ResultWrapper
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val successLiveData: MutableLiveData<PizzaListResponse?> =
        MutableLiveData<PizzaListResponse?>()
    val successResponse: LiveData<PizzaListResponse?>
        get() = successLiveData

    private val errorLiveData: MutableLiveData<String?> = MutableLiveData<String?>()
    val errorResponse: LiveData<String?>
        get() = errorLiveData

    fun getPizzaList() {

        viewModelScope.launch {
            when (val result = repository.getPizzaList()) {
                is ResultWrapper.Success -> {
                    successLiveData.postValue(result.data)
                }

                is ResultWrapper.Error -> {
                    errorLiveData.postValue(result.message.toString())
                }

                is ResultWrapper.NetworkError -> {
                    errorLiveData.postValue("No internet")
                }
            }
        }
    }

    private val successDataDessertList: MutableLiveData<DesertListResponse?> =
        MutableLiveData<DesertListResponse?>()
    val successResponseDessertList: LiveData<DesertListResponse?>
        get() = successDataDessertList

    private val errorLiveDataDesertList: MutableLiveData<String?> = MutableLiveData<String?>()
    val errorResponseDesertList: LiveData<String?>
        get() = errorLiveDataDesertList

    fun getDessertList(){
        viewModelScope.launch {
            when(val result = repository.getDessertList()){
                is ResultWrapper.Success -> {
                    successDataDessertList.postValue(result.data)
                }

                is ResultWrapper.Error -> {
                    errorLiveDataDesertList.postValue(result.message.toString())
                }

                is ResultWrapper.NetworkError -> {
                    errorLiveDataDesertList.postValue("No internet")
                }
            }
        }
    }

}