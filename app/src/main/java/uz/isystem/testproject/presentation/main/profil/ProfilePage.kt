package uz.isystem.testproject.presentation.main.profil


import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.isystem.testproject.R
import uz.isystem.testproject.databinding.PageProfilBinding
import uz.isystem.testproject.presentation.base.BaseFragment

class ProfilePage : BaseFragment(R.layout.page_profil) {
    private val binding by viewBinding(PageProfilBinding::bind)
    override fun onCreate(view: View, savedInstanceState: Bundle?) {

    }
}

