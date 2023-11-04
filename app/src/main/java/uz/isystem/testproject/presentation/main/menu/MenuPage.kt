package uz.isystem.testproject.presentation.main.menu


import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import uz.isystem.testproject.R
import uz.isystem.testproject.databinding.PageMenuBinding
import uz.isystem.testproject.presentation.adapter.TabAdapter
import uz.isystem.testproject.presentation.base.BaseFragment

class MenuPage : BaseFragment(R.layout.page_menu){
    private val binding by viewBinding(PageMenuBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

        setAdapter()
        setActions()

    }

    private fun setActions() {
        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })
    }

    private fun setAdapter() {
        val adapter = TabAdapter(childFragmentManager,lifecycle)
        binding.viewPager.adapter = adapter
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Пиццы"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Дессерты"))
    }
}
