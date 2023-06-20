package org.nssfug.common.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import org.nssfug.common.presentation.BaseViewModel
import org.nssfug.common.presentation.state.ViewState

@Composable
fun <VIEW_STATE: ViewState> BaseViewModel<VIEW_STATE>.getState() = viewState.observeAsState(initial = initialState())