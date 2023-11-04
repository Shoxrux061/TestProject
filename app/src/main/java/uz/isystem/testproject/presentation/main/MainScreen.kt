package uz.isystem.testproject.presentation.main


import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.testproject.R
import uz.isystem.testproject.databinding.ScreenMainBinding
import uz.isystem.testproject.presentation.adapter.MainAdapter
import uz.isystem.testproject.presentation.base.BaseFragment

class MainScreen : BaseFragment(R.layout.screen_main){
    private val binding by viewBinding(ScreenMainBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {
        val adapter = MainAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        binding.viewPager.isUserInputEnabled = false

        binding.bottomBar.onItemSelected = { id ->
            when (id) {
                0 -> binding.viewPager.currentItem = 0
                1 -> binding.viewPager.currentItem = 1
                2 -> binding.viewPager.currentItem = 2
            }
        }
    }
}
