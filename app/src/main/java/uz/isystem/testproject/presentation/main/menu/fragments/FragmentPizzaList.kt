package uz.isystem.testproject.presentation.main.menu.fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.testproject.R
import uz.isystem.testproject.data.room.ArticleRoomModel
import uz.isystem.testproject.data.room.PizzaRoomModel
import uz.isystem.testproject.data.room.RoomDataBase
import uz.isystem.testproject.databinding.FragmentPizzaListBinding
import uz.isystem.testproject.presentation.MyViewModel
import uz.isystem.testproject.presentation.adapter.CachePizzaAdapter
import uz.isystem.testproject.presentation.adapter.PizzaAdapter
import uz.isystem.testproject.presentation.base.BaseFragment

class FragmentPizzaList : BaseFragment(R.layout.fragment_pizza_list) {
    private val binding by viewBinding(FragmentPizzaListBinding::bind)
    private val adapter = PizzaAdapter()
    private val cacheAdapter = CachePizzaAdapter()
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(view: View, savedInstanceState: Bundle?) {
        setAdapter()
        viewModel.getPizzaList()
        observe()
    }

    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
        binding.recyclerViewCache.adapter = cacheAdapter
    }

    private fun observe() {
        viewModel.successResponse.observe(viewLifecycleOwner) {

            adapter.setData(it!!)
            RoomDataBase.getInstance()!!.deleteAllPizzas()
            for (i in 0 until it.size) {
                val data = PizzaRoomModel(
                    id = it[i].id,
                    price = it[i].price,
                    img = it[i].img,
                    description = it[i].description,
                    name = it[i].name,
                    quantity = it[i].quantity
                )
                RoomDataBase.getInstance()!!.addPizza(data)
            }
        }
        viewModel.errorResponse.observe(viewLifecycleOwner) {
            binding.recyclerView.visibility = View.GONE
            binding.recyclerViewCache.visibility = View.VISIBLE
            cacheAdapter.setData(RoomDataBase.getInstance()!!.getAllSavedPizzas())
        }
    }
}
