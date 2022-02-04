package com.khayrul.playground.ui.presentations.main.viewModel

import kotlinx.coroutines.flow.SharedFlow

interface MainViewModel {
    val navigateToFragmentB: SharedFlow<Unit>

    fun onClickButton()
}