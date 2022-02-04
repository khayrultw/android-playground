package com.khayrul.playground.ui.presentations.main
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import com.khayrul.playground.R
import com.khayrul.playground.databinding.FragmentMainBinding
import com.khayrul.playground.ui.presentations.base.BaseFragment
import com.khayrul.playground.ui.presentations.main.viewModel.MainViewModelImpl

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override val viewModel by viewModels<MainViewModelImpl>()

    override fun getLayoutResource(): Int {
        return R.layout.fragment_main
    }

    override fun onBindView(view: View, savedInstanceState: Bundle?) {
        super.onBindView(view, savedInstanceState)
        binding?.button?.setOnClickListener {
            viewModel.onClickButton()
        }
    }

    override fun onBindData(view: View) {
        super.onBindData(view)
        viewModel.navigateToFragmentB.asLiveData().observe(viewLifecycleOwner) {
            val action = MainFragmentDirections.actionFragmentMainToFragmentB()
            navController.navigate(action)
        }
    }
}