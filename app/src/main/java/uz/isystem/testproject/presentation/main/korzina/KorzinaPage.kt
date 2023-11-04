package uz.isystem.testproject.presentation.main.korzina


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.testproject.R
import uz.isystem.testproject.databinding.PageKorzinaBinding
import uz.isystem.testproject.presentation.adapter.MainAdapter
import uz.isystem.testproject.presentation.base.BaseFragment

class KorzinaPage : BaseFragment(R.layout.page_korzina){
    private val binding by viewBinding(PageKorzinaBinding::bind)
    lateinit var viewPager : ViewPager2
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

    }
}
