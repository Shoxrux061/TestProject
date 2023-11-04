package uz.isystem.testproject.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.isystem.testproject.presentation.main.korzina.KorzinaPage
import uz.isystem.testproject.presentation.main.menu.MenuPage
import uz.isystem.testproject.presentation.main.profil.ProfilePage

class MainAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MenuPage()
            1-> ProfilePage()
            else-> KorzinaPage()
        }
    }
}