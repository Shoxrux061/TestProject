package uz.isystem.testproject.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.isystem.testproject.presentation.main.menu.fragments.FragmentDessertList
import uz.isystem.testproject.presentation.main.menu.fragments.FragmentPizzaList

class TabAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0->FragmentPizzaList()
            else->FragmentDessertList()
        }
    }
}