package org.nssfug.common.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.nssfug.common.domain.usecase.UseCaseExecutor
import org.nssfug.common.presentation.state.ViewState
import org.nssfug.common.presentation.usecase.UseCaseExecutorProvider

abstract class BaseViewModel<VIEW_STATE : ViewState>(
    useCaseExecutorProvider: UseCaseExecutorProvider,
) : ViewModel() {
    val useCaseExecutor: UseCaseExecutor = useCaseExecutorProvider(viewModelScope)

    private val _viewState = MutableLiveData<VIEW_STATE>().apply { value = initialState() }
    val viewState: LiveData<VIEW_STATE>
        get() = _viewState

    fun currentViewState() = viewState.value ?: initialState()
    abstract fun initialState(): VIEW_STATE


    fun updateState(newViewState: VIEW_STATE) {
        _viewState.value = newViewState
    }

    fun updateState(updatedState: (lastState: VIEW_STATE) -> VIEW_STATE) =
        updateState(updatedState(currentViewState()))
}