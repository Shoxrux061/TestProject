package uz.isystem.testproject.presentation.main.menu.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.testproject.R
import uz.isystem.testproject.data.room.ArticleRoomModel
import uz.isystem.testproject.data.room.RoomDataBase
import uz.isystem.testproject.databinding.FragmentDessertListBinding
import uz.isystem.testproject.presentation.MyViewModel
import uz.isystem.testproject.presentation.adapter.CacheDessertAdapter
import uz.isystem.testproject.presentation.adapter.DesertAdapter
import uz.isystem.testproject.presentation.base.BaseFragment

class FragmentDessertList : BaseFragment(R.layout.fragment_dessert_list) {
    private val binding by viewBinding(FragmentDessertListBinding::bind)
    private val adapter = DesertAdapter()
    private val cacheAdapter = CacheDessertAdapter()
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(view: View, savedInstanceState: Bundle?) {
        setAdapter()
        viewModel.getDessertList()
        observe()
    }

    private fun observe() {
        viewModel.successResponseDessertList.observe(viewLifecycleOwner) {

            adapter.setData(it!!)

            RoomDataBase.getInstance()!!.deleteAllDesserts()
            for (i in 0 until it.size) {
                val data = ArticleRoomModel(
                    id = it[i].id,
                    price = it[i].price,
                    img = it[i].img,
                    description = it[i].description,
                    name = it[i].name,
                    quantity = it[i].quantity
                )
                RoomDataBase.getInstance()!!.addDeserts(data)
            }
        }
        viewModel.errorResponseDesertList.observe(viewLifecycleOwner) {
            binding.recyclerView.visibility = View.GONE
            binding.recyclerViewCache.visibility = View.VISIBLE
            cacheAdapter.setData(RoomDataBase.getInstance()!!.getAllSavedDesserts())
        }

    }
    private fun setAdapter() {
        binding.recyclerView.adapter = adapter
        binding.recyclerViewCache.adapter = cacheAdapter
    }
}

