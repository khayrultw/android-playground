package com.khayrul.playground.ui.presentations.main.viewModel

import androidx.lifecycle.viewModelScope
import com.khayrul.playground.ui.presentations.base.viewModel.BaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class MainViewModelImpl: MainViewModel, BaseViewModel(){
    private val _navigateToFragmentB: MutableSharedFlow<Unit> = MutableSharedFlow()
    override val navigateToFragmentB: SharedFlow<Unit> = _navigateToFragmentB

    override fun onClickButton() {
        viewModelScope.launch {
            _navigateToFragmentB.emit(Unit)
        }
    }
}